package controleInterno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import controleInterno.service.ImagemService;
import controleInterno.model.Imagem;
import controleInterno.model.ImagemDao;

@Service("imagemService")
@Transactional
public class ImagemServiceImpl implements ImagemService{
	
		private static final long serialVersionUID = 1L;
		
		@Autowired
		ImagemDao dao;

		public boolean salvar(Imagem d) {
			if (d.getId() == 0)
				dao.adiciona(d);
			else
				dao.altera(d);
			return true;
		}
		
		public Imagem buscaImagemPeloTipo(Imagem i) {
			return dao.buscaImagemPeloTipo(i);
		}

		public void altera(Imagem imagem) {
				dao.altera(imagem);
		}

		public void adiciona(Imagem imagem) {
				dao.adiciona(imagem);
		}

		public List<Imagem> lista() {
			return dao.lista();
		}

}
