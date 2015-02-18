package controleInterno.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controleInterno.model.LegislacaoDao;
import controleInterno.model.Legislacao;
import controleInterno.model.TipoLegislacao;

@Service("legislacaoService")
public class LegislacaoServiceImpl implements LegislacaoService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	LegislacaoDao dao;

	public boolean salvar(Legislacao d) {
		if (d.getId() == 0)
			dao.adiciona(d);
		else
			dao.altera(d);
		return true;
	}
	
	public Object buscaLegislacaoPeloId(long id) {
		return dao.buscaLegislacaoPeloId(id);
	}

	public void altera(Legislacao legislacao) {
			dao.altera(legislacao);
	}

	public void adiciona(Legislacao legislacao) {
			dao.adiciona(legislacao);
	}

	public List<Legislacao> lista() {
		return dao.lista();
	}


	public Legislacao buscaLegislacao(Legislacao legislacaoLogado) {
		return dao.buscaLegislacao(legislacaoLogado);
	}
	
	public void exclui(Legislacao legislacao) {
		dao.exclui(legislacao);
}

	@Override
	public List<Legislacao> pesquisar(Date periodoInicial, Date periodoFinal,
			TipoLegislacao tipoLegislacao, String conteudo) {
		
		return dao.pesquisar(periodoInicial, periodoFinal,
				tipoLegislacao, conteudo);
	}

	
	

}
