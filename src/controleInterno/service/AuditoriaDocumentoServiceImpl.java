package controleInterno.service;

import java.io.*;
import java.util.*;

import controleInterno.model.AuditoriaDocumento;
import controleInterno.model.AuditoriaDocumentoDao;
import controleInterno.service.AuditoriaDocumentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;

@Service("AuditoriaDocumentoService")
public class AuditoriaDocumentoServiceImpl implements AuditoriaDocumentoService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private AuditoriaDocumentoDao dao;

	StringBuilder hql;

	public boolean existe(AuditoriaDocumento auditoriadocumento) {
		return dao.existe(auditoriadocumento);
	}

	public void adiciona(AuditoriaDocumento auditoriadocumento) {
		dao.adiciona(auditoriadocumento);
	}

	public void exclui(AuditoriaDocumento auditoriadocumento) {
		dao.exclui(auditoriadocumento);
	}

	public void altera(AuditoriaDocumento auditoriadocumento) {
		dao.altera(auditoriadocumento);
	}

	public List<AuditoriaDocumento> lista() {
		return dao.lista();
	}

	public Object buscaAuditoriaDocumentoPeloId(long id) {
		return dao.buscaAuditoriaDocumentoPeloId(id);
	}

	@Override
	public List<AuditoriaDocumento> listaPorAuditoria(Long idAuditoria) {
		// TODO Auto-generated method stub
		return dao.listaPorAuditoria(idAuditoria);
	}
}