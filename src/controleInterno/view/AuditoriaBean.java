package controleInterno.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.service.AuditoriaService;
import controleInterno.model.Auditoria;
import controleInterno.model.Arquivo;
import controleInterno.model.AuditoriaDocumento;
import controleInterno.model.Irregularidade;
import controleInterno.model.Legislacao;
import controleInterno.service.ArquivoService;
import controleInterno.service.AuditoriaDocumentoService;
import controleInterno.service.IrregularidadeService;
import controleInterno.service.LegislacaoService;

@Scope("session")
@Component
@ManagedBean(name = "auditoriaBean")
public class AuditoriaBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Auditoria auditoria;
	@Autowired
	private AuditoriaService auditoriaRN;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Auditoria> lista;
	private List<Irregularidade> listaIrregularidade;
	private List<Legislacao> listaLegislacao;
	@Autowired
	private IrregularidadeService irregularidadesRN;
	@Autowired
	private LegislacaoService legislacaoRN;
	private List<Arquivo> listaArquivo;
	private List<AuditoriaDocumento> listaAuditoriaDocumento;
	private Date periodoInicial;
	private Date periodoFinal;
	@Autowired
	private ArquivoService arquivoService;
	@Autowired
	private AuditoriaDocumentoService auditoriaDocumentoService;
	
	public AuditoriaBean() {
		this.lista = null;
		this.periodoFinal = null;
		this.periodoInicial = null;
		
	}
	

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (auditoria.getId() != null && auditoria.getId() != 0) {
				try {
					auditoriaRN.altera(auditoria);

					Util.msgSucesso("Dados alterados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					auditoriaRN.adiciona(auditoria);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

				
			}
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;

		return retorno;
	}

	public Auditoria getAuditoria() {
		if (auditoria == null) auditoria = new Auditoria();
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public List<Auditoria> getLista() {
		if (lista==null) {
			lista = auditoriaRN.lista();
		}
		return lista;
	}

	public void setLista(List<Auditoria> lista) {
		this.lista = lista;
	}
	
	public String editar() {
		if (auditoria.getId() != null) {
			carregaListaArquivo();
		}
		return "/controleInterno/cadastros/auditoria.jsf";

	}

	public String excluir() {
		
		auditoriaRN.exclui(auditoria);
		lista = auditoriaRN.lista();
		return "/controleInterno/cadastros/pesquisaAuditoria.jsf";
		
	}

	public List<Irregularidade> getListaIrregularidade(String tipoDocumento) {
		if (this.listaIrregularidade == null) {
			listaIrregularidade = irregularidadesRN.listaPorTipoDocumento(tipoDocumento);
		}
		
		return listaIrregularidade;
	}

	public void setListaIrregularidade(List<Irregularidade> listaIrregularidade) {
		this.listaIrregularidade = listaIrregularidade;
	}

	public List<Legislacao> getListaLegislacao() {
		if (this.listaLegislacao == null) {
			listaLegislacao = legislacaoRN.lista();
		}
		
		return listaLegislacao;
	}

	public void setListaLegislacao(List<Legislacao> listaLegislacao) {
		this.listaLegislacao = listaLegislacao;
	}

	public List<Arquivo> getListaArquivo() {
		if (listaArquivo == null) {
			listaArquivo = new ArrayList<Arquivo>();
			carregaListaArquivo();
		}
		return listaArquivo;
	}

	private void carregaListaArquivo() {
		listaArquivo = arquivoService.buscaArquivoPorTabelaIdReferencia("auditoria", auditoria.getId());
		
	}

	public void setListaArquivo(List<Arquivo> listaArquivo) {
		this.listaArquivo = listaArquivo;
	}

	
	public String anexarDocumento() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("arquivoIdReferencia", auditoria.getId());
		session.setAttribute("arquivoTabela", "auditoria");
		return "/controleInterno/cadastros/arquivo.jsf";
		
	}
	
	public String incluir() {
		auditoria = new Auditoria();
		return "/controleInterno/cadastros/auditoria.jsf";
	}
	
	public String voltar() {
		if (auditoria.getId() != null) auditoria = new Auditoria();
		return "/controleInterno/cadastros/pesquisaAuditoria.jsf";
	}

	public String pesquisar() {
		
		if (getPeriodoFinal() != null && getPeriodoInicial() != null) {
			if (getPeriodoFinal().getTime() < getPeriodoInicial().getTime()) {
				Util.msgErro("Periodo Inválido!",
						"");
				return null;
			}
		}
		
		Auditoria auditoriaAux = new Auditoria();
		auditoriaAux.setPeriodoFinal(getPeriodoFinal());
		auditoriaAux.setPeriodoInicial(getPeriodoInicial());
		this.lista = auditoriaRN.pesquisar(auditoriaAux);
		return "/controleInterno/cadastros/pesquisaAuditoria.jsf";
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


	public List<AuditoriaDocumento> getListaAuditoriaDocumento() {
		
		listaAuditoriaDocumento = auditoriaDocumentoService.listaPorAuditoria(auditoria.getId());
		return listaAuditoriaDocumento;
	}


	public void setListaAuditoriaDocumento(
			List<AuditoriaDocumento> listaAuditoriaDocumento) {
		this.listaAuditoriaDocumento = listaAuditoriaDocumento;
	}
	
	public String incluirDocumento() {
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("auditoria", auditoria);
			return "/controleInterno/cadastros/auditoriaDocumento.jsf";
			

	}
	 
	
}


