package acesso.model;

import java.util.List;

import org.hibernate.Query;

public class EmpresaDAO extends CadastroDAO {
	
	public boolean existe(Empresa empresa) {
		
		Query query = session
				.createQuery("from Empresa p where p.id = :pid ");
		query.setParameter("pid", empresa.getId());
		List lista = query.list();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
	}

	public Empresa buscaEmpresaUsuariaPeloId(long id) {

		tx = session.beginTransaction();
		Query select = session.createQuery("from Empresa where id = " + id);
		List<Empresa> objetos = select.list();
		tx.commit();
		session.close();
		return objetos.get(0);

	}

	public List<Empresa> getLista() {

		tx = session.beginTransaction();
		Query select = session.createQuery("from Empresa ");
		select.setMaxResults(200);
		List<Empresa> objetos = select.list();
		tx.commit();
		session.close();

		return objetos;

	}

	public boolean adiciona(Empresa empresa) {

		boolean adicionado = false;

		try {
			session.beginTransaction();
			session.save(empresa);
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
	
	public boolean altera(Empresa empresa) {

		boolean adicionado = false;

		try {
			session.beginTransaction();
			session.update(empresa);
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
	
	public List<Empresa> listaTodos() {

		Query select = session.createQuery("from Empresa");
		List<Empresa> objetos = select.list();
		session.close();

		return objetos;

	}

}