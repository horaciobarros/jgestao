package controleInterno.model;

import java.util.List;

import org.hibernate.SessionFactory;

public interface UnidadeOrcamentariaDao {

	public boolean existe(UnidadeOrcamentaria unidade);
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);
	public void adiciona(UnidadeOrcamentaria unidade);
	public void exclui(UnidadeOrcamentaria unidade);
	public void altera(UnidadeOrcamentaria unidade);
	public List<UnidadeOrcamentaria> lista();
	public UnidadeOrcamentaria buscaUnidadeOrcamentariaPeloId(long id);
	
	// ---- Manipulando órgao
	public Orgao buscaOrgaoPeloId(long id);	
	public List<Orgao> listaOrgao();
	
	public void adicionaOrgao(Orgao o);
	public void excluiOrgao(Orgao o);
	public void alteraOrgao(Orgao o);
	// --- Manipulando unidade
	public Unidade buscaUnidadePeloId(long id);
	
	public List<Unidade> listaUnidade();
	
	public void adicionaUnidade(Unidade u );
	public void excluiUnidade(Unidade u);
	public void alteraUnidade(Unidade u);
	

}
