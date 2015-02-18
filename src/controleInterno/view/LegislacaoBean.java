package controleInterno.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.service.LegislacaoService;
import controleInterno.service.TipoLegislacaoService;
import controleInterno.model.Legislacao;
import controleInterno.model.TipoLegislacao;

@Scope("request")
@Component
@ManagedBean(name = "legislacaoBean")
public class LegislacaoBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Legislacao legislacao;
	@Autowired
	private LegislacaoService legislacaoRN;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Legislacao> lista;
	private List<TipoLegislacao> listaTipoLegislacao;
	@Autowired
	TipoLegislacaoService tipoLegislacaoRN;

	private TipoLegislacao tipoLegislacao;

	private Date periodoInicial;
	private Date periodoFinal;

	private String conteudo;

	public LegislacaoBean() {

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (legislacao.getId() != 0) {
				try {
					legislacaoRN.altera(legislacao);

					Util.msgSucesso("Dados alterados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					legislacaoRN.adiciona(legislacao);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

			}
		}

	}

	public void excluir() {

		try {
			legislacaoRN.exclui(legislacao);
			lista = legislacaoRN.lista();
			Util.msgSucesso("Registro excluido com sucesso!",
					"Cadastro atualizado!");
			legislacao = new Legislacao();
		} catch (Exception e) {
			Util.msgErro("Erro na exclusão:", e.toString());

		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (legislacao.getTipoLegislacao() == null) {
			Util.msgErro("Tipo de Legislação:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (legislacao.getData() == null) {
			Util.msgErro("Data", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (legislacao.getNumero() == null || legislacao.getNumero().isEmpty()) {
			Util.msgErro("Número", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (legislacao.getTexto() == null || legislacao.getTexto().isEmpty()) {
			Util.msgErro("Texto", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}

		return retorno;
	}

	public Legislacao getLegislacao() {
		if (legislacao == null)
			legislacao = new Legislacao();
		return legislacao;
	}

	public void setLegislacao(Legislacao legislacao) {
		this.legislacao = legislacao;
	}

	public List<Legislacao> getLista() {
		
		return lista;
	}

	public void setLista(List<Legislacao> lista) {
		this.lista = lista;
	}

	public String editar() {
		return "/controleInterno/cadastros/legislacao.jsf";

	}

	public List<TipoLegislacao> getListaTipoLegislacao() {
		if (listaTipoLegislacao == null) {
			listaTipoLegislacao = tipoLegislacaoRN.lista();
		}
		return listaTipoLegislacao;
	}

	public void setListaTipoLegislacao(List<TipoLegislacao> listaTipoLegislacao) {
		this.listaTipoLegislacao = listaTipoLegislacao;
	}

	public LegislacaoService getLegislacaoRN() {
		return legislacaoRN;
	}

	public void setLegislacaoRN(LegislacaoService legislacaoRN) {
		this.legislacaoRN = legislacaoRN;
	}

	public TipoLegislacaoService getTipoLegislacaoRN() {
		return tipoLegislacaoRN;
	}

	public void setTipoLegislacaoRN(TipoLegislacaoService tipoLegislacaoRN) {
		this.tipoLegislacaoRN = tipoLegislacaoRN;
	}

	public TipoLegislacao getTipoLegislacao() {
		return tipoLegislacao;
	}

	public void setTipoLegislacao(TipoLegislacao tipoLegislacao) {
		this.tipoLegislacao = tipoLegislacao;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMSG_ERRO_NAO_PREENCHIMENTO_CAMPOS() {
		return MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS;
	}

	public void pesquisar() {
		
		
		if (getConteudo() != null && getConteudo().isEmpty()) {
			setConteudo(null);
		}

		this.lista = new ArrayList<Legislacao>();
		if (camposPesquisasOk()) {
			this.lista = legislacaoRN.pesquisar(getPeriodoInicial(), getPeriodoFinal(), getTipoLegislacao(), getConteudo());
		}
	}
	
	private boolean camposPesquisasOk() {
		if (getPeriodoFinal() != null && getPeriodoInicial() != null) {
			if (getPeriodoFinal().getTime() < getPeriodoInicial().getTime()) {
				Util.msgErro("Periodo Inválido!", "");
				return false;
			}
		}
		return true;
	}

	public String incluir() {
		legislacao = new Legislacao();
		return "/controleInterno/cadastros/legislacao.jsf";
	}
	
	public String voltar() {
		return "/controleInterno/cadastros/pesquisaLegislacao.jsf";
	}

}
