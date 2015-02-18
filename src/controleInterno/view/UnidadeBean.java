package controleInterno.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import controleInterno.model.Orgao;
import controleInterno.model.Unidade;
import controleInterno.service.UnidadeOrcamentariaService;
import util.Util;

@Scope("request")
@Component
@ManagedBean(name = "unidadeBean")
public class UnidadeBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Unidade unidade;
	
	@Autowired
	private UnidadeOrcamentariaService unidadeService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Unidade> lista;
	private List<Orgao> listaOrgao;
	

	public UnidadeBean() {
		
	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (unidade.getId() != null && unidade.getId() != 0) {
				try {
					unidadeService.alteraUnidade(unidade);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					unidadeService.adicionaUnidade(unidade);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

				
			}
			limpar();
			atualizaLista();
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (unidade.getDescricao() == null || unidade.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (unidade.getCodigo() == null || unidade.getCodigo().isEmpty()) {
			Util.msgErro("Código:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (unidade.getOrgao() == null ) {
			Util.msgErro("Órgão:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		

		return retorno;
	}


	public List<Unidade> getLista() {
		if (lista==null) {
			atualizaLista();
		}
		return lista;
	}

	private void atualizaLista() {
		lista = unidadeService.listaUnidade();
		
	}

	public void setLista(List<Unidade> lista) {
		this.lista = lista;
	}
	
	public String editar() {
		return "/controleInterno/cadastros/unidade.jsf";

	}

	public Unidade getUnidade() {
		if (unidade == null) {
			unidade = new Unidade();
		}
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Orgao> getListaOrgao() {
		if (listaOrgao == null) {
			listaOrgao = unidadeService.listaOrgao();
		}
		return listaOrgao;
	}

	public void setListaOrgao(List<Orgao> listaOrgao) {
		this.listaOrgao = listaOrgao;
	}
	
	public void limpar() {
		unidade = new Unidade();
	}

}

