package sp2fy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Abstração de uma musiteca no sistema "sp2fy".
 * @author Christopher
 */
public class Musiteca {

	private HashSet<Album> albuns;
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, Playlist> playlists;

	/**
	 * Construtor da classe "Musiteca".
	 */
	public Musiteca() {

		this.albuns = new HashSet<Album>();
		this.albunsFavoritos = new HashSet<Album>();
		this.playlists = new HashMap<String, Playlist>();
	}

	/**
	 * Adiciona um álbum à coleção de álbuns na musiteca.
	 * 
	 * @param album
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 */
	public boolean adicionaAlbum(Album album) {
		if (album != null) {
			return this.albuns.add(album);
		}

		return false;
	}

	/**
	 * Remove um álbum da coleção de álbuns que a musiteca possui.
	 * 
	 * @param album
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 */
	public boolean removeAlbum(Album album) {
		if (album != null && this.albuns.contains(album)) {
			return this.albuns.remove(album);
		}

		return false;
	}

	/**
	 * Verifica se um álbum está na coleção de álbuns da musiteca.
	 * 
	 * @param album
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 */
	public boolean contemAlbum(Album album) {
		if (album != null) {
			return this.albuns.contains(album);
		}
		return false;
	}

	/**
	 * Adiciona um álbum à coleção de "albúns favoritos", se, e somente se, o álbum já estiver na coleção de álbuns.
	 * @param albumFavorito
	 * @return "true", caso afirmativo; "false", caso contrário.
	 */
	public boolean adicionaAosFavoritos(Album albumFavorito) {
		if (albumFavorito != null && this.albuns.contains(albumFavorito)) {
			return this.albunsFavoritos.add(albumFavorito);
		}
		return false;
	}

	/**
	 * Remove um álbum dos "álbuns favoritos".
	 * @param albumFavorito
	 * @return "true", caso o álbum tenha sido removido com sucesso; "false", caso contrário.
	 */
	public boolean removeDosFavoritos(Album albumFavorito) {
		if (albumFavorito != null && this.albuns.contains(albumFavorito)) {
			return this.albunsFavoritos.remove(albumFavorito);
		}
		return false;

	}

	/**
	 * Retorna a quantidade de ábuns favoritos da musiteca.
	 * @return um inteiro, que é a quantidade de álbuns favoritos da musiteca.
	 */
	public int getQuantidadeFavoritos() {
		return this.albunsFavoritos.size();
	}

	/**
	 * Método responsável pela criação de uma playlist na musiteca.
	 * @param nomePlaylist
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 * @throws Exception
	 */
	public boolean criaPlaylist(String nomePlaylist) throws Exception {
		if (!(nomePlaylist == null || nomePlaylist.trim().isEmpty()) && !this.playlists.containsKey(nomePlaylist)) {
			Playlist play = new Playlist(nomePlaylist);
			this.playlists.put(nomePlaylist, play);
			return true;
		}

		return false;
	}

	/**
	 * Verifica se a musiteca contém uma playlist.
	 * @param nomePlaylist
	 * @return "true", em caso afirmativo; "false", caso contrário.
	 */
	public boolean contemPlaylist(String nomePlaylist) {
		if (nomePlaylist != null && this.playlists.containsKey(nomePlaylist)) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se uma faixa de um álbum, possui uma música.
	 * @param nomeAlbum
	 * @param faixa
	 * @return "true", caso afirmativo; "false", caso contrário.
	 */
	public Musica verificaFaixaNoAlbum(String nomeAlbum, int faixa) {

		for (Album album : this.albuns) {
			if (album.getTitulo().equalsIgnoreCase(nomeAlbum)) {
				return album.getMusicaPorFaixa(faixa);
			}
		}
		return null;
	}

	/**
	 * Adiciona uma faixa à playlist da musiteca.
	 * @param nomePlaylist
	 * @param nomeAlbum
	 * @param faixaAlbum
	 * @return "true", em caso de sucesso; "false", caso contrário.
	 */
	public boolean adicionaNaPlaylist(String nomePlaylist, String nomeAlbum, int faixaAlbum) {
		Musica musicaProcurada = verificaFaixaNoAlbum(nomeAlbum, faixaAlbum);

		if (musicaProcurada != null) {
			Playlist playlist = this.playlists.get(nomePlaylist);
			return playlist.adicionaMusica(musicaProcurada);
		}
		return false;
	}

	/**
	 * Método responsável por indicar o tamanho da playlist.
	 * @param nomePlaylist
	 * @return Um inteiro, que expressa a quantidade de músicas na playlist.
	 */
	public int getTamanhoPlaylist(String nomePlaylist) {
		Playlist playlist = this.playlists.get(nomePlaylist);
		return playlist.getTamanho();

	}

	/**
	 * Verifica se a playlist possui uma música passada como parâmetro.
	 * @param nomePlaylist
	 * @param nomeMusica
	 * @return "true", em caso afirmativo; "false", caso contrário.
	 */
	public boolean contemNaPlaylist(String nomePlaylist, String nomeMusica) {

		Playlist play = this.playlists.get(nomePlaylist);
		if (play != null) {
			return play.contemMusica(nomeMusica);
		}
		return false;
	}

}
