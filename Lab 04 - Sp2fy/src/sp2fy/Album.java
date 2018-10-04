package sp2fy;

import java.util.ArrayList;

/**
 * Abstração de álbum no sistema "sp2fy". 
 * @author Christopher
 *
 */
public class Album {

	private String artista;
	private String titulo;
	private int anoLancamento;
	ArrayList<Musica> faixas;

	/**
	 * Construtor da classe "Álbum".
	 * @param artista
	 * @param titulo
	 * @param ano
	 * @throws Exception
	 */
	public Album(String artista, String titulo, int ano) throws Exception {

		if (artista == null || artista.trim().isEmpty()) {
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}
		if (ano <= 1900) {
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}
		if (titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}

		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = ano;
		this.faixas = new ArrayList<Musica>();

	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	/**
	 * Adiciona uma música no álbum.
	 * @param musica
	 * @return "true", caso afirmativo; "false", caso contrário.
	 * @throws Exception
	 */
	public boolean adicionaMusica(Musica musica) throws Exception {
		if (musica != null) {
			return this.faixas.add(musica);
		}
		return false;
	}

	/**
	 * Verifica se um álbum contém uma música passada como parâmetro.
	 * @param nomeMusica
	 * @return "true", caso afirmativo; "false", caso contrário.
	 */
	public boolean contemMusica(String nomeMusica) {
		for (Musica musica : this.faixas) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) 
				return true;
		}
		return false;
	}

	/**
	 * Remove uma música do álbum.
	 * @param posicao
	 */
	public void removeMusica(int posicao) {
		this.faixas.remove(posicao - 1);
	}

	/**
	 * Retorna a quantidade de faixas do álbum.
	 * @return
	 */
	public int quantidadeFaixas() {
		return this.faixas.size();
	}

	/**
	 * Retorna uma música existente no álbum.
	 * @param nomeMusica
	 * @return A música, em caso afirmativo; null, em caso contrário.
	 */
	public Musica getMusica(String nomeMusica) {
		for (Musica musica : this.faixas) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) {
				return musica;
			}
		}
		return null;
	}

	/**
	 * Retorna a duração total do álbum.
	 * @return Um inteiro que expressa a quantidade de tempo de reprodução de um álbum.
	 */
	public int getDuracaoTotal() {
		int duracao = 0;
		
		for (Musica musica : this.faixas) 
			duracao += musica.getDuracao();
		
		return duracao;
	}

	/**
	 * Método que obtém uma música de um álbum, pela faixa, passada como parâmetro.
	 * @param faixa
	 * @return A música, em caso afirmativo; null, em caso contrário.
	 */
	public Musica getMusicaPorFaixa(int faixa) {
		for (int i = 0; i < this.faixas.size(); i++) {
			if (i == faixa - 1) {
				return this.faixas.get(i);
			}
		}
		return null;
	}

	public boolean equals(Object objeto) {
		if (objeto instanceof Album) {
			Album outroAlbum = (Album) objeto;
			if (outroAlbum.getTitulo().equalsIgnoreCase(this.getTitulo())
					&& outroAlbum.getArtista().equalsIgnoreCase(this.getArtista())) {
				return true;
			}
		}
		return false;
	}
}
