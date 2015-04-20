package controleInterno.view;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import controleInterno.model.Arquivo;
import controleInterno.service.ArquivoService;
import util.Util;

@SessionScoped
@Component
@ManagedBean(name = "arquivoBean")
public class ArquivoBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Arquivo arquivo;
	@Autowired
	private ArquivoService arquivoService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private StreamedContent fileArquivo;
	byte[] arrayFileArquivo;
	private Long idReferencia;
	private String tabela;
	private UploadedFile file;

	public ArquivoBean() {
		arquivo = new Arquivo();

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {

			if (arquivo.getId() != null) {
				try {
					arquivo.setCaminhoArquivo(gravaNoServidor(arquivo.getId(),
							this.file.getFileName()));

					arquivoService.altera(arquivo);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");
					fileArquivo = null;
					arquivo = null;

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					arquivo.setCaminhoArquivo(gravaNoServidor(
							this.idReferencia, this.file.getFileName()));
					arquivoService.adiciona(arquivo);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");
					fileArquivo = null;
					arquivo = null;

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

			}
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (arquivo.getDescricao() == null || arquivo.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}

		return retorno;
	}

	public void handleFileUploadArquivo(FileUploadEvent event) {
		try {
			fileArquivo = new DefaultStreamedContent(event.getFile()
					.getInputstream());
			this.file = event.getFile();
			arquivo = new Arquivo();

			arquivo.setDescricao(this.file.getFileName());
			arquivo.setTipoArquivo(this.file.getContentType());
			arquivo.setTabela(getTabela());
			arquivo.setIdReferencia(getIdReferencia());
		} catch (IOException ex) {
			Logger.getLogger(ArquivoBean.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private String gravaNoServidor(Long id, String fileName) throws IOException {

		String caminhoArquivo = criaPastasSeNaoExistirem(getTabela()) + "/" + "id_"
				+ id + "_" + fileName;
		InputStream in;

		in = new BufferedInputStream(this.file.getInputstream());
		FileOutputStream fos = new FileOutputStream(caminhoArquivo);
		while (in.available() != 0) {
			fos.write(in.read());
		}
		fos.close();

		fos.flush();
		fos.close();
		in.close();

		return caminhoArquivo;

	}

	private String criaPastasSeNaoExistirem(String tabelaMae) {
		File file = new File("/home/horaciob/" + tabelaMae + "/");
		if (!file.exists()) {
			file.mkdirs();
		}

		return file.getAbsolutePath();
	}

	public StreamedContent getFileA() {
		if (arquivo == null)
			arquivo = new Arquivo();
		if (fileArquivo == null) {

			arquivo = arquivoService.buscaArquivoPeloId(arquivo);

		}
		arrayFileArquivo = arquivo.getConteudo();
		try {
			InputStream is = new ByteArrayInputStream(arrayFileArquivo);
			this.fileArquivo = new DefaultStreamedContent(is);
		} catch (Exception e) {

		}

		return fileArquivo;
	}

	public void setFileBrasao(StreamedContent fileArquivo) {
		this.fileArquivo = fileArquivo;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public StreamedContent getFileArquivo() {
		return fileArquivo;
	}

	public void setFileArquivo(StreamedContent fileArquivo) {
		this.fileArquivo = fileArquivo;
	}

	public Long getIdReferencia() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		idReferencia = (Long) session.getAttribute("arquivoIdReferencia");
		return idReferencia;
	}

	public void setIdReferencia(Long idReferencia) {
		this.idReferencia = idReferencia;
	}

	public String getTabela() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				true);
		tabela = (String) session.getAttribute("arquivoTabela");
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String voltar() {

		if (this.tabela != null && this.tabela.equals("auditoria")) {
			return "/controleInterno/cadastros/auditoria.jsf";
		}
		return "/controleInterno/cadastros/auditoria.jsf";

	}

}
