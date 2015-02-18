package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArquivoDaoImpl implements ArquivoDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private static final long serialVersionUID = 1L;
	StringBuilder hql;

	public boolean existe(Arquivo arquivo) {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Arquivo i where i.id = :pId ");
		query.setParameter("pId", arquivo.getId());
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

	public void adiciona(Arquivo arquivo) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(arquivo);
		tx.commit();
	}

	public void exclui(Arquivo arquivo) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(arquivo);
		tx.commit();

	}

	public void altera(Arquivo arquivo) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(arquivo);
		tx.commit();
	}

	public List<Arquivo> lista() {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("select i from Arquivo i");
		List lista = query.list();
		tx.commit();

		return (List<Arquivo>) lista;

	}

	public Arquivo buscaArquivoPeloTipo(Arquivo i) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(
				"FROM Arquivo i WHERE i.tipoArquivo = :pTipoArquivo ");

		query.setParameter("pTipoArquivo", i.getTipoArquivo());
		List lista = query.list();
		tx.commit();
		

		try {
			return (Arquivo) lista.get(0);
		} catch (Exception e) {
			return new Arquivo();
		}
	}

	public Object buscaArquivoPeloId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arquivo> buscaArquivoPorTabelaIdReferencia(String tabela, Long idReferencia) {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("FROM Arquivo a WHERE  a.tabela = :pTabela "
						+ "AND a.idReferencia = :pIdReferencia");
		query.setParameter("pTabela", tabela);
		query.setParameter("pIdReferencia", idReferencia);

		List lista = query.list();
		tx.commit();

		return (List<Arquivo>) lista;
	}
	
	

}

