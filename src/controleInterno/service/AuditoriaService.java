package controleInterno.service;

import java.io.Serializable;
import java.util.List;

import controleInterno.model.Auditoria;

public interface AuditoriaService extends Serializable{
	

	public boolean salvar(Auditoria d);
	public Object buscaAuditoriaPeloId(long id);

	public void altera(Auditoria auditoria);

	public void adiciona(Auditoria auditoria);

	public List<Auditoria> lista();

	public Auditoria buscaAuditoria(Auditoria auditoria);
	public void exclui(Auditoria auditoria);
	
	public List<Auditoria> pesquisar(Auditoria auditoria);

}
