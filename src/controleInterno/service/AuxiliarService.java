package controleInterno.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import controleInterno.model.Agenda;
import envioEmail.EnviaEmailGmail;
import envioEmail.EnviaEmailIntegrator;

@Service
public class AuxiliarService {


	public boolean enviaEmailAgendaInteira(String assunto, String texto,
			boolean isGmail, String destinatario, Date periodoInicial,
			Date periodoFinal, AgendaService agendaService) throws Exception {

		List<Agenda> listaAgenda = agendaService.buscaAgendaPeloPeriodo(periodoInicial, periodoFinal);
		

		for (Agenda agenda : listaAgenda) {
			if (agenda.getEmail() == null || agenda.getEmail().isEmpty()) continue;
			
			assunto = agenda.getDescricao();
			
			texto += agenda.getDescricao();
			
			if (isGmail) {
				EnviaEmailGmail email = new EnviaEmailGmail();

				try {
					email.enviaEmail(assunto, texto, agenda.getEmail());
				} catch (Exception e) {
					throw e;

				}

			} else {
				EnviaEmailIntegrator email = new EnviaEmailIntegrator();

				try {
					email.enviaEmail(assunto, texto, agenda.getEmail());
				} catch (Exception e) {
					throw e;

				}
			}
		}

		return true;
	}
}
