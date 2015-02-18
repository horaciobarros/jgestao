package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import controleInterno.dao.Dao;

@Repository
public class NormasProcedimentosDaoImpl implements NormasProcedimentosDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Dao<NormasProcedimentos> dao;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean existe(NormasProcedimentos normasProcedimentos) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("from NormasProcedimentos np where np.texto = :pNumero ");
		query.setParameter("pNumero", normasProcedimentos.getNumero());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
		
	}

	public void adiciona(NormasProcedimentos normasProcedimentos) {

		dao.save(normasProcedimentos);
		
	}

	public void exclui(NormasProcedimentos normasProcedimentos) {
		dao.delete(normasProcedimentos);
		
	}
	
	public void altera(NormasProcedimentos normasProcedimentos) {
		dao.update(normasProcedimentos);
		
	}
	public List<NormasProcedimentos> lista() {
		
		return (List<NormasProcedimentos>) this.dao.find("FROM NormasProcedimentos np ");
		
	}


	public Object buscaNormasProcedimentosPeloId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NormasProcedimentos> listaComFiltro(NormasProcedimentos np) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		StringBuffer sql = new StringBuffer("FROM NormasProcedimentos np WHERE 1=1 ");
		if (np.getTipo() != null && !np.getTipo().isEmpty()) sql.append("AND np.tipo = :tipo ");
		if (np.getNumero() != null && !np.getNumero().isEmpty()) sql.append("AND np.numero = :numero ");
		if (np.getAno() != null && !np.getAno().isEmpty()) sql.append("AND np.ano = :ano ");
		sql.append(" ORDER BY np.numero");
		
		Query query = getSessionFactory().getCurrentSession().createQuery(sql.toString());
		if (np.getTipo() != null && !np.getTipo().isEmpty()) query.setParameter("tipo", np.getTipo());
		if (np.getNumero() != null && !np.getNumero().isEmpty()) query.setParameter("numero", np.getNumero());
		if (np.getAno() != null && !np.getAno().isEmpty()) query.setParameter("ano", np.getAno());
		
		List<NormasProcedimentos> objetos = query.list();
		tx.commit();
		
		return objetos;
		
		
	}
}
