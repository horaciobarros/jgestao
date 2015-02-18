package acesso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_sistema")
public class TipoSistema implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sigla_tipo_sistema")
	private String siglaTipoSistema;
	
	private String descricao;
	
	@Column(name = "nome_sistema")
	private String nomeSistema;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getSiglaTipoSistema() {
		return siglaTipoSistema;
	}

	public void setSiglaTipoSistema(String siglaTipoSistema) {
		this.siglaTipoSistema = siglaTipoSistema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nomeSistema == null) ? 0 : nomeSistema.hashCode());
		result = prime
				* result
				+ ((siglaTipoSistema == null) ? 0 : siglaTipoSistema.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoSistema other = (TipoSistema) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeSistema == null) {
			if (other.nomeSistema != null)
				return false;
		} else if (!nomeSistema.equals(other.nomeSistema))
			return false;
		if (siglaTipoSistema == null) {
			if (other.siglaTipoSistema != null)
				return false;
		} else if (!siglaTipoSistema.equals(other.siglaTipoSistema))
			return false;
		return true;
	}

	
}
