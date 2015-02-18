package acesso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acesso.model.Usuario;
import acesso.model.UsuarioDao;

@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// UsuarioDAO is injected...
	@Autowired
	UsuarioDao usuarioDao;

	/**
	 * Add Usuario
	 * 
	 * @param usuario
	 *            Usuario
	 */
	@Transactional(readOnly = false)
	public void adiciona(Usuario usuario) {
		getUsuarioDao().adiciona(usuario);
	}

	/**
	 * Delete Usuario
	 * 
	 * @param usuario
	 *            Usuario
	 */
	@Transactional(readOnly = false)
	public void exclui(Usuario usuario) {
		getUsuarioDao().exclui(usuario);
	}

	/**
	 * Update Usuario
	 * 
	 * @param usuario
	 *            Usuario
	 */
	@Transactional(readOnly = false)
	public void altera(Usuario usuario) {
		getUsuarioDao().altera(usuario);
	}

	/**
	 * Get Usuario
	 * 
	 * @param id
	 *            int Usuario Id
	 */

	public Usuario buscaPeloId(Long id) {
		return getUsuarioDao().buscaPeloId(id);
	}

	/**
	 * Get Usuario List
	 * 
	 */

	public List<Usuario> lista() {
		return getUsuarioDao().lista();
	}

	/**
	 * Get Usuario DAO
	 * 
	 * @return usuarioDAO - Usuario DAO
	 */
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	/**
	 * Set Usuario DAO
	 * 
	 * @param usuarioDAO
	 *            - UsuarioDAO
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public boolean existe(Usuario usuario) {
		return getUsuarioDao().existe(usuario);
	}

	public Usuario busca(Usuario usuario) {
		return getUsuarioDao().busca(usuario);
	}

}
