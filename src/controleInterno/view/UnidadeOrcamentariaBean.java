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
import controleInterno.model.UnidadeOrcamentaria;
import controleInterno.service.UnidadeOrcamentariaService;
import util.Util;

@Scope("request")
@Component
@ManagedBean(name = "unidadeOrcamentariaBean")
public class UnidadeOrcamentariaBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private UnidadeOrcamentaria unidadeOrcamentaria;
	@Autowired
	private UnidadeOrcamentariaService unidadeOrcamentariaService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<UnidadeOrcamentaria> lista;
	private List<Unidade> listaUnidade;
	private List<Orgao> listaOrgao;
	

	public UnidadeOrcamentariaBean() {
		
	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (unidadeOrcamentaria.getId() != 0) {
				try {
					unidadeOrcamentariaService.altera(unidadeOrcamentaria);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					unidadeOrcamentariaService.adiciona(unidadeOrcamentaria);

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
		if (unidadeOrcamentaria.getDescricao() == null || unidadeOrcamentaria.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (unidadeOrcamentaria.getUnidade() == null) {
			Util.msgErro("Unidade:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (unidadeOrcamentaria.getCodigo() == null || unidadeOrcamentaria.getCodigo().isEmpty()) {
			Util.msgErro("Código:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		

		return retorno;
	}

	public UnidadeOrcamentaria getUnidadeOrcamentaria() {
		if (unidadeOrcamentaria == null) unidadeOrcamentaria = new UnidadeOrcamentaria();
		return unidadeOrcamentaria;
	}

	public void setUnidadeOrcamentaria(UnidadeOrcamentaria unidadeOrcamentaria) {
		this.unidadeOrcamentaria = unidadeOrcamentaria;
	}

	public List<UnidadeOrcamentaria> getLista() {
		if (lista==null) {
			atualizaLista();
		}
		return lista;
	}

	public void setLista(List<UnidadeOrcamentaria> lista) {
		this.lista = lista;
	}
	
	public String editar() {
		return "/controleInterno/cadastros/unidadeOrcamentaria.jsf";

	}

	public List<Unidade> getListaUnidade() {
		if (listaUnidade == null) {
			listaUnidade = unidadeOrcamentariaService.listaUnidade();
		}
		return listaUnidade;
	}

	public void setListaUnidade(List<Unidade> listaUnidade) {
		this.listaUnidade = listaUnidade;
	}

	public List<Orgao> getListaOrgao() {
		if (listaOrgao == null) {
			unidadeOrcamentariaService.listaOrgao();
		}
		return listaOrgao;
	}

	public void setListaOrgao(List<Orgao> listaOrgao) {
		this.listaOrgao = listaOrgao;
	}

	
	public void limpar() {
		unidadeOrcamentaria = new UnidadeOrcamentaria();
	}
	
	private void atualizaLista() {
		lista = unidadeOrcamentariaService.lista();
		
	}
}

