package acesso.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import controleInterno.model.Entidade;

public interface EntidadeDao {
		public boolean existe(Entidade entidade);
		public void altera(Entidade e);
		public Entidade buscaEntidadeAtiva();
		public List<Entidade> lista();
}
