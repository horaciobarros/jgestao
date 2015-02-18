package acesso.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDaoImpl extends CadastroDAO implements UsuarioDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private static final long serialVersionUID = 1L;
	StringBuilder hql;

	@Transactional
	public boolean existe(Usuario usuario) {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Usuario u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;

	}

	public void adiciona(Usuario usuario) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(usuario);
		tx.commit();
	}

	public void exclui(Usuario usuario) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(usuario);
		tx.commit();
	}

	public void altera(Usuario usuario) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(usuario);
		tx.commit();

	}

	public List<Usuario> lista() {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("select u from Usuario u");
		List lista = query.list();
		tx.commit();

		return (List<Usuario>) lista;

	}

	public Usuario busca(Usuario u) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha");

		query.setParameter("pLogin", u.getLogin());
		query.setParameter("pSenha", u.getSenha());
		List lista = query.list();
		tx.commit();

		return (Usuario) lista.get(0);
	}

	public Usuario buscaPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("from Usuario  where id = :pId");
		query.setParameter("pId", id);
		List lista = query.list();
		tx.commit();
		return (Usuario) lista.get(0);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}