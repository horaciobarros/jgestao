package controleInterno.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import controleInterno.dao.Dao;

@Repository
public class AuditoriaDaoImpl implements AuditoriaDao {
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Dao<Auditoria> dao;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private static final long serialVersionUID = 1L;
	
	StringBuilder hql;
	
	public void adiciona(Auditoria auditoria) {

		dao.save(auditoria);		
	}

	public void exclui(Auditoria auditoria) {

		dao.delete(auditoria);
	}
	
	public void altera(Auditoria auditoria) {

		dao.update(auditoria);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Auditoria> lista() {
		
		
		return (List<Auditoria>) this.dao.find("FROM Auditoria a ");
		
	}


	public Object buscaAuditoriaPeloId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Auditoria buscaAuditoria(Auditoria auditoriaLogado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auditoria> pesquisar(Auditoria auditoria) {
		
		StringBuffer aux = new StringBuffer();
		Map<String,Object> map= new HashMap<String,Object>();
		
		aux.append("FROM Auditoria a WHERE 1 = 1 ");
		if (auditoria.getPeriodoInicial() != null) {
			aux.append("AND a.periodoInicial >= :pPeriodoInicial ");
			map.put("pPeriodoInicial", auditoria.getPeriodoInicial());
		}
		if (auditoria.getPeriodoFinal() != null) {
			aux.append("AND a.periodoFinal <= :pPeriodoFinal");
			map.put("pPeriodoFinal", auditoria.getPeriodoFinal());
		}
		aux.append(" ORDER BY a.id");  
		
		return (List<Auditoria>) dao.findByNamedParams(aux.toString(),map);
		
		
	}
}
