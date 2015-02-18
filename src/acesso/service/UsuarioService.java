package acesso.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import acesso.model.Usuario;
import acesso.model.UsuarioDao;

public interface UsuarioService extends Serializable{ 

		/**
		 * Add Usuario
		 * 
		 * @param usuario
		 *            Usuario
		 */
		@Transactional(readOnly = false)
		public void adiciona(Usuario usuario);

		/**
		 * Delete Usuario
		 * 
		 * @param usuario
		 *            Usuario
		 */
		@Transactional(readOnly = false)
		public void exclui(Usuario usuario);

		/**
		 * Update Usuario
		 * 
		 * @param usuario
		 *            Usuario
		 */
		@Transactional(readOnly = false)
		public void altera(Usuario usuario);

		/**
		 * Get Usuario
		 * 
		 * @param id
		 *            int Usuario Id
		 */

		@Transactional(readOnly = false)
		public Usuario buscaPeloId(Long id);

		/**
		 * Get Usuario List
		 * 
		 */
		@Transactional(readOnly = false)
		public List<Usuario> lista();

		/**
		 * Get Usuario DAO
		 * 
		 * @return usuarioDAO - Usuario DAO
		 */
		public UsuarioDao getUsuarioDao();

		/**
		 * Set Usuario DAO
		 * 
		 * @param usuarioDAO
		 *            - UsuarioDAO
		 */
		public void setUsuarioDao(UsuarioDao usuarioDAO);

		@Transactional(readOnly = false)
		public boolean existe(Usuario usuario);

		@Transactional(readOnly = false)
		public Usuario busca(Usuario usuario);

	

}
