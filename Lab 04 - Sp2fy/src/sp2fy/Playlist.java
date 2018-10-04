package sp2fy;

import java.util.ArrayList;

/**
 * Abstração de uma playlist no nosso sistema de músicas. 
 * @author Christopher
 */
public class Playlist {

	private String nomePlaylist;
	private ArrayList<Musica> minhasMusicas;

	/**
	 * Construtor da classe "Playlist".
	 * @param nome
	 * @throws Exception
	 */
	public Playlist(String nome) throws Exception {

		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Nome da Playlist invalido.");
		}

		this.nomePlaylist = nome;
		this.minhasMusicas = new ArrayList<Musica>();
	}
	
	public String getNomePlaylist() {
		return this.nomePlaylist;
	}

	/**
	 * Adiciona uma música à playlist.
	 * @param musica
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 */
	public boolean adicionaMusica(Musica musica) {
		if (!this.minhasMusicas.contains(musica)) {
			return this.minhasMusicas.add(musica);
		}
		return false;
	}

	/**
	 * Retorna o tamanho da playlist do usuário.
	 * @return Um inteiro indicando a quantidade de músicas que a playlist possui.
	 */
	public int getTamanho() {
		return this.minhasMusicas.size();
	}

	/**
	 * Verifica se uma playlist possui uma música.
	 * @param nomeMusica
	 * @return "true", caso afirmativo; "false", caso contrário.
	 */
	public boolean contemMusica(String nomeMusica) {
		for (Musica musica : this.minhasMusicas) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) {
				return true;
			}
		}
		return false;
	}

}
