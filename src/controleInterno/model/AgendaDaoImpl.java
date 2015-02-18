package controleInterno.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import util.Util;
import controleInterno.dao.Dao;

@Repository
public class AgendaDaoImpl implements AgendaDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	@Autowired
	private Dao<Agenda> dao;

	public boolean existe(Agenda agenda) {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Agenda i where i.id = :pId ");
		query.setParameter("pId", agenda.getId());
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

	public void adiciona(Agenda agenda) {
		dao.save(agenda);
	}

	public void exclui(Agenda agenda) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(agenda);
		tx.commit();

	}

	public void altera(Agenda agenda) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(agenda);
		tx.commit();
	}

	public List<Agenda> lista() {

		return (List<Agenda>) this.dao.find("FROM Agenda a ");

	}

	public Agenda buscaAgendaPeloTipo(Agenda i) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(
				"FROM Agenda i WHERE i.tipoAgenda = :pTipoAgenda ");

		query.setParameter("pTipoAgenda", i.getTipoAgenda());
		List lista = query.list();
		tx.commit();
		

		try {
			return (Agenda) lista.get(0);
		} catch (Exception e) {
			return new Agenda();
		}
	}

	public Object buscaAgendaPeloId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agenda> buscaAgendaPorTabelaIdReferencia(String tabela, Long idReferencia) {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("FROM Agenda a WHERE  a.tabela = :pTabela "
						+ "AND a.idReferencia = :pIdReferencia");
		query.setParameter("pTabela", tabela);
		query.setParameter("pIdReferencia", idReferencia);

		List lista = query.list();
		tx.commit();

		return (List<Agenda>) lista;
	}

	@Override
	public List<Agenda> buscaAgendaPeloPeriodo(Date periodoInicial,
			Date periodoFinal) {
		StringBuffer aux = new StringBuffer();
		
		aux.append("FROM Agenda a WHERE 1 = 1 ");
		if (periodoInicial != null) {
			aux.append("AND a.dataFim >= '" + Util.formataData(periodoInicial,"YYYY-mm-dd") + "'");
		}
		if (periodoFinal != null) {
			aux.append("AND a.dataFim >= '" + Util.formataData(periodoFinal,"YYYY-mm-dd") + "'");
		}
		
		aux.append(" ORDER BY a.dataFim ");  
		
		return (List<Agenda>) dao.find(aux.toString());
	}
	
	

}

