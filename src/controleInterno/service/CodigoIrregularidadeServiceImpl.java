package controleInterno.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.CodigoIrregularidade;
import controleInterno.model.CodigoIrregularidadeDao;

@Service("codigoIrregularidadeService")
public class CodigoIrregularidadeServiceImpl implements CodigoIrregularidadeService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	CodigoIrregularidadeDao dao;

	public boolean salvar(CodigoIrregularidade d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaCodigoIrregularidadePeloId(long id) {
		return dao.buscaCodigoIrregularidadePeloId(id);
	}

	public void altera(CodigoIrregularidade codigoIrregularidade) {
			dao.altera(codigoIrregularidade);
	}

	public void adiciona(CodigoIrregularidade codigoIrregularidade) {
			dao.adiciona(codigoIrregularidade);
	}

	public List<CodigoIrregularidade> lista() {
		return dao.lista();
	}


	public CodigoIrregularidade buscaCodigoIrregularidade(CodigoIrregularidade codigoIrregularidadeLogado) {
		return dao.buscaCodigoIrregularidade(codigoIrregularidadeLogado);
	}

}

