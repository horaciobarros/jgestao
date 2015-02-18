package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

	public static void msgErro(String texto1, String texto2) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, texto1, texto2));

	}

	public static void msgSucesso(String texto1, String texto2) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, texto1, texto2));

	}

	public static boolean cpfValido(String cpf) {
		return false;
	}

	public static byte[] toArrayDeBytes(InputStream is)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = is.read();
		while (reads != -1) {
			baos.write(reads);
			reads = is.read();
		}
		return baos.toByteArray();
	}
	
	public static boolean stringVazia(String texto) {
		if (texto == null) return true;
		else if (texto.trim().isEmpty()) return true;
		return false;
	}
	
	public static String formataData(Date data, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(data);
	}
	
	public static String textoNotificacaoAgenda() {
		return "<p>PREFEITURA MUNICIPAL DE MODELO<p> " +
	     "<p>SECRETARIA DE CONTROLE INTERNO <p>" +
		"<p>NOTIFICAÇÃO <p>" + 
	     "<p>Esta controladoria vem por meio da presente alertar<p>" +
		"<p>vossa senhoria que hoje expira o prazo para: <p>"; 
		
	}

}
