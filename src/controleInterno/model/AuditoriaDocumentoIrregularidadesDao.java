package controleInterno.model; 

import java.io.*;
import java.util.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import controleInterno.model.AuditoriaDocumentoIrregularidades;

public interface AuditoriaDocumentoIrregularidadesDao extends Serializable {

   public boolean existe(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades);

   public void adiciona(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades);

   public void exclui(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades);

   public void altera(AuditoriaDocumentoIrregularidades auditoriadocumentoirregularidades);

   public List<AuditoriaDocumentoIrregularidades> lista();

   public Object buscaAuditoriaDocumentoIrregularidadesPeloId(long id);

}