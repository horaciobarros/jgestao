package controleInterno.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import controleInterno.model.CodigoIrregularidade;
import controleInterno.service.CodigoIrregularidadeService;
import util.Util;

@Scope("request")
@Component
@ManagedBean(name = "codigoIrregularidadeBean")
public class CodigoIrregularidadeBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private CodigoIrregularidade codigoIrregularidade;
	@Autowired
	private CodigoIrregularidadeService codigoIrregularidadeService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<CodigoIrregularidade> lista;
	

	public CodigoIrregularidadeBean() {
		
	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (codigoIrregularidade.getId() != null && codigoIrregularidade.getId() != 0) {
				try {
					codigoIrregularidadeService.altera(codigoIrregularidade);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					codigoIrregularidadeService.adiciona(codigoIrregularidade);

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
		if (codigoIrregularidade.getDescricao() == null || codigoIrregularidade.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		

		return retorno;
	}

	public CodigoIrregularidade getCodigoIrregularidade() {
		if (codigoIrregularidade == null) codigoIrregularidade = new CodigoIrregularidade();
		return codigoIrregularidade;
	}

	public void setCodigoIrregularidade(CodigoIrregularidade codigoIrregularidade) {
		this.codigoIrregularidade = codigoIrregularidade;
	}

	public List<CodigoIrregularidade> getLista() {
		if (lista==null) {
			atualizaLista();
		}
		return lista;
	}

	public void setLista(List<CodigoIrregularidade> lista) {
		this.lista = lista;
	}
	
	public String editar() {
		return "/controleInterno/cadastros/codigoIrregularidade.jsf";

	}

	public void limpar() {
		codigoIrregularidade = new CodigoIrregularidade();
	}
	
	private void atualizaLista() {
		lista = codigoIrregularidadeService.lista();
	}
	
	public String incluir() {
		codigoIrregularidade = new CodigoIrregularidade();
		return "/controleInterno/cadastros/codigoIrregularidade.jsf";
	}
	public String voltar() {
		codigoIrregularidade = new CodigoIrregularidade();
		return "/controleInterno/cadastros/pesquisaCodigoIrregularidade.jsf";
	}
}

