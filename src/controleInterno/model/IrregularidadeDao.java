package controleInterno.model;

import java.util.List;


public interface IrregularidadeDao {
	
	public void adiciona(Irregularidade irregularidade);
	public void exclui(Irregularidade irregularidade);	
	public void altera(Irregularidade irregularidade);
	public List<Irregularidade> lista();

	public Object buscaIrregularidadePeloId(long id);
	public List<Irregularidade> buscaIrregularidade(
			Irregularidade irregularidade);


}
