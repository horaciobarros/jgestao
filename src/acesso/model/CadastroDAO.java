package acesso.model;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import acesso.view.LoginBean;
import util.HibernateUtil;

public class CadastroDAO {
	protected Session session; 
	protected Transaction tx;
	
	public Session getSession() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		LoginBean login = (LoginBean) sessao.getAttribute("loginBean"); 
		session = login.getSession();
		
		return session;
	}

}
