package excecoes;

/**
 * Classe que retorna uma mensagem de erro. Herda de Exception.
 * @author Christopher
 *
 */
public class CreditoInvalidoException extends ValorInvalidoException{
	
	/**
	 * Comportamento que exibe uma mensagem de erro quando o credito de um Usuario eh invalido.
	 */
	private static final long serialVersionUID = 1L;

	public CreditoInvalidoException(String mensagem) {
		super(mensagem);
		
	}

}
