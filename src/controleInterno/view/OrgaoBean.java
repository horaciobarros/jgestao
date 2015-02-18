package controleInterno.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import controleInterno.model.Orgao;
import controleInterno.service.UnidadeOrcamentariaService;
import util.Util;

@Scope("request")
@Component
@ManagedBean(name = "orgaoBean")
public class OrgaoBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Orgao orgao;
	@Autowired
	private UnidadeOrcamentariaService orgaoService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Orgao> lista;
	

	public OrgaoBean() {
		
	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (orgao.getId() != null && orgao.getId() != 0) {
				try {
					orgaoService.alteraOrgao(orgao);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					orgaoService.adicionaOrgao(orgao);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

				
			}
			//limpar();
			atualizaLista();
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (orgao.getDescricao() == null || orgao.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (orgao.getCodigo() == null || orgao.getCodigo().isEmpty()) {
			Util.msgErro("Código", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		

		return retorno;
	}

	public Orgao getOrgao() {
		if (orgao == null) orgao = new Orgao();
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public List<Orgao> getLista() {
		if (lista==null) {
			atualizaLista();
		}
		return lista;
	}

	public void setLista(List<Orgao> lista) {
		this.lista = lista;
	}
	
	public String editar() {
		return "/controleInterno/cadastros/orgao.jsf";

	}

	public void limpar() {
		orgao = new Orgao();
	}
	
	private void atualizaLista() {
		lista = orgaoService.listaOrgao();
	}
	
	public String incluir() {
		orgao = new Orgao();
		return "/controleInterno/cadastros/orgao.jsf";
	}
	
	public String voltar() {
			return "/controleInterno/cadastros/pesquisaOrgao.jsf";
	}
}

