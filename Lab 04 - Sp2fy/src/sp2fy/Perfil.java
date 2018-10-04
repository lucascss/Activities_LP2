package sp2fy;

/**
 * Classe que implementa a abstração de um perfil de usuário do sistema de músicas.
 * @author Christopher
 */
public class Perfil {

	private String nomeUsuario;
	private Musiteca musitecaPropria;

	/**
	 * Construtor da classe "Perfil".
	 * @param nome
	 */
	public Perfil(String nome) {

		this.nomeUsuario = nome;
		this.musitecaPropria = new Musiteca();

	}
	
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	/**
	 * Adiciona um álbum à musiteca do usuário.
	 * @param album
	 * @return "true", caso a musiteca tenha sido adicionada com sucesso; "false", caso contrário.
	 */
	public boolean adicionaAlbum(Album album) {
		try {
			return this.musitecaPropria.adicionaAlbum(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Adiciona um álbum aos álbuns favoritos da musiteca.
	 * @param albumFavorito
	 * @return "true", caso o álbum tenha sido adicionado com sucesso; "false", caso contrário.
	 */
	public boolean adicionaAosFavoritos(Album albumFavorito) {
		try {
			return this.musitecaPropria.adicionaAosFavoritos(albumFavorito);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Remove um álbum da musiteca do usuário.
	 * @param album
	 * @return "true", caso o álbum tenha sido removido com sucesso; "false", caso contrário.
	 */
	public boolean removeAlbum(Album album) {
		try {
			return this.musitecaPropria.removeAlbum(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Remove um álbum dos álbuns favoritos que a musiteca possui.
	 * @param album
	 * @return "true", caso o álbum tenha sido removido com sucesso; "false", caso contrário.
	 */
	public boolean removeDosFavoritos(Album album) {
		try {
			return this.musitecaPropria.removeDosFavoritos(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Verifica se a musiteca possui um álbum. 
	 * @param album
	 * @return "true", caso afirmativo; "false", caso contrário.
	 */
	public boolean procuraAlbum(Album album) {
		try {
			return this.musitecaPropria.contemAlbum(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Cria uma playlist na musiteca do usuário.
	 * @param nomePlaylist
	 * @return "true", caso afirmativo; "false", caso contrário.
	 * @throws Exception
	 */
	public boolean criaPlaylist(String nomePlaylist) throws Exception {
		return this.musitecaPropria.criaPlaylist(nomePlaylist);
	}

}
