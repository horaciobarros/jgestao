package controleInterno.service;

import java.util.List;

import controleInterno.model.Imagem;

public interface ImagemService {

		public boolean salvar(Imagem d);
		
		public Imagem buscaImagemPeloTipo(Imagem i);

		public void altera(Imagem imagem);
		public void adiciona(Imagem imagem);

		public List<Imagem> lista();
}
