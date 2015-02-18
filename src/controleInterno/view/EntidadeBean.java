package controleInterno.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.controller.EntidadeService;
import controleInterno.model.Entidade;

@Scope("request")
@Component
@ManagedBean(name = "entidadeBean")
public class EntidadeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3717284916971568255L;
	private Entidade entidade;
	
	@Autowired
	private EntidadeService entidadeService;
	
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";

	
	public EntidadeBean() {
		
	}
	
	public void gravar() {
		
		if (camposObrigatoriosPreenchidos()) {
			if (entidade.getId() != 0) {
				try {
					entidadeService.altera(entidade);
					
					Util.msgSucesso("Dados gravados com sucesso!", "Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			}
		}
		
	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (entidade.getNome() == null || entidade.getNome().isEmpty()) {
			Util.msgErro("Nome:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (entidade.getTipo() == null || entidade.getTipo().isEmpty()) {
			Util.msgErro("Tipo:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (entidade.getEndereco() == null || entidade.getEndereco().isEmpty()) {
			Util.msgErro("Endereço:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		if (entidade.getCidade() == null || entidade.getCidade().isEmpty()) {
			Util.msgErro("Cidade:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		
		return retorno;
	}

	public Entidade getEntidade() {
		if (entidade == null) {
			entidade = getEntidadeService().buscaEntidadeAtiva();
		}
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public EntidadeService getEntidadeService() {
		return entidadeService;
	}

	public void setEntidadeService(EntidadeService entidadeService) {
		this.entidadeService = entidadeService;
	}

	
}
