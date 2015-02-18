package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.Irregularidade;
import controleInterno.model.IrregularidadeDao;

@Service("irregularidadeService")
public class IrregularidadeServiceImpl implements IrregularidadeService{
	
	@Autowired
	private IrregularidadeDao dao;

	public boolean salvar(Irregularidade d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaIrregularidadePeloId(long id) {
		return dao.buscaIrregularidadePeloId(id);
	}

	public void altera(Irregularidade irregularidade) {
			dao.altera(irregularidade);
	}

	public void adiciona(Irregularidade irregularidade) {
			dao.adiciona(irregularidade);
	}

	public List<Irregularidade> lista() {
		return dao.lista();
	}


	public List<Irregularidade> buscaIrregularidade(Irregularidade irregularidade) {
		return dao.buscaIrregularidade(irregularidade);
	}

	@Override
	public List<Irregularidade> listaPorTipoDocumento(String tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

}
