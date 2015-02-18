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

@Entity
public class Legislacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tipo_legislacao")
	private TipoLegislacao tipoLegislacao;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="referencia")
	private String referencia;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="status_legislacao")
	private String statusLegislacao;
	
	@ManyToOne
	@JoinColumn(name="legislacao_vinculada")
	private Legislacao legislacaoVinculada;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public TipoLegislacao getTipoLegislacao() {
		return tipoLegislacao;
	}

	public void setTipoLegislacao(TipoLegislacao tipoLegislacao) {
		this.tipoLegislacao = tipoLegislacao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getStatusLegislacao() {
		return statusLegislacao;
	}

	public void setStatusLegislacao(String statusLegislacao) {
		this.statusLegislacao = statusLegislacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		result = prime
				* result
				+ ((statusLegislacao == null) ? 0 : statusLegislacao.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result
				+ ((tipoLegislacao == null) ? 0 : tipoLegislacao.hashCode());
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
		Legislacao other = (Legislacao) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		if (statusLegislacao == null) {
			if (other.statusLegislacao != null)
				return false;
		} else if (!statusLegislacao.equals(other.statusLegislacao))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (tipoLegislacao == null) {
			if (other.tipoLegislacao != null)
				return false;
		} else if (!tipoLegislacao.equals(other.tipoLegislacao))
			return false;
		return true;
	}

	public Legislacao getLegislacaoVinculada() {
		return legislacaoVinculada;
	}

	public void setLegislacaoVinculada(Legislacao legislacaoVinculada) {
		this.legislacaoVinculada = legislacaoVinculada;
	}

	

	
	
	
	


}
