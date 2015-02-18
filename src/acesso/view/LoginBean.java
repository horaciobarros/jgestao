package acesso.view;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.controller.EntidadeService;
import controleInterno.model.Entidade;
import util.HibernateUtil;
import util.Util;
import acesso.model.Usuario;
import acesso.service.UsuarioService;

@Component
@SessionScoped
@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	@Autowired
	private UsuarioService usuarioService;
	private static final long serialVersionUID = 1L;
	private Usuario usuarioLogado = new Usuario();
	@Autowired
	private EntidadeService entidadeService;
	private String msg;
	private String dataAtual;
	private String senha1;
	private String senha2;
	private Entidade entidade;
	private Session session;

	public LoginBean() {
		session = HibernateUtil.getSession();


	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public String efetuaLogin() {

		if (usuarioService.existe(usuarioLogado)) {
			msg = "";
			usuarioLogado = usuarioService.busca(usuarioLogado);
			entidade = entidadeService.buscaEntidadeAtiva();
			return "/templates/principal";
		} else {

			Util.msgErro("Dados incorretos", "Acesso não permitido");
			return "login";
		}

	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDataAtual() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAtual = new Date();
		return dateFormat.format(dataAtual.getTime());
	}

	public String gravarNovaSenha() {
		if (getSenha1().equals(getSenha2()) && getSenha1().trim().length() != 0) {
			try {
				usuarioLogado.setSenha(getSenha1());
				usuarioService.altera(usuarioLogado);
				Util.msgSucesso("Senha gravada", "Registro atualizado");
			} catch (Exception e) {
				Util.msgErro("Erro de gravação:", e.toString());
			}

		} else {
			Util.msgErro("Erro:", "Senhas inválidas");
		}

		return "mudarSenha";
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

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Session getSession() {
		return session;
	}

}