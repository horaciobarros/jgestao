package controleInterno.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface ImagemDao extends Serializable{
	
	public boolean existe(Imagem imagem);
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);

	public void adiciona(Imagem imagem);
	public void exclui(Imagem imagem);
	public void altera(Imagem imagem);
	public List<Imagem> lista();
	public Imagem buscaImagemPeloTipo(Imagem i);
	public Object buscaImagemPeloId(long id);

}
