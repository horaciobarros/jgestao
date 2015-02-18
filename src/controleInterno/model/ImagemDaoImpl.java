package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImagemDaoImpl implements ImagemDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private static final long serialVersionUID = 1L;
	StringBuilder hql;

	public boolean existe(Imagem imagem) {

		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Imagem i where i.id = :pId ");
		query.setParameter("pId", imagem.getId());
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

	public void adiciona(Imagem imagem) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(imagem);
		tx.commit();
	}

	public void exclui(Imagem imagem) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(imagem);
		tx.commit();

	}

	public void altera(Imagem imagem) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(imagem);
		tx.commit();
	}

	public List<Imagem> lista() {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("select i from Imagem i");
		List lista = query.list();
		tx.commit();

		return (List<Imagem>) lista;

	}

	public Imagem buscaImagemPeloTipo(Imagem i) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery(
				"FROM Imagem i WHERE i.tipoImagem = :pTipoImagem ");

		query.setParameter("pTipoImagem", i.getTipoImagem());
		List lista = query.list();
		tx.commit();
		

		try {
			return (Imagem) lista.get(0);
		} catch (Exception e) {
			return new Imagem();
		}
	}

	public Object buscaImagemPeloId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
