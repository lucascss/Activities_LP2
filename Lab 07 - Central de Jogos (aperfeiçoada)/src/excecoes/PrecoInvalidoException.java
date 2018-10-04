package excecoes;

/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class PrecoInvalidoException extends Exception {

	/**
	 * Metodo que expoe uma mensagem de erro quando o preco de um Jogo eh invalido.
	 */
	private static final long serialVersionUID = 1L;

	public PrecoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
