package controleInterno.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.model.Auditoria;
import controleInterno.model.AuditoriaDocumento;
import controleInterno.service.AuditoriaDocumentoService;

@SessionScoped
@Component
@ManagedBean(name = "auditoriaDocumentoBean")
public class AuditoriaDocumentoBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Auditoria auditoria;
	@Autowired
	private AuditoriaDocumentoService auditoriaDocumentoService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	
	private AuditoriaDocumento auditoriaDocumento;

	public Auditoria getAuditoria() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		auditoria = (Auditoria) session.getAttribute("auditoria");
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public AuditoriaDocumento getAuditoriaDocumento() {
		if (auditoriaDocumento == null) {
			auditoriaDocumento = new AuditoriaDocumento();
		}
		return auditoriaDocumento;
	}

	public void setAuditoriaDocumento(AuditoriaDocumento auditoriaDocumento) {
		this.auditoriaDocumento = auditoriaDocumento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMSG_ERRO_NAO_PREENCHIMENTO_CAMPOS() {
		return MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS;
	}
	
	public String voltar() {

		if (this.auditoria != null && this.auditoria.equals("auditoria")) {
			return "/controleInterno/cadastros/auditoria.jsf";
		}
		return "/controleInterno/cadastros/auditoria.jsf";

	}
	
	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (auditoriaDocumento.getId() != null && auditoriaDocumento.getId() != 0) {
				try {
					
					auditoriaDocumentoService.altera(auditoriaDocumento);

					Util.msgSucesso("Dados alterados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					auditoriaDocumento.setAuditoria(auditoria);
					auditoriaDocumentoService.adiciona(auditoriaDocumento);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

				
			}
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		
		if (auditoriaDocumento.getDataDocumento() == null) {
			Util.msgErro("Data não informada:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		
		if (auditoriaDocumento.getDescricao() == null) {
			Util.msgErro("Descrição não informada:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}
		
		if (auditoriaDocumento.getTipoDocumento() == null) {
			Util.msgErro("Tipo de Documento não informado:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}



		return retorno;
	}

	
	
}
