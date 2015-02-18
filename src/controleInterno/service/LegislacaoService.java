package controleInterno.service;

import java.util.Date;
import java.util.List;

import controleInterno.model.Legislacao;
import controleInterno.model.TipoLegislacao;

public interface LegislacaoService {
	public boolean salvar(Legislacao d);
	public Object buscaLegislacaoPeloId(long id);
	public void altera(Legislacao legislacao);

	public void adiciona(Legislacao legislacao);

	public List<Legislacao> lista();


	public Legislacao buscaLegislacao(Legislacao legislacaoLogado);
	
	public void exclui(Legislacao legislacao);
	
	public List<Legislacao> pesquisar(Date periodoInicial, Date periodoFinal,
			TipoLegislacao tipoLegislacao, String conteudo);

	


}
