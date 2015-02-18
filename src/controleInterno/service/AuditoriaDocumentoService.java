package controleInterno.service; 

import java.io.*;
import java.util.*;
import controleInterno.model.AuditoriaDocumento;

public interface AuditoriaDocumentoService extends Serializable {

   public boolean existe(AuditoriaDocumento auditoriadocumento);

   public void adiciona(AuditoriaDocumento auditoriadocumento);

   public void exclui(AuditoriaDocumento auditoriadocumento);

   public void altera(AuditoriaDocumento auditoriadocumento);

   public List<AuditoriaDocumento> lista();

   public Object buscaAuditoriaDocumentoPeloId(long id);
   
   public List<AuditoriaDocumento> listaPorAuditoria(Long idAuditoria);

}