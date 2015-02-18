package acesso.model;

import java.util.List;

import org.hibernate.Query;

public class UsuarioEmpresaDAO extends CadastroDAO {

	public boolean existe(UsuarioEmpresa usuarioEmpresa) {
		Query query = session
				.createQuery("from UsuarioEmpresa p where p.id = :pid ");
		query.setParameter("pid", usuarioEmpresa.getId());
		List lista = query.list();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
	}

	public UsuarioEmpresa buscaUsuarioEmpresaPeloId(long id) {

		Query select = session.createQuery("from UsuarioEmpresa where id = " + id);
		List<UsuarioEmpresa> objetos = select.list();
		tx.commit();
		session.close();
		return objetos.get(0);

	}

	public List<UsuarioEmpresa> getLista() {

		Query select = session.createQuery("from UsuarioEmpresa  ");
		select.setMaxResults(200);
		List<UsuarioEmpresa> objetos = select.list();
		tx.commit();
		session.close();

		return objetos;

	}

	public boolean adiciona(UsuarioEmpresa usuarioEmpresa) {

		boolean adicionado = false;

		try {
			session.beginTransaction();
			session.save(usuarioEmpresa);
			session.flush();
			session.getTransaction().commit();
			session.close();
			adicionado = true;
		} catch (Exception e) {
			System.out.println("Erro de gravação:" + e);
			adicionado = false;
		}

		return adicionado;
	}
	
	public boolean altera(UsuarioEmpresa usuarioEmpresa) {

		boolean adicionado = false;

		try {
			session.beginTransaction();
			session.update(usuarioEmpresa);
			session.flush();
			session.getTransaction().commit();
			session.close();
			adicionado = true;
		} catch (Exception e) {
			System.out.println("Erro de gravação:" + e);
			adicionado = false;
		}

		return adicionado;
	}
	
	public boolean exclui(UsuarioEmpresa usuarioEmpresa) {

		boolean excluido = false;

		try {
			session.beginTransaction();
			session.delete(usuarioEmpresa);
			session.flush();
			session.getTransaction().commit();
			session.close();
			excluido = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return excluido;
	}
	
	public boolean isUsuarioAutorizado(Usuario u, Empresa e) {

		Query select = session.createQuery("from UsuarioEmpresa ue where ue.usuario.id=" + u.getId() +
				" and ue.empresa.id=" + e.getId());
		List<UsuarioEmpresa> objetos = select.list();
		tx.commit();
		session.close();
		
		if (objetos.size()==0) return false;
		else return true;
	}

}