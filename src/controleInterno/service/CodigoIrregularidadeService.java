package controleInterno.service;

import java.util.List;

import controleInterno.model.CodigoIrregularidade;

public interface CodigoIrregularidadeService {
	public boolean salvar(CodigoIrregularidade d);
	public Object buscaCodigoIrregularidadePeloId(long id);

	public void altera(CodigoIrregularidade codigoIrregularidade);
	public void adiciona(CodigoIrregularidade codigoIrregularidade);

	public List<CodigoIrregularidade> lista();


	public CodigoIrregularidade buscaCodigoIrregularidade(CodigoIrregularidade codigoIrregularidadeLogado);


}
