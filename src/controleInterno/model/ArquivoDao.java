package controleInterno.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface ArquivoDao extends Serializable{
	
	public boolean existe(Arquivo arquivo);
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);

	public void adiciona(Arquivo arquivo);
	public void exclui(Arquivo arquivo);
	public void altera(Arquivo arquivo);
	public List<Arquivo> lista();
	public Arquivo buscaArquivoPeloTipo(Arquivo i);
	public Object buscaArquivoPeloId(long id);
	public List<Arquivo> buscaArquivoPorTabelaIdReferencia(String tabela, Long idReferencia);

}
