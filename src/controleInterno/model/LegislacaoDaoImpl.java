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

import controleInterno.dao.Dao;

@Repository
public class LegislacaoDaoImpl implements LegislacaoDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Dao<Legislacao> dao;

	StringBuilder hql;

	public boolean existe(Legislacao legislacao) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Legislacao l where l.texto = :pNumero ");
		query.setParameter("pNumero", legislacao.getNumero());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;

	}

	public void adiciona(Legislacao legislacao) {
		dao.save(legislacao);
	}

	public void exclui(Legislacao legislacao) {

		dao.delete(legislacao);
	}

	public void altera(Legislacao legislacao) {

		dao.update(legislacao);
	}

	public List<Legislacao> lista() {

		return (List<Legislacao>) this.dao.find("FROM Legislacao l ");

	}

	public Object buscaLegislacaoPeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession()
				.beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from Legislacao l where l.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (Legislacao) lista.get(0);
	}

	public Legislacao buscaLegislacao(Legislacao legislacaoLogado) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Legislacao> pesquisar(Date periodoInicial, Date periodoFinal,
			TipoLegislacao tipoLegislacao, String conteudo) {
		StringBuffer aux = new StringBuffer();
		Map<String,Object> map= new HashMap<String,Object>();
		
		aux.append("FROM Legislacao l WHERE 1 = 1 ");
		if (periodoInicial != null) {
			aux.append("AND l.data >= :pPeriodoInicial ");
			map.put("pPeriodoInicial", periodoInicial);
		}
		if (periodoFinal != null) {
			aux.append("AND l.data <= :pPeriodoFinal" );
			map.put("pPeriodoFinal", periodoFinal);
		}
		
		if (conteudo != null) {
			aux.append("AND (l.referencia like :pConteudo ");
			aux.append("OR l.texto like :pConteudo ) ");
			map.put("pConteudo", "%" + conteudo.trim() + "%");
		}
		
		if (tipoLegislacao != null) {
			aux.append("AND l.tipoLegislacao.codigo = :pTipoLegislacao ");
			map.put("pTipoLegislacao", tipoLegislacao.getCodigo());
		}
		
		aux.append(" ORDER BY l.id");  
		
		return (List<Legislacao>) dao.findByNamedParams(aux.toString(),map);
		
	}

}
