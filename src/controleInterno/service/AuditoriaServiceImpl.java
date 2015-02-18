package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.Auditoria;
import controleInterno.model.AuditoriaDao;

@Service("auditoriaService")
public class AuditoriaServiceImpl implements AuditoriaService {
	
	/**
	 * 
	 */
	@Autowired
	AuditoriaDao dao;

	public boolean salvar(Auditoria d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaAuditoriaPeloId(long id) {
		return dao.buscaAuditoriaPeloId(id);
	}

	public void altera(Auditoria Auditoria) {
			dao.altera(Auditoria);
	}

	public void adiciona(Auditoria Auditoria) {
			dao.adiciona(Auditoria);
	}

	public List<Auditoria> lista() {
		return dao.lista();
	}


	public Auditoria buscaAuditoria(Auditoria AuditoriaLogado) {
		return dao.buscaAuditoria(AuditoriaLogado);
	}
	
	public void exclui(Auditoria Auditoria) {
		dao.exclui(Auditoria);
}

	@Override
	public List<Auditoria> pesquisar(Auditoria auditoria) {
		return dao.pesquisar(auditoria);
		
	}

}

