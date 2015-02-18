package controleInterno.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="periodo_inicial")
	private Date periodoInicial;
	
	@Column(name="periodo_final")
	private Date periodoFinal;
	
	@Column(name="numero_auditoria")
	private String numeroAuditoria;

	@Column(name="data_documento")
	private Date dataDocumento;
	
	@Column(name="observacao")
	private String observacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_legislacao")
	private Legislacao legislacao;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	

	public String getNumeroAuditoria() {
		return numeroAuditoria;
	}

	public void setNumeroAuditoria(String numeroAuditoria) {
		this.numeroAuditoria = numeroAuditoria;
	}


	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Legislacao getLegislacao() {
		return legislacao;
	}

	public void setLegislacao(Legislacao legislacao) {
		this.legislacao = legislacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataDocumento == null) ? 0 : dataDocumento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((legislacao == null) ? 0 : legislacao.hashCode());
		result = prime * result
				+ ((numeroAuditoria == null) ? 0 : numeroAuditoria.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((periodoFinal == null) ? 0 : periodoFinal.hashCode());
		result = prime * result
				+ ((periodoInicial == null) ? 0 : periodoInicial.hashCode());
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
		Auditoria other = (Auditoria) obj;
		if (dataDocumento == null) {
			if (other.dataDocumento != null)
				return false;
		} else if (!dataDocumento.equals(other.dataDocumento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (legislacao == null) {
			if (other.legislacao != null)
				return false;
		} else if (!legislacao.equals(other.legislacao))
			return false;
		if (numeroAuditoria == null) {
			if (other.numeroAuditoria != null)
				return false;
		} else if (!numeroAuditoria.equals(other.numeroAuditoria))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (periodoFinal == null) {
			if (other.periodoFinal != null)
				return false;
		} else if (!periodoFinal.equals(other.periodoFinal))
			return false;
		if (periodoInicial == null) {
			if (other.periodoInicial != null)
				return false;
		} else if (!periodoInicial.equals(other.periodoInicial))
			return false;
		return true;
	}

	

	
}
