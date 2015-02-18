package controleInterno.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.model.CodigoIrregularidade;
import controleInterno.model.Irregularidade;
import controleInterno.service.CodigoIrregularidadeService;
import controleInterno.service.IrregularidadeService;

@Scope("request")
@Component
@ManagedBean(name = "irregularidadesBean")
public class IrregularidadeBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Irregularidade irregularidade;
	@Autowired
	private IrregularidadeService irregularidadesRN;
	@Autowired
	private CodigoIrregularidadeService codigoIrregularidadeRN;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<Irregularidade> lista;
	private List<CodigoIrregularidade> listaCodigoIrregularidade;

	public IrregularidadeBean() {

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (irregularidade.getId() != 0) {
				try {
					irregularidadesRN.altera(irregularidade);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					irregularidadesRN.adiciona(irregularidade);

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

	public Irregularidade getIrregularidade() {
		if (irregularidade == null)
			irregularidade = new Irregularidade();
		return irregularidade;
	}

	public void setIrregularidade(Irregularidade irregularidade) {
		this.irregularidade = irregularidade;
	}

	public List<Irregularidade> getLista() {
		if (lista == null) {
			lista = irregularidadesRN.lista();
		}
		return lista;
	}

	public void setLista(List<Irregularidade> lista) {
		this.lista = lista;
	}

	public String editar() {
		return "/controleInterno/cadastros/irregularidades.jsf";

	}

	public List<CodigoIrregularidade> getListaCodigoIrregularidade() {
		if (listaCodigoIrregularidade == null) {
			listaCodigoIrregularidade = codigoIrregularidadeRN.lista();
		}

		return listaCodigoIrregularidade;
	}

	public void setListaCodigoIrregularidade(
			List<CodigoIrregularidade> listaCodigoIrregularidade) {
		this.listaCodigoIrregularidade = listaCodigoIrregularidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMSG_ERRO_NAO_PREENCHIMENTO_CAMPOS() {
		return MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS;
	}
	
	public void pesquisar() {
		if (irregularidade.getTipoDocumento() != null && !irregularidade.getTipoDocumento().isEmpty()) lista = irregularidadesRN.buscaIrregularidade(irregularidade);
		
	}
	
	public String incluir() {
		irregularidade = new Irregularidade();
		return "/controleInterno/cadastros/irregularidades.jsf";
		
	}
	
	public String voltar() {
		irregularidade = new Irregularidade();
		return "/controleInterno/cadastros/pesquisaIrregularidades.jsf";
		
	}

}
