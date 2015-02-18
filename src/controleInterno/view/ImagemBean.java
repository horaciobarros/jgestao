package controleInterno.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import util.Util;
import controleInterno.model.Imagem;
import controleInterno.service.ImagemService;

@SessionScoped
@Component
@ManagedBean(name = "imagemBean")
public class ImagemBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private Imagem imagem;
	@Autowired
	private ImagemService imagemService;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private StreamedContent fileBrasao;
	byte[] arrayFileBrasao;

	public ImagemBean() {
		imagem = new Imagem();

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {

			// imagem.setDescricao("teste");
			imagem.setIdReferencia(1);
			imagem.setTabela("Entidade");
			imagem.setTipoImagem("brasao");

			if (imagem.getId() != 0) {
				try {

					imagemService.altera(imagem);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");
					fileBrasao = null;

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					imagemService.adiciona(imagem);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");
					fileBrasao = null;

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}

			}
		}

	}

	private boolean camposObrigatoriosPreenchidos() {
		boolean retorno = true;
		if (imagem.getDescricao() == null || imagem.getDescricao().isEmpty()) {
			Util.msgErro("Descrição:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}

		return retorno;
	}

	public void handleFileUploadBrasao(FileUploadEvent event) {
		try {
			fileBrasao = new DefaultStreamedContent(event.getFile()
					.getInputstream());
			UploadedFile file = event.getFile();
			this.arrayFileBrasao = Util.toArrayDeBytes(file.getInputstream());
			imagem.setArquivo(this.arrayFileBrasao);
		} catch (IOException ex) {
			Logger.getLogger(ImagemBean.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public StreamedContent getFileBrasao() {
		if (imagem == null)
			imagem = new Imagem();
		if (fileBrasao == null) {

			imagem.setTipoImagem("brasao");
			imagem = imagemService.buscaImagemPeloTipo(imagem);

		}
		arrayFileBrasao = imagem.getArquivo();
		try {
			InputStream is = new ByteArrayInputStream(arrayFileBrasao);
			this.fileBrasao = new DefaultStreamedContent(is);
		} catch (Exception e) {
			
		}

		return fileBrasao;
	}

	public void setFileBrasao(StreamedContent fileBrasao) {
		this.fileBrasao = fileBrasao;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

}
