package controleInterno.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public interface LegislacaoDao extends Serializable {
	
	public boolean existe(Legislacao legislacao);
	public void adiciona(Legislacao legislacao);
	public void exclui(Legislacao legislacao);	
	public void altera(Legislacao legislacao);
	public List<Legislacao> lista();

	public Object buscaLegislacaoPeloId(long id);
	public Legislacao buscaLegislacao(Legislacao legislacaoLogado);
	
	public List<Legislacao> pesquisar(Date periodoInicial, Date periodoFinal,
			TipoLegislacao tipoLegislacao, String conteudo);


}
