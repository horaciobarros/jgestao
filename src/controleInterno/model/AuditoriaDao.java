package controleInterno.model;

import java.util.List;

public interface AuditoriaDao {
	public void adiciona(Auditoria auditoria);
	public void exclui(Auditoria auditoria);
	public void altera(Auditoria auditoria);
	public List<Auditoria> lista();

	public Object buscaAuditoriaPeloId(long id);

	public Auditoria buscaAuditoria(Auditoria auditoriaLogado);
	
	public List<Auditoria> pesquisar(Auditoria auditoria);
}
