package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.springframework.beans.factory.annotation.Autowired;

import controleInterno.model.Agenda;
import controleInterno.service.AgendaService;
 
/**
*
* @author http://www.codigosfontes.com.br
*
* Para maiores informações sobre EJB Singleton visite este link:
* http://www.codigosfontes.com.br/classe-singleton-em-java-com-o-ejb/
*
*/
public class AgendaBO implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Agenda> listaAgenda;
    
    @Autowired
    private AgendaService agendaService;
 
    public AgendaBO(){
        listaAgenda = new ArrayList<Agenda>();
    }
 
    public List<Agenda> buscarTodasAgendas(){
    	
    	return agendaService.lista();
    }
 
    public void adicionarAgenda(Agenda agenda){
        listaAgenda.add(agenda);
    }
 
    public void removerAvenda(Agenda agenda){
        listaAgenda.remove(agenda);
    }
}
