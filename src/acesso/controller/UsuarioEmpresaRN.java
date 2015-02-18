package acesso.controller;

import acesso.model.UsuarioEmpresa;
import acesso.model.UsuarioEmpresaDAO;


public class UsuarioEmpresaRN {
	UsuarioEmpresaDAO dao = new UsuarioEmpresaDAO();
	public boolean salvar(UsuarioEmpresa ue) {
		
		if (ue.getId() == 0)
			dao.adiciona(ue);
		else
			dao.altera(ue);
		return true;
	}
	

	public boolean excluir(UsuarioEmpresa ue) {
		dao.exclui(ue);
		return true;
	}

}