package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controleInterno.model.DepartamentoDao;
import controleInterno.model.Departamento;

@Service("departamentoService")
@Transactional(readOnly = true)
public class DepartamentoServiceImpl implements DepartamentoService {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DepartamentoDao dao;

	public boolean salvar(Departamento d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaDepartamentoPeloId(long id) {
		return dao.buscaDepartamentoPeloId(id);
	}

	public void altera(Departamento departamento) {
			dao.altera(departamento);
	}

	public void adiciona(Departamento departamento) {
			dao.adiciona(departamento);
	}

	public List<Departamento> lista() {
		return dao.lista();
	}


	public Departamento buscaDepartamento(Departamento departamentoLogado) {
		return dao.buscaDepartamento(departamentoLogado);
	}

	

}
