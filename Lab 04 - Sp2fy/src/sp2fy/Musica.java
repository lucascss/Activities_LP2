package sp2fy;

/**
 * Classe que representa a abstração de uma música no sistema "sp2fy".
 * @author Christopher
 */
public class Musica {

	private String titulo;
	private int duracao;
	private String genero;

	/**
	 * Construtor da classe "Musica".
	 * @param nomeMusica
	 * @param duracaoMusica
	 * @param generoMusica
	 * @throws Exception
	 */
	public Musica(String nomeMusica, int duracaoMusica, String generoMusica) throws Exception {
		
		if (nomeMusica == null || nomeMusica.equals("")) {
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		if (duracaoMusica <= 0) {
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		if (generoMusica == null || generoMusica.equals("")) {
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}

		this.titulo = nomeMusica;
		this.duracao = duracaoMusica;
		this.genero = generoMusica;

	}

	public boolean equals(Object outroObjeto) {
		
		if (outroObjeto instanceof Musica) {
			Musica musica = (Musica) outroObjeto;
			if (titulo.equals(musica.getTitulo()) && duracao == musica.getDuracao()) 
				return true;
		}
		return false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String toString() {
		return String.format("%s (%s - %d minutos)", this.getTitulo(), this.getGenero(), this.getDuracao());
	}

}
