package controleInterno.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.model.Departamento;
import controleInterno.model.UnidadeOrcamentaria;
import controleInterno.service.DepartamentoService;
import controleInterno.service.UnidadeOrcamentariaService;

@Scope("request")
@Component
@ManagedBean(name = "departamentoBean")
public class DepartamentoBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Departamento departamento;
	@Autowired
	private DepartamentoService departamentoService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Departamento> lista;
	private List<UnidadeOrcamentaria> listaUnidadeOrcamentaria;
	@Autowired
	private UnidadeOrcamentariaService unidadeOrcamentariaService;

	public DepartamentoBean() {

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (departamento.getId() != 0) {
				try {
					departamentoService.altera(departamento);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					departamentoService.adiciona(departamento);

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
		if (departamento.getDescricao() == null
				|| departamento.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (departamento.getUnidadeOrcamentaria() == null
				|| departamento.getUnidadeOrcamentaria().getId() == null) {
			Util.msgErro("Unidade Orçamentária:",
					MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}

		return retorno;
	}

	public Departamento getDepartamento() {
		if (departamento == null)
			departamento = new Departamento();
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Departamento> getLista() {
		if (lista == null) {
			atualizaLista();

		}
		return lista;
	}

	public void setLista(List<Departamento> lista) {
		this.lista = lista;
	}

	public String editar() {
		return "/controleInterno/cadastros/departamento.jsf";

	}

	public List<UnidadeOrcamentaria> getListaUnidadeOrcamentaria() {
		if (listaUnidadeOrcamentaria == null) {
			listaUnidadeOrcamentaria = unidadeOrcamentariaService.lista();
		}
		return listaUnidadeOrcamentaria;
	}

	public void setListaUnidadeOrcamentaria(
			List<UnidadeOrcamentaria> listaUnidadeOrcamentaria) {
		this.listaUnidadeOrcamentaria = listaUnidadeOrcamentaria;
	}

	public void limpar() {
		departamento = new Departamento();
	}

	private void atualizaLista() {
		lista = departamentoService.lista();
	}
	
	public String voltar() {
		return "/controleInterno/cadastros/pesquisaDepartamento.jsf";

	}
	
	public String incluir() {
		departamento = new Departamento();
		return "/controleInterno/cadastros/departamento.jsf";
	}
}
