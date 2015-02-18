package controleInterno.view;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.service.AgendaService;
import controleInterno.service.AuxiliarService;


@ViewScoped
@Component
@ManagedBean(name = "envioEmailBean")
public class EnvioEmailBean {

	private AuxiliarService service = new AuxiliarService();

	private String nome;
	private String assunto;
	private String comentario;

	private String msg;
	private boolean exibeMsg;
	private Date periodoInicial;
	private Date periodoFinal;
	
	@Autowired
	private AgendaService agendaService;

	public EnvioEmailBean() {
		setExibeMsg(false);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String limpar() {
		setNome(null);
		setAssunto(null);
		setComentario(null);
		setExibeMsg(false);
		return null;

	}

	public String enviar() {
		setExibeMsg(true);
		
		StringBuffer texto = new StringBuffer(Util.textoNotificacaoAgenda());
		try {
			
			service.enviaEmailAgendaInteira(getAssunto(),
					texto.toString(), false, null, getPeriodoInicial(), getPeriodoFinal(), agendaService);
			
			Util.msgSucesso("Pronto!", "Emails enviados com sucesso!");
			
		} catch (Exception e) {
			Util.msgErro("Erro no envio de seu comentário: ", e.getMessage().toString());

			e.printStackTrace();
		}

		return null;
	}
		
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isExibeMsg() {
		return exibeMsg;
	}

	public void setExibeMsg(boolean exibeMsg) {
		this.exibeMsg = exibeMsg;
	}

	private String getIpCliente() throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		String ip = request.getRemoteAddr();

		return ip;
	}

	public String getHostCliente() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc
				.getExternalContext().getRequest();
		return request.getRemoteHost();
	}

	public AuxiliarService getService() {
		return service;
	}

	public void setService(AuxiliarService service) {
		this.service = service;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}
	
	

}

