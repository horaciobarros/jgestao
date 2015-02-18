package controleInterno.model;

import java.util.List;

import org.hibernate.SessionFactory;

public interface DepartamentoDao {
	public boolean existe(Departamento departamento);	

	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);

	public void adiciona(Departamento departamento);
	public void exclui(Departamento departamento);	
	public void altera(Departamento departamento);
	public List<Departamento> lista();

	public Departamento buscaDepartamento(Departamento d);
	public Object buscaDepartamentoPeloId(long id);

}
