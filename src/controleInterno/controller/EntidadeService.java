package controleInterno.controller;

import java.io.Serializable;
import java.util.List;

import controleInterno.model.Entidade;

public interface EntidadeService  extends Serializable{
	

	public void altera(Entidade e);
	public List<Entidade> lista();

	public boolean existe(Entidade e);
	
	public Entidade buscaEntidadeAtiva();

}
