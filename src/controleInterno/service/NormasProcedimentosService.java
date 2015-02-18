package controleInterno.service;

import java.util.List;

import controleInterno.model.NormasProcedimentos;

public interface NormasProcedimentosService {

	public boolean salvar(NormasProcedimentos d);
	public Object buscaNormasProcedimentosPeloId(long id);
	public void altera(NormasProcedimentos normasProcedimentos);
	public void adiciona(NormasProcedimentos normasProcedimentos);
	public List<NormasProcedimentos> lista();
	public List<NormasProcedimentos> listaComFiltro(NormasProcedimentos np);
}
