package controleInterno.service;

import java.util.List;

import controleInterno.model.Irregularidade;

public interface IrregularidadeService {
	
	public boolean salvar(Irregularidade d);
	
	public Object buscaIrregularidadePeloId(long id);

	public void altera(Irregularidade irregularidade);

	public void adiciona(Irregularidade irregularidade);

	public List<Irregularidade> lista();


	public List<Irregularidade> buscaIrregularidade(Irregularidade irregularidade);

	public List<Irregularidade> listaPorTipoDocumento(String tipoDocumento);
}
