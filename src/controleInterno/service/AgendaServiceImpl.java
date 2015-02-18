package controleInterno.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.service.AgendaService;
import controleInterno.model.Agenda;
import controleInterno.model.AgendaDao;

@Service("agendaService")
public class AgendaServiceImpl implements AgendaService{
	
		private static final long serialVersionUID = 1L;
		
		@Autowired
		AgendaDao dao;

		public boolean salvar(Agenda d) {
			if (d.getId() == 0)
				dao.adiciona(d);
			else
				dao.altera(d);
			return true;
		}
		
		public Agenda buscaAgendaPeloTipo(Agenda i) {
			return dao.buscaAgendaPeloTipo(i);
		}

		public void altera(Agenda agenda) {
				dao.altera(agenda);
		}

		public void adiciona(Agenda agenda) {
				dao.adiciona(agenda);
		}

		public List<Agenda> lista() {
			return dao.lista();
		}

		@Override
		public Agenda buscaAgendaPeloId(Agenda a) {
			
			return null;
		}

		@Override
		public List<Agenda> buscaAgendaPorTabelaIdReferencia(String tabela,
				Long idReferencia) {
			return dao.buscaAgendaPorTabelaIdReferencia(tabela, idReferencia);
		}

		@Override
		public void exclui(Agenda agenda) {
			dao.exclui(agenda);
			
		}

		@Override
		public List<Agenda> buscaAgendaPeloPeriodo(Date periodoInicial,
				Date periodoFinal) {
			
			return dao.buscaAgendaPeloPeriodo(periodoInicial,
					periodoFinal);
		}

}


