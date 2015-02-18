package controleInterno.model;

import java.util.List;

import org.hibernate.SessionFactory;

public interface TipoLegislacaoDao {

	public boolean existe(TipoLegislacao tipoLegislacao);
	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);
	public void adiciona(TipoLegislacao tipoLegislacao);
	public void exclui(TipoLegislacao tipoLegislacao);	
	public void altera(TipoLegislacao tipoLegislacao);
	public List<TipoLegislacao> lista();

	public TipoLegislacao buscaTipoLegislacaoPeloId(long id);

}
