package controleInterno.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controleInterno.model.Entidade;
import acesso.model.EntidadeDao;

@Service("entidadeService")
@Transactional
public class EntidadeServiceImpl implements EntidadeService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EntidadeDao dao;

	public void altera(Entidade e) {
			dao.altera(e);
	}

	public List<Entidade> lista() {
		return dao.lista();
	}

	public boolean existe(Entidade e) {
		
		return dao.existe(e);
	}
	
	public Entidade buscaEntidadeAtiva() {
		return dao.buscaEntidadeAtiva();
	}

}