package controleInterno.service;

import java.io.Serializable;
import java.util.List;

import controleInterno.model.Arquivo;

public interface ArquivoService extends Serializable {

		public boolean salvar(Arquivo a);
		
		public Arquivo buscaArquivoPeloTipo(Arquivo a);

		public void altera(Arquivo arquivo);
		public void adiciona(Arquivo arquivo);

		public List<Arquivo> lista();
		
		public Arquivo buscaArquivoPeloId(Arquivo a);
		public List<Arquivo> buscaArquivoPorTabelaIdReferencia(String tabela, Long idReferencia);

}

