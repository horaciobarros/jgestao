package controleInterno.service;

import java.io.Serializable;
import java.util.List;

import controleInterno.model.Departamento;

public interface DepartamentoService extends Serializable{
	public boolean salvar(Departamento d);
	
	public Object buscaDepartamentoPeloId(long id);

	public void altera(Departamento departamento);
	public void adiciona(Departamento departamento);

	public List<Departamento> lista();

	public Departamento buscaDepartamento(Departamento departamentoLogado);
}
