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
@Table(name="auditoria_documento")
public class AuditoriaDocumento implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private Long id;

   @ManyToOne
   @JoinColumn(name = "id_auditoria")
   private Auditoria auditoria;

   @Column(name="numero_documento")
   private String numeroDocumento;

   @Column(name="data_documento")
   private Date dataDocumento;

   @Column(name="descricao")
   private String descricao;

   @Column(name="tipo_documento")
   private String tipoDocumento;

   public Long getId() { 
      return id;
   }
   public void  setId(Long id) { 
      this.id = id;
   }


   public  Auditoria  getAuditoria() { 
      return auditoria;
   }
   public void  setAuditoria(Auditoria auditoria) { 
      this.auditoria = auditoria;
   }

   public String getNumeroDocumento() { 
      return numeroDocumento;
   }
   public void  setNumeroDocumento(String numeroDocumento) { 
      this.numeroDocumento = numeroDocumento;
   }

   public Date getDataDocumento() { 
      return dataDocumento;
   }
   public void  setDataDocumento(Date dataDocumento) { 
      this.dataDocumento = dataDocumento;
   }

   public String getDescricao() { 
      return descricao;
   }
   public void  setDescricao(String descricao) { 
      this.descricao = descricao;
   }

   public String getTipoDocumento() { 
      return tipoDocumento;
   }
   public void  setTipoDocumento(String tipoDocumento) { 
      this.tipoDocumento = tipoDocumento;
   }

   @Override 
   public int hashCode() { 
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((auditoria == null) ? 0 : auditoria.hashCode());
      result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
      result = prime * result + ((dataDocumento == null) ? 0 : dataDocumento.hashCode());
      result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
      result = prime * result + ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
      AuditoriaDocumento other = (AuditoriaDocumento) obj;
      if (id == null) {
          if (other.id != null) return false;
       }
      if (auditoria == null) {
          if (other.auditoria != null) return false;
       }
      if (numeroDocumento == null) {
          if (other.numeroDocumento != null) return false;
       }
      if (dataDocumento == null) {
          if (other.dataDocumento != null) return false;
       }
      if (descricao == null) {
          if (other.descricao != null) return false;
       }
      if (tipoDocumento == null) {
          if (other.tipoDocumento != null) return false;
       }
      return true;
   }
}
