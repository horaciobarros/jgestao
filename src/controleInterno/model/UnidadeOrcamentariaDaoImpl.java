package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UnidadeOrcamentariaDaoImpl implements UnidadeOrcamentariaDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	StringBuilder hql;

	public boolean existe(UnidadeOrcamentaria unidade) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from UnidadeOrcamentaria u where u.codigo = :pCodigo ");
		query.setParameter("pNumero", unidade.getCodigo());
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

	public void adiciona(UnidadeOrcamentaria unidade) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(unidade);
		tx.commit();

	}

	public void exclui(UnidadeOrcamentaria unidade) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(unidade);
		tx.commit();
		
	}

	public void altera(UnidadeOrcamentaria unidade) {


		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(unidade);
		tx.commit();
	}

	public List<UnidadeOrcamentaria> lista() {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM UnidadeOrcamentaria u ORDER BY u.descricao");
		List<UnidadeOrcamentaria> objetos = query.list();

		tx.commit();
		
		return objetos;

	}

	public UnidadeOrcamentaria buscaUnidadeOrcamentariaPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from UnidadeOrcamentaria u where u.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (UnidadeOrcamentaria) lista.get(0);
	}

		
	
	// ---- Manipulando órgao
	
	public Orgao buscaOrgaoPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Orgao o where o.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (Orgao) lista.get(0);
	}
	
	public List<Orgao> listaOrgao() {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM Orgao o   ");
		List<Orgao> objetos = query.list();
		tx.commit();

		return objetos;

	}

	
	public void adicionaOrgao(Orgao o) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(o);
		tx.commit();
		}

	public void excluiOrgao(Orgao o) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(o);
		tx.commit();
	
	}

	public void alteraOrgao(Orgao o) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(o);
		tx.commit();
	
	}

	// --- Manipulando unidade
	
	public Unidade buscaUnidadePeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Unidade u where u.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (Unidade) lista.get(0);
	}

	
	public List<Unidade> listaUnidade() {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"FROM Unidade u  ORDER BY u.descricao");
		List<Unidade> objetos = query.list();

		tx.commit();
		
		return objetos;

	}

	
	public void adicionaUnidade(Unidade u ) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(u);
		tx.commit();
		}

	public void excluiUnidade(Unidade u) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(u);
		tx.commit();
	
	}

	public void alteraUnidade(Unidade u) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(u);
		tx.commit();
	
	}

	

}
