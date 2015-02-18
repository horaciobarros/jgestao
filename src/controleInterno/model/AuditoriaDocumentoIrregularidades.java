package controleInterno.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.*;
import java.util.*;

@Entity 
@Table(name="auditoria_documento_irregularidades")
public class AuditoriaDocumentoIrregularidades implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private Long id;

   @ManyToOne
   @JoinColumn(name = "id_auditoria_documento")
   private AuditoriaDocumento auditoriaDocumento;

   @ManyToOne
   @JoinColumn(name = "id_irregularidades")
   private Irregularidade irregularidade;

   public Long getId() { 
      return id;
   }
   public void  setId(Long id) { 
      this.id = id;
   }


   public  AuditoriaDocumento  getAuditoriaDocumento() { 
      return auditoriaDocumento;
   }
   public void  setAuditoriaDocumento(AuditoriaDocumento auditoriaDocumento) { 
      this.auditoriaDocumento = auditoriaDocumento;
   }


   public  Irregularidade  getIrregularidade() { 
      return irregularidade;
   }
   public void  setIrregularidades(Irregularidade irregularidade) { 
      this.irregularidade = irregularidade;
   }

   @Override 
   public int hashCode() { 
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((auditoriaDocumento == null) ? 0 : auditoriaDocumento.hashCode());
      result = prime * result + ((irregularidade == null) ? 0 : irregularidade.hashCode());
      return result;
   }

   @Override 
   public boolean equals(Object obj) {
      if (this == obj)
      return true;
      if (obj == null)
      return true;
      if (getClass() != obj.getClass())
      return false;
      AuditoriaDocumentoIrregularidades other = (AuditoriaDocumentoIrregularidades) obj;
      if (id == null) {
          if (other.id != null) return false;
       }
      if (auditoriaDocumento == null) {
          if (other.auditoriaDocumento != null) return false;
       }
      if (irregularidade == null) {
          if (other.irregularidade != null) return false;
       }
      return true;
   }
}