package controleInterno.service;

import java.util.Date;
import java.util.List;

import controleInterno.model.Agenda;

public interface AgendaService {

		public boolean salvar(Agenda a);
		
		public Agenda buscaAgendaPeloTipo(Agenda a);

		public void altera(Agenda agenda);
		public void adiciona(Agenda agenda);

		public List<Agenda> lista();
		
		public Agenda buscaAgendaPeloId(Agenda a);
		public List<Agenda> buscaAgendaPorTabelaIdReferencia(String tabela, Long idReferencia);
		
		public void exclui(Agenda agenda);
		
		public List<Agenda> buscaAgendaPeloPeriodo(Date periodoInicial, Date periodoFinal);

}


