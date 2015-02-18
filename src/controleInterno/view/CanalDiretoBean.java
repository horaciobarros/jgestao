package controleInterno.view;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import controleInterno.service.AuxiliarService;


@ManagedBean
@RequestScoped
public class CanalDiretoBean {

	private AuxiliarService service = new AuxiliarService();

	private String nome;
	private String assunto;
	private String comentario;

	private String msg;
	private boolean exibeMsg;

	public CanalDiretoBean() {
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
		
		StringBuffer texto = new StringBuffer("<h3>Nome: " + nome + "</h3>");
		try {
			texto.append("Ip: " + getIpCliente());
			texto.append("<BR>Login: ");
			texto.append("<BR>Host: " + getHostCliente());
			texto.append("<BR>Comentário: " + getComentario());
		
			//service.enviaEmail(getAssunto(),
			//		texto.toString());
			
			setNome(null);
			setAssunto(null);
			setComentario(null);
			setMsg("Comentário enviado com sucesso. Muito obrigado!");
		} catch (Exception e) {
			setMsg("Erro no envio de seu comentário: " + e.getMessage());

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

}
