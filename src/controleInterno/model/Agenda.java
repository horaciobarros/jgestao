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

import org.springframework.stereotype.Repository;
 
/**
*
* @author http://www.codigosfontes.com.br
*/
@Repository
@Entity
@Table(name="agenda")
public class Agenda implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
 

	@Column(name="descricao")
    private String descricao;
 

	@Column(name="data_inicio")
    private Date dataInicio;
 

	@Column(name="data_fim")
    private Date dataFim;
 

	@Column(name="dia_todo")
    private boolean diaTodo;
 

	@Column(name="tipo_agenda")
    private String tipoAgenda;
    

	@Column(name="lista_emails")
    private String listaEmails;
    

	@Column(name="tipo_notificacao")
    private String tipoNotificacao;
	
	@Column(name="responsavel")
    private String responsavel;
	
	@Column(name="email")
    private String email;
	
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
    
   
 
    //getters and setters
    public Date getDataFim() {
        return dataFim;
    }
 
    public void setDataFim(Date datafim) {
        this.dataFim = datafim;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public String getTipoAgenda() {
        return tipoAgenda;
    }
 
    public void setTipoAgenda(String tipoAgenda) {
        this.tipoAgenda = tipoAgenda;
    }
 
    public boolean isDiaTodo() {
        return diaTodo;
    }
 
    public void setDiaTodo(boolean diaTodo) {
        this.diaTodo = diaTodo;
    }
 
    public Date getDataInicio() {
        return dataInicio;
    }
 
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((departamento == null) ? 0 : departamento.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (diaTodo ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((listaEmails == null) ? 0 : listaEmails.hashCode());
		result = prime * result
				+ ((responsavel == null) ? 0 : responsavel.hashCode());
		result = prime * result
				+ ((tipoAgenda == null) ? 0 : tipoAgenda.hashCode());
		result = prime * result
				+ ((tipoNotificacao == null) ? 0 : tipoNotificacao.hashCode());
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
		Agenda other = (Agenda) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (departamento == null) {
			if (other.departamento != null)
				return false;
		} else if (!departamento.equals(other.departamento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (diaTodo != other.diaTodo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaEmails == null) {
			if (other.listaEmails != null)
				return false;
		} else if (!listaEmails.equals(other.listaEmails))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		if (tipoAgenda == null) {
			if (other.tipoAgenda != null)
				return false;
		} else if (!tipoAgenda.equals(other.tipoAgenda))
			return false;
		if (tipoNotificacao == null) {
			if (other.tipoNotificacao != null)
				return false;
		} else if (!tipoNotificacao.equals(other.tipoNotificacao))
			return false;
		return true;
	}

	public String getListaEmails() {
		return listaEmails;
	}

	public void setListaEmails(String listaEmails) {
		this.listaEmails = listaEmails;
	}

	public String getTipoNotificacao() {
		return tipoNotificacao;
	}

	public void setTipoNotificacao(String tipoNotificacao) {
		this.tipoNotificacao = tipoNotificacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
    
    
}