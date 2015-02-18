package controleInterno.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.TipoLegislacao;
import controleInterno.model.TipoLegislacaoDao;

@Service("tipoLegislacaoService")
public class TipoLegislacaoServiceImpl implements TipoLegislacaoService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	TipoLegislacaoDao dao;

	public boolean salvar(TipoLegislacao d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaTipoLegislacaoPeloId(long id) {
		return dao.buscaTipoLegislacaoPeloId(id);
	}

	public void altera(TipoLegislacao tipoLegislacao) {
			dao.altera(tipoLegislacao);
	}

	public void adiciona(TipoLegislacao tipoLegislacao) {
			dao.adiciona(tipoLegislacao);
	}

	public List<TipoLegislacao> lista() {
		return dao.lista();
	}


}
