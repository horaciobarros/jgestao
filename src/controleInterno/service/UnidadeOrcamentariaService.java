package controleInterno.service;

import java.io.Serializable;
import java.util.List;


import controleInterno.model.Orgao;
import controleInterno.model.Unidade;
import controleInterno.model.UnidadeOrcamentaria;

public interface UnidadeOrcamentariaService extends Serializable{
	

	public boolean salvar(UnidadeOrcamentaria d);

	public UnidadeOrcamentaria buscaUnidadeOrcamentariaPeloId(long id);

	public void altera(UnidadeOrcamentaria unidadeOrcamentaria);

	public void adiciona(UnidadeOrcamentaria unidadeOrcamentaria);

	public List<UnidadeOrcamentaria> lista();

	public List<Orgao> listaOrgao();

	public List<Unidade> listaUnidade();

	public void alteraUnidade(Unidade unidade);

	public void adicionaUnidade(Unidade unidade);
	
	public void alteraOrgao(Orgao orgao);

	public void adicionaOrgao(Orgao orgao);
	
	public Orgao buscaOrgaoPeloId(long id);
	
	public Unidade buscaUnidadePeloId(long id);

}
