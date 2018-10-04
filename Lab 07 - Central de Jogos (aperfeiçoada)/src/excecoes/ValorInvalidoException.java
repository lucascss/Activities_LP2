package excecoes;
/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class ValorInvalidoException extends PrecoInvalidoException {

	/**
	 * Comportamento que exibe uma mensagem de erro quando um valor qualquer eh invalido.
	 */
	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(String mensagem) {
		super(mensagem);
	}

}
