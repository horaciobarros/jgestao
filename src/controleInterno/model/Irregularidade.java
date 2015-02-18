package controleInterno.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="irregularidades")
public class Irregularidade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name="codigo")
	private CodigoIrregularidade codigoIrregularidade;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CodigoIrregularidade getCodigoIrregularidade() {
		return codigoIrregularidade;
	}

	public void setCodigoIrregularidade(CodigoIrregularidade codigoIrregularidade) {
		this.codigoIrregularidade = codigoIrregularidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codigoIrregularidade == null) ? 0 : codigoIrregularidade
						.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		Irregularidade other = (Irregularidade) obj;
		if (codigoIrregularidade == null) {
			if (other.codigoIrregularidade != null)
				return false;
		} else if (!codigoIrregularidade.equals(other.codigoIrregularidade))
			return false;
		if (id != other.id)
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
			return false;
		return true;
	}

	
}
