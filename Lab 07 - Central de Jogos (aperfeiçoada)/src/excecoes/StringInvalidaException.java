package excecoes;
/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class StringInvalidaException extends Exception {

	/**
	 * Comportamento que exibe uma mensagem de erro quando um nome de substantivo eh invalido.
	 */
	private static final long serialVersionUID = 1L;

	public StringInvalidaException(String mensagem) {
		super(mensagem);
	}

}
