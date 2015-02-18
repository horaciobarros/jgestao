package controleInterno.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.model.Agenda;
import controleInterno.model.Departamento;
import controleInterno.service.AgendaService;
import controleInterno.service.DepartamentoService;

/**
 * 
 * @author http://www.codigosfontes.com.br Exemplo basico da utilizacao do
 *         p:schedule para maiores detalhes visualize o site do primefaces
 */

@ViewScoped
@Component
@ManagedBean(name = "agendaBean")
public class AgendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7825253840635889834L;

	/**
	 * 
	 */

	private Agenda agenda;

	private String tipoAgenda;

	private ScheduleModel eventModel;

	private List<Agenda> listaAgenda;


	@Autowired
	private AgendaService agendaService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	private List<Departamento> listaDepartamento;

	/**
	 * Metodo para inicializar a nossa agenda. Atraves deste metodo retornamos a
	 * lista de eventos e montamos nosso calendario ScheduleModel atraves de um
	 * DefaultScheduleModel
	 */
	@PostConstruct
	private void inicializar() {

		agenda = new Agenda();
		eventModel = new DefaultScheduleModel();
		tipoAgenda = "GLOBAL";


		try {
			listaAgenda = agendaService.lista();

			// percorre a lista de eventos e popula o calendario
			for (Agenda agenda : listaAgenda) {

				DefaultScheduleEvent evento = new DefaultScheduleEvent();
				evento.setAllDay(agenda.isDiaTodo());
				evento.setEndDate(agenda.getDataFim());
				evento.setStartDate(agenda.getDataInicio());
				evento.setTitle(agenda.getDescricao());
				evento.setData(agenda.getId());
				evento.setEditable(true); // pertir que o usuario edite
				

				// aqui e setado um tipo especifico de css para cada tipo de
				// evento

				evento.setStyleClass("global");

				eventModel.addEvent(evento); // o evento e adicionado na lista
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Metodo para salvar o evento
	 */
	public void salvar() {

		// caso contrario nao e necessario
		if (camposObrigatoriosPreenchidos()) {
			if (agenda.getId() != null) {
				try {
					agendaService.altera(agenda);

					Util.msgSucesso("Dados alterados com sucesso!",
							"Cadastro atualizado!");
					inicializar();

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
					e.printStackTrace();
					
				}
			} else {
				try {
					agendaService.adiciona(agenda);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");
					inicializar();

				} catch (Exception e) {
					e.printStackTrace();
					Util.msgErro("Erro de gravação", e.toString());
				}

			}
		}
	}
	
	public void excluir() {

		// caso contrario nao e necessario
			if (agenda.getId() != null) {
				try {
					agendaService.exclui(agenda);

					Util.msgSucesso("Dados excluidos com sucesso!",
							"Cadastro atualizado!");
					inicializar();

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
					e.printStackTrace();
					
				}

			}
	}


	private boolean camposObrigatoriosPreenchidos() {
		// TODO Auto-generated method stub
		if (agenda.getDataInicio().getTime() < agenda.getDataFim().getTime()) {
			Util.msgErro("Erro:", "Datas inconsistentes!");
			return false;
		}
		return true;
	}

	/**
	 * Evento para quando o usuario clica em um espaco em branco no calendario
	 * 
	 * @param selectEvent
	 */
	public void quandoNovo(SelectEvent selectEvent) {

		ScheduleEvent event = new DefaultScheduleEvent("",
				(Date) selectEvent.getObject(), (Date) selectEvent.getObject());

		agenda = new Agenda();
		// recupero a data em q ele clicou
		agenda.setDataInicio(event.getStartDate());
		agenda.setDataFim(event.getEndDate());
	}

	/**
	 * Evento para quando usuario clica em um enveto ja existente
	 * 
	 * @param selectEvent
	 */
	public void quandoSelecionado(SelectEvent selectEvent) {

		ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();

		for (Agenda agda : listaAgenda) {
			if (agda.getId() == (Long) event.getData()) {
				agenda = agda;
				break;
			}
		}
	}

	/**
	 * Evento para quando o usuario 'move' um evento atraves de 'drag and drop'
	 * 
	 * @param event
	 */
	public void quandoMovido(ScheduleEntryMoveEvent event) {

		for (Agenda agda : listaAgenda) {

			if (agda.getId() == (Long) event.getScheduleEvent().getData()) {
				agenda = agda;
				// salvar sua agenda no banco
				break;
			}
		}
	}

	/**
	 * Evento para quando o usuario 'redimenciona' um evento
	 * 
	 * @param event
	 */
	public void quandoRedimensionado(ScheduleEntryResizeEvent event) {

		for (Agenda agda : listaAgenda) {
			if (agda.getId() == (Long) event.getScheduleEvent().getData()) {
				agenda = agda;
				// salvar sua agenda no banco
				break;
			}
		}
	}

	// getters and setters
	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public ScheduleModel getEventModel() {
		if (eventModel.getEventCount() == 0) {
			inicializar();
		}
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public String getTipoAgenda() {
		return tipoAgenda;
	}

	public void setTipoAgenda(String tipoAgenda) {
		this.tipoAgenda = tipoAgenda;
	}

	/**
	 * http://www.codigosfontes.com.br/como-popular-um-hselectonemenu-atraves-de
	 * -enums/
	 * 
	 * @return
	 */
	public List<String> getTiposAgenda() {
		return Arrays.asList("GLOBAL");
	}

	public List<Departamento> getListaDepartamento() {
		if (listaDepartamento == null) {
			listaDepartamento = departamentoService.lista();
		}
		return listaDepartamento;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}
	
	
}