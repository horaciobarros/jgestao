package controleInterno.view;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfAWriter;

import util.Util;
import controleInterno.model.Departamento;
import controleInterno.model.Legislacao;
import controleInterno.model.NormasProcedimentos;
import controleInterno.service.DepartamentoService;
import controleInterno.service.LegislacaoService;
import controleInterno.service.NormasProcedimentosService;

@Scope("request")
@ManagedBean(name = "normasProcedimentosBean")
@Component
public class NormasProcedimentosBean implements Serializable {

	private static final long serialVersionUID = -3717284916971568255L;
	private NormasProcedimentos normasProcedimentos;
	@Autowired
	private NormasProcedimentosService normasProcedimentosRN;
	@Autowired
	private LegislacaoService legislacaoRN;
	private final String MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS = "Campo deve ser informado";
	private List<NormasProcedimentos> lista;
	private List<Legislacao> listaLegislacao;
	@Autowired
	private DepartamentoService departamentoRN;
	private List<Departamento> listaDepartamento;

	public NormasProcedimentosBean() {

	}

	public void gravar() {

		if (camposObrigatoriosPreenchidos()) {
			if (normasProcedimentos.getId() != 0) {
				try {
					normasProcedimentosRN.altera(normasProcedimentos);

					Util.msgSucesso("Dados gravados com sucesso!",
							"Cadastro atualizado!");

				} catch (Exception e) {

					Util.msgErro("Erro de gravação", e.toString());
				}
			} else {
				try {
					normasProcedimentosRN.adiciona(normasProcedimentos);

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
		if (normasProcedimentos.getLegislacao() == null) {
			Util.msgErro("Legislação:", MSG_ERRO_NAO_PREENCHIMENTO_CAMPOS);
			retorno = false;
		}

		return retorno;
	}

	public NormasProcedimentos getNormasProcedimentos() {
		if (normasProcedimentos == null)
			normasProcedimentos = new NormasProcedimentos();
		return normasProcedimentos;
	}

	public void setNormasProcedimentos(NormasProcedimentos normasProcedimentos) {
		this.normasProcedimentos = normasProcedimentos;
	}

	public List<NormasProcedimentos> getLista() {

		if (lista == null || lista.size() == 0) lista = normasProcedimentosRN.lista();
		return lista;
	}

	public void setLista(List<NormasProcedimentos> lista) {
		this.lista = lista;
	}

	public String editar() {
		return "/controleInterno/cadastros/normasProcedimentos.jsf";

	}

	public List<Legislacao> getListaLegislacao() {
		listaLegislacao = legislacaoRN.lista();
		return listaLegislacao;
	}

	public void setListaLegislacao(List<Legislacao> listaLegislacao) {
		this.listaLegislacao = listaLegislacao;
	}

	public List<Departamento> getListaDepartamento() {
		if (listaDepartamento == null) {
			listaDepartamento = departamentoRN.lista();
		}
		return listaDepartamento;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}

	public void pesquisar() {
		lista = normasProcedimentosRN.listaComFiltro(normasProcedimentos);
	}

	public String incluir() {
		normasProcedimentos = new NormasProcedimentos();
		return "/controleInterno/cadastros/normasProcedimentos.jsf";
	}

	public void imprimirManual() {

		String PDF_URL = "/home/horaciob/manual_normas_procedimentos.pdf";

		// criação do objeto documento
		HttpServletResponse response = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		ServletContext serveletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		Document document = new Document(PageSize.A4);
		try {

			PdfAWriter.getInstance(document, new FileOutputStream(PDF_URL));
			document.open();

			for (NormasProcedimentos np : getLista()) {
				if (np.getTexto().isEmpty())
					continue;
				if (!Util.stringVazia(normasProcedimentos.getTipo()) && !np.getTipo().equals(normasProcedimentos.getTipo())) continue;
				if (!Util.stringVazia(normasProcedimentos.getNumero()) && !np.getNumero().equals(normasProcedimentos.getNumero())) continue;
				if (!Util.stringVazia(normasProcedimentos.getAno()) && !np.getAno().equals(normasProcedimentos.getAno())) continue;
				// adicionando um parágrafo ao documento
				HTMLWorker htmlWorker = new HTMLWorker(document);
				String str = np.getTexto();
				htmlWorker.parse(new StringReader(str));

				// inserindo imagem
				/*
				 * Image img =
				 * Image.getInstance("/home/horaciob/imagem_teste.jpg");
				 * img.setAlignment(Element.ALIGN_CENTER); document.add(img);
				 */
			}

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		try {
			document.add(new Paragraph("-"));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		document.close();

		FacesContext facesContext = FacesContext.getCurrentInstance();

		response = (HttpServletResponse) facesContext.getExternalContext()
				.getResponse();

		response.reset(); // Reset the response in the first place
		response.setHeader("Content-Type", "application/pdf"); // Set only the
																// content type

		OutputStream responseOutputStream;
		try {
			responseOutputStream = response.getOutputStream();
			File f = new File(PDF_URL);
			InputStream pdfInputStream = new FileInputStream(f);  

			byte[] bytesBuffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
				responseOutputStream.write(bytesBuffer, 0, bytesRead);
			}

			responseOutputStream.flush();

			pdfInputStream.close();
			responseOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		facesContext.responseComplete();

	}

	public static byte[] fileToByte(File imagem) throws Exception {
		FileInputStream fis = new FileInputStream(imagem);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int bytesRead = 0;
		while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
			baos.write(buffer, 0, bytesRead);
		}
		return baos.toByteArray();
	}

	public String voltar() {
		return "/controleInterno/cadastros/pesquisaNormasProcedimentos.jsf";
	}
}
