package controleInterno.model;

import java.util.List;


public interface CodigoIrregularidadeDao {
	
	public boolean existe(CodigoIrregularidade codigoIrregularidade);
	public void adiciona(CodigoIrregularidade codigoIrregularidade);
	public void exclui(CodigoIrregularidade codigoIrregularidade);	
	public void altera(CodigoIrregularidade codigoIrregularidade);
	public List<CodigoIrregularidade> lista();

	public CodigoIrregularidade buscaCodigoIrregularidade(CodigoIrregularidade d);
	public Object buscaCodigoIrregularidadePeloId(long id);
}
