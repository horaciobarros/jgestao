package controleInterno.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

public interface AgendaDao extends Serializable{
	
	public boolean existe(Agenda agenda);
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);

	public void adiciona(Agenda agenda);
	public void exclui(Agenda agenda);
	public void altera(Agenda agenda);
	public List<Agenda> lista();
	public Agenda buscaAgendaPeloTipo(Agenda i);
	public Object buscaAgendaPeloId(long id);
	public List<Agenda> buscaAgendaPorTabelaIdReferencia(String tabela, Long idReferencia);
	public List<Agenda> buscaAgendaPeloPeriodo(Date periodoInicial,
			Date periodoFinal);

}

