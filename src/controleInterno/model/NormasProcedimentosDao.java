package controleInterno.model;

import java.util.List;

public interface NormasProcedimentosDao {
	

	public boolean existe(NormasProcedimentos normasProcedimentos);
	public void adiciona(NormasProcedimentos normasProcedimentos);
	public void exclui(NormasProcedimentos normasProcedimentos);	
	public void altera(NormasProcedimentos normasProcedimentos);
	public List<NormasProcedimentos> lista();

	public Object buscaNormasProcedimentosPeloId(long id);
	public List<NormasProcedimentos> listaComFiltro(NormasProcedimentos np);
	

}
