package controleInterno.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;

@Repository
public class TipoLegislacaoDaoImpl implements TipoLegislacaoDao{
	/**
	 * 
	 */
	
	@Autowired
	SessionFactory sessionFactory;
	
	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	

	public boolean existe(TipoLegislacao tipoLegislacao) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("from TipoLegislacao tl where tl.texto = :pCodigo ");
		query.setParameter("pCodigo", tipoLegislacao.getCodigo());
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

	public void adiciona(TipoLegislacao tipoLegislacao) {

		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(tipoLegislacao);
		tx.commit();
	}

	public void exclui(TipoLegislacao tipoLegislacao) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(tipoLegislacao);
		tx.commit();
	}
	
	public void altera(TipoLegislacao tipoLegislacao) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(tipoLegislacao);
		tx.commit();	
	}
	public List<TipoLegislacao> lista() {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM TipoLegislacao tl ORDER BY tl.descricao");  
		List<TipoLegislacao> objetos = query.list();  
		tx.commit();
		
		return objetos;
		
	}


	public TipoLegislacao buscaTipoLegislacaoPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM TipoLegislacao tl WHERE tl.id = " + id);  
		List<TipoLegislacao> objetos = query.list();
		tx.commit();
		
		return objetos.get(0);
	}
}

