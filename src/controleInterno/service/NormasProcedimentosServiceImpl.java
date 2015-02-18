package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.NormasProcedimentos;
import controleInterno.model.NormasProcedimentosDao;

@Service("normasProcedimentosService")
public class NormasProcedimentosServiceImpl implements NormasProcedimentosService {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	NormasProcedimentosDao dao;

	public boolean salvar(NormasProcedimentos d) {
		
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaNormasProcedimentosPeloId(long id) {
		return dao.buscaNormasProcedimentosPeloId(id);
	}

	public void altera(NormasProcedimentos normasProcedimentos) {
			dao.altera(normasProcedimentos);
	}

	public void adiciona(NormasProcedimentos normasProcedimentos) {
			dao.adiciona(normasProcedimentos);
	}

	public List<NormasProcedimentos> lista() {
		return dao.lista();
	}

	@Override
	public List<NormasProcedimentos> listaComFiltro(NormasProcedimentos np) {
		return dao.listaComFiltro(np);
		
	}


}
