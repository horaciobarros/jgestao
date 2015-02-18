
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
@Table(name="normas_procedimentos")
public class NormasProcedimentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="ano")
	private String ano;
	
	@Column(name="data_elaboracao")
	private Date dataElaboracao;
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
	@Column(name="referencia")
	private String referencia;
	
	@Column(name="areas_interesse")
	private String areasInteresse;
	
	@Column(name="texto")
	private String texto;
	
	@ManyToOne
	@JoinColumn(name="legislacao")
	private Legislacao legislacao;
	
	@Column(name="data_publicacao")
	private Date dataPublicacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Date getDataElaboracao() {
		return dataElaboracao;
	}

	public void setDataElaboracao(Date dataElaboracao) {
		this.dataElaboracao = dataElaboracao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getAreasInteresse() {
		return areasInteresse;
	}

	public void setAreasInteresse(String areasInteresse) {
		this.areasInteresse = areasInteresse;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Legislacao getLegislacao() {
		return legislacao;
	}

	public void setLegislacao(Legislacao legislacao) {
		this.legislacao = legislacao;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result
				+ ((areasInteresse == null) ? 0 : areasInteresse.hashCode());
		result = prime * result
				+ ((dataElaboracao == null) ? 0 : dataElaboracao.hashCode());
		result = prime * result
				+ ((dataPublicacao == null) ? 0 : dataPublicacao.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((legislacao == null) ? 0 : legislacao.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		NormasProcedimentos other = (NormasProcedimentos) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (areasInteresse == null) {
			if (other.areasInteresse != null)
				return false;
		} else if (!areasInteresse.equals(other.areasInteresse))
			return false;
		if (dataElaboracao == null) {
			if (other.dataElaboracao != null)
				return false;
		} else if (!dataElaboracao.equals(other.dataElaboracao))
			return false;
		if (dataPublicacao == null) {
			if (other.dataPublicacao != null)
				return false;
		} else if (!dataPublicacao.equals(other.dataPublicacao))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (id != other.id)
			return false;
		if (legislacao == null) {
			if (other.legislacao != null)
				return false;
		} else if (!legislacao.equals(other.legislacao))
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
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	

	
}
