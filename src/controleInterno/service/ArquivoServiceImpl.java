package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controleInterno.service.ArquivoService;
import controleInterno.model.Arquivo;
import controleInterno.model.ArquivoDao;

@Service("arquivoService")
@Transactional
public class ArquivoServiceImpl implements ArquivoService{
	
		private static final long serialVersionUID = 1L;
		
		@Autowired
		ArquivoDao dao;

		public boolean salvar(Arquivo d) {
			if (d.getId() == 0)
				dao.adiciona(d);
			else
				dao.altera(d);
			return true;
		}
		
		public Arquivo buscaArquivoPeloTipo(Arquivo i) {
			return dao.buscaArquivoPeloTipo(i);
		}

		public void altera(Arquivo arquivo) {
				dao.altera(arquivo);
		}

		public void adiciona(Arquivo arquivo) {
				dao.adiciona(arquivo);
		}

		public List<Arquivo> lista() {
			return dao.lista();
		}

		@Override
		public Arquivo buscaArquivoPeloId(Arquivo a) {
			
			return null;
		}

		@Override
		public List<Arquivo> buscaArquivoPorTabelaIdReferencia(String tabela,
				Long idReferencia) {
			return dao.buscaArquivoPorTabelaIdReferencia(tabela, idReferencia);
		}

}

