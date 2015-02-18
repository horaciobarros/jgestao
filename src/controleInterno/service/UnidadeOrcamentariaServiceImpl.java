package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controleInterno.model.Orgao;
import controleInterno.model.Unidade;
import controleInterno.model.UnidadeOrcamentaria;
import controleInterno.model.UnidadeOrcamentariaDao;

@Service("unidadeOrcamentariaService")
@Transactional
public class UnidadeOrcamentariaServiceImpl implements UnidadeOrcamentariaService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	UnidadeOrcamentariaDao dao;

	public boolean salvar(UnidadeOrcamentaria d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}

	public UnidadeOrcamentaria buscaUnidadeOrcamentariaPeloId(long id) {
		return dao.buscaUnidadeOrcamentariaPeloId(id);
	}

	public void altera(UnidadeOrcamentaria unidadeOrcamentaria) {
		dao.altera(unidadeOrcamentaria);
	}

	public void adiciona(UnidadeOrcamentaria unidadeOrcamentaria) {
		dao.adiciona(unidadeOrcamentaria);
	}

	public List<UnidadeOrcamentaria> lista() {
		return dao.lista();
	}

	public List<Orgao> listaOrgao() {
		return dao.listaOrgao();
	}

	public List<Unidade> listaUnidade() {
		return dao.listaUnidade();
	}

	public void alteraUnidade(Unidade unidade) {
		dao.alteraUnidade(unidade);
	}

	public void adicionaUnidade(Unidade unidade) {
		dao.adicionaUnidade(unidade);
	}
	
	public void alteraOrgao(Orgao orgao) {
		dao.alteraOrgao(orgao);
	}

	public void adicionaOrgao(Orgao orgao) {
		dao.adicionaOrgao(orgao);
		
	}
	
	public Orgao buscaOrgaoPeloId(long id) {
		return dao.buscaOrgaoPeloId(id);
	}
	
	public Unidade buscaUnidadePeloId(long id) {
		return dao.buscaUnidadePeloId(id);
	}


}
