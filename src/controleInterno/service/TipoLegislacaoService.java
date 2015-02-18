package controleInterno.service;

import java.util.List;

import controleInterno.model.TipoLegislacao;

public interface TipoLegislacaoService {
	public boolean salvar(TipoLegislacao d);
	
	public Object buscaTipoLegislacaoPeloId(long id);
	public void altera(TipoLegislacao tipoLegislacao);

	public void adiciona(TipoLegislacao tipoLegislacao);

	public List<TipoLegislacao> lista();

}
