package acesso.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.Util;
import acesso.model.Usuario;
import acesso.service.UsuarioService;

@Component
@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	@Autowired
	private UsuarioService usuarioService;

	private static final long serialVersionUID = 1L;
	private List<Usuario> lista;

	private Usuario usuario = new Usuario();
	private String numOS;
	private String nomePesquisa = "";
	private int paginaAtual;
	private String senha1;
	private String senha2;
	private String msg;
	private boolean temMsg;

	public UsuarioBean() {
		usuario = new Usuario();
	}

	public boolean isTemMsg() {
		return temMsg;
	}

	public void setTemMsg(boolean temMsg) {
		this.temMsg = temMsg;
	}

	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsg() {
		return numOS;
	}

	public void setMsg(String msg) {
		this.numOS = msg;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Usuario> getLista() {
		if (lista == null) { 
			lista = usuarioService.lista();
		}
		return lista;

	}

	public String editar() {
		return "/acesso/usuario.jsf";

	}

	public String incluir() {
		setUsuario(new Usuario());
		return ("usuario");

	}

	public String mudarSenha() {
		return "mudarSenha";
	}

	

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (usuario.getId() != 0) {
				try {
					usuarioService.altera(usuario);
					
					Util.msgSucesso("Dados gravados com sucesso!", "Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

			} else
				try {
					usuario.setSenha("123456");
					usuarioService.adiciona(usuario);
					Util.msgSucesso("Dados gravados com sucesso!", "Registro incluido!");
				} catch (Exception e) {
					Util.msgErro("Erro de gravação", e.toString());

				}
		}
	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;

		if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
			Util.msgErro("Erro:","Cpf deve ser informado");
			retorno = false;

		}
		if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
			Util.msgErro("Erro:","Login deve ser informado");
			retorno = false;

		}
		if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
			Util.msgErro("Erro:","Nome deve ser informado");
			retorno = false;

		}
		if (usuario.getNivel() == null || usuario.getNivel().isEmpty()) {
			Util.msgErro("Erro:","Nível deve ser informado");
			retorno = false;

		}

		return retorno;
	}

	public String sairAction() {
		return "/templates/principal.jsf";
	}

	
}
