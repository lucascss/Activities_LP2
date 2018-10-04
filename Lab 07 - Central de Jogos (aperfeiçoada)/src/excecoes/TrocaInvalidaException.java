package excecoes;
/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class TrocaInvalidaException extends Exception {
	
	/**
	 * Comportamento que exibe uma mensagem de erro quando a troca eh invalido.
	 */
	private static final long serialVersionUID = 1L;

	public TrocaInvalidaException(String mensagem) {
		super(mensagem);
	}

}
