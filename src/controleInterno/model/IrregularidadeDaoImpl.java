package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import controleInterno.dao.Dao;

@Repository
public class IrregularidadeDaoImpl implements IrregularidadeDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Dao<Irregularidade> dao;
	
	public void adiciona(Irregularidade irregularidade) {

		dao.save(irregularidade);
	}

	public void exclui(Irregularidade irregularidade) {

		dao.delete(irregularidade);
	}
	
	public void altera(Irregularidade irregularidade) {
		dao.update(irregularidade);

	}
	public List<Irregularidade> lista() {
		
		return (List<Irregularidade>) this.dao.find("FROM Irregularidade i ");
		
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object buscaIrregularidadePeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Irregularidade i where i.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (Irregularidade) lista.get(0);
	}

	public List<Irregularidade> buscaIrregularidade(
			Irregularidade irregularidade) {
		return (List<Irregularidade>) this.dao.find("FROM Irregularidade i WHERE i.tipoDocumento = '" + irregularidade.getTipoDocumento() + "'");
	}


}