 package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl implements DepartamentoDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	public boolean existe(Departamento departamento) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("from Departamento d where d.descricao = :pDescricao ");
		query.setParameter("pDescricao", departamento.getDescricao());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void adiciona(Departamento departamento) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(departamento);
		tx.commit();
	}

	public void exclui(Departamento departamento) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(departamento);
		tx.commit();
	}
	
	public void altera(Departamento departamento) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(departamento);
		tx.commit();	
	}
	public List<Departamento> lista() {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM Departamento d ");  
		List<Departamento> objetos = query.list();
		tx.commit();
		
		return objetos;
		
	}

	public Departamento buscaDepartamento(Departamento d) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("select d from Departamento d where d.descricao = :pDescricao ");
		
		query.setParameter("pDescricao", d.getDescricao());
		List lista = query.list();
		tx.commit();

		return (Departamento) lista.get(0);
	}

	public Object buscaDepartamentoPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("from Departamento d where d.id = :pid ");
		query.setParameter("pid", id);
		List lista = query.list();
		tx.commit();
		return (Departamento) lista.get(0);

	}

}
