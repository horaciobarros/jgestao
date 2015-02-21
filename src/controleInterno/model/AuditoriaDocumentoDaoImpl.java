package controleInterno.model;

import java.io.*;
import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.Transaction;

import controleInterno.model.AuditoriaDocumento;
import controleInterno.dao.*;

@Repository
public class AuditoriaDocumentoDaoImpl implements AuditoriaDocumentoDao {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Dao<AuditoriaDocumento> dao;

	StringBuilder hql;

	public boolean existe(AuditoriaDocumento auditoriadocumento) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from AuditoriaDocumento e where e.id = :pId ");
		query.setParameter("pId", auditoriadocumento.getAuditoria().getId());
		List lista = query.list();
		tx.commit();
		boolean encontrado = !lista.isEmpty();
		return encontrado;
	}

	public void adiciona(AuditoriaDocumento auditoriadocumento) {
		dao.save(auditoriadocumento);
	}

	public void exclui(AuditoriaDocumento auditoriadocumento) {
		dao.delete(auditoriadocumento);
	}

	public void altera(AuditoriaDocumento auditoriadocumento) {
		dao.update(auditoriadocumento);
	}

	public List<AuditoriaDocumento> lista() {
		return (List<AuditoriaDocumento>) this.dao
				.find("FROM AuditoriaDocumento e ");
	}

	public Object buscaAuditoriaDocumentoPeloId(long id) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from AuditoriaDocumento e where e.id = :pId ");
		query.setParameter("pId", id);
		List lista = query.list();
		return (AuditoriaDocumento) lista.get(0);
	}

	@Override
	public List<AuditoriaDocumento> listaPorAuditoria(Long idAuditoria) {
		
		StringBuffer aux = new StringBuffer();
		Map<String,Object> map= new HashMap<String,Object>();
		aux.append("FROM AuditoriaDocumento a WHERE 1 = 1 ");
		aux.append(" AND a.auditoria.id = :pId");
		map.put("pId", idAuditoria);
		return (List<AuditoriaDocumento>) dao.findByNamedParams(aux.toString(),map);
	}
}