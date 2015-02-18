package controleInterno.model; 

import java.io.*;
import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import controleInterno.model.AuditoriaDocumento;

public interface AuditoriaDocumentoDao extends Serializable {

   public boolean existe(AuditoriaDocumento auditoriadocumento);

   public void adiciona(AuditoriaDocumento auditoriadocumento);

   public void exclui(AuditoriaDocumento auditoriadocumento);

   public void altera(AuditoriaDocumento auditoriadocumento);

   public List<AuditoriaDocumento> lista();

   public Object buscaAuditoriaDocumentoPeloId(long id);

public List<AuditoriaDocumento> listaPorAuditoria(Long idAuditoria);

}