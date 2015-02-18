package acesso.model;

import java.util.List;

import org.hibernate.SessionFactory;

public interface UsuarioDao {

	public boolean existe(Usuario usuario);
	
	public void adiciona(Usuario usuario);
	
	public void exclui(Usuario usuario);

	public void altera(Usuario usuario);
	
	public List<Usuario> lista();
	
	public Usuario busca(Usuario u);
	
	public Usuario buscaPeloId(long id);
	

	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

}
