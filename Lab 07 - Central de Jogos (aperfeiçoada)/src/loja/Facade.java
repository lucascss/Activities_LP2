package loja;

import easyaccept.EasyAccept;
import excecoes.BuscaInvalidaException;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import usuario.Usuario;
import excecoes.TrocaInvalidaException;
/**
 * A Facade eh a porta no qual o Usuario interage, a "interface grafica", o view. Eh onde o Usuario
 * interage com todo o programa, soh recebendo e visualizando o que todo o programa faz em si, sem
 * ver e conhecer os bastidores.
 * @author Christopher
 *
 */
public class Facade {

	private LojaController controle;

	/**
	 * Construtor da Facace.
	 */
	public Facade() {
		this.controle = new LojaController();
	}
	/**
	 * Metodo que cria um Usuario.
	 * @param nome
	 * @param login
	 * @param tipo
	 * @throws Exception
	 * @throws StringInvalidaException
	 */
	public void criaUsuario(String nome, String login, String tipo) throws Exception, StringInvalidaException {
		try {
			controle.criaUsuario(nome, login);
		} catch (StringInvalidaException exception) {
			System.out.println(exception.getMessage());
			throw new StringInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que adiciona um Usuario.
	 * @param nomeUsuario
	 * @param username
	 */
	public void adicionaUsuario(String nomeUsuario, String username) {
		try {
			controle.adicionaUsuario(nomeUsuario, username);
		} catch (StringInvalidaException exception) {
			System.out.println(exception.getMessage());
		}
	}
	/**
	 * Metodo que confere a quantidade de creditos de um Usuario.
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public double confereCredito(String login) throws Exception {
		return controle.confereCredito(login);
	}
	/**
	 * Metodo que vende um Jogo a un Usuario.
	 * @param nomeJogo
	 * @param preco
	 * @param jogabilidades
	 * @param estiloJogo
	 * @param loginUsuario
	 * @throws ValorInvalidoException
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 * @throws BuscaInvalidaException
	 * @throws Exception
	 */
	public void vendeJogo(String nomeJogo, double preco, String jogabilidades, String estiloJogo, String loginUsuario)
			throws ValorInvalidoException, StringInvalidaException, PrecoInvalidoException, BuscaInvalidaException,
			Exception {
		try {
			controle.vendeJogo(nomeJogo, preco, jogabilidades, estiloJogo, loginUsuario);
		} catch (StringInvalidaException exception) {
			throw new StringInvalidaException(exception.getMessage());
		} catch (ValorInvalidoException exception) {
			throw new ValorInvalidoException(exception.getMessage());
		} catch (PrecoInvalidoException exception) {
			throw new PrecoInvalidoException(exception.getMessage());
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}

	}
	/**
	 * Metodo que adiciona creditos a um Usuario.
	 * @param login
	 * @param credito
	 * @throws Exception
	 * @throws ValorInvalidoException
	 * @throws BuscaInvalidaException
	 */
	public void adicionaCredito(String login, double credito)
			throws Exception, ValorInvalidoException, BuscaInvalidaException {
		try {
			controle.adicionaCredito(login, credito);
		} catch (ValorInvalidoException exception) {
			throw new ValorInvalidoException(exception.getMessage());
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que "upa" um Usuario de Noob para Veterano.
	 * @param login
	 * @throws Exception
	 * @throws BuscaInvalidaException
	 * @throws TrocaInvalidaException
	 */
	public void upgrade(String login) throws Exception, BuscaInvalidaException, TrocaInvalidaException {
		try {
			controle.upgrade(login);
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (TrocaInvalidaException exception) {
			throw new TrocaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que rebaixa um Usuario do tipo Veterano para Noob.
	 * @param login
	 * @throws Exception
	 * @throws BuscaInvalidaException
	 * @throws TrocaInvalidaException
	 */
	public void downgrade(String login) throws Exception, BuscaInvalidaException, TrocaInvalidaException {
		try {
			controle.downgrade(login);
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (TrocaInvalidaException exception) {
			throw new TrocaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Comportamento que retorna a quantidade de x2p de um Usuario.
	 * @param login
	 * @return
	 * @throws Exception
	 * @throws BuscaInvalidaException
	 */
	public int getX2p(String login) throws Exception, BuscaInvalidaException {
		try {
			return controle.getX2p(login);
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que pune um Usuario em x2p.
	 * @param login
	 * @param nome
	 * @param score
	 * @param zerou
	 * @throws Exception
	 * @throws ValorInvalidoException
	 * @throws BuscaInvalidaException
	 */
	public void punir(String login, String nome, int score, boolean zerou)
			throws Exception, ValorInvalidoException, BuscaInvalidaException {
		try {
			controle.punir(login, nome, score, zerou);
		} catch (ValorInvalidoException exception) {
			throw new ValorInvalidoException(exception.getMessage());
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que recompensa um Usuario em x2p.
	 * @param login
	 * @param nome
	 * @param score
	 * @param zerou
	 * @throws Exception
	 * @throws ValorInvalidoException
	 * @throws BuscaInvalidaException
	 */
	public void recompensar(String login, String nome, int score, boolean zerou)
			throws Exception, ValorInvalidoException, BuscaInvalidaException {
		try {
			controle.recompensar(login, nome, score, zerou);
		} catch (BuscaInvalidaException exception) {
			throw new BuscaInvalidaException(exception.getMessage());
		} catch (ValorInvalidoException exception) {
			throw new ValorInvalidoException(exception.getMessage());
		} catch (Exception exception) {
			throw new Exception(exception.getMessage());
		}
	}
	/**
	 * Metodo que retorna uma String de informacao de um Usuario.
	 * @return
	 */
	public String informacaoUsuarios() {
		return controle.informacaoUsuarios();
	}
	/**
	 * Metodo que executa os testes de aceitacao.
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] { "loja.Facade", "acceptance_test/us1.txt", "acceptance_test/us2.txt",
				"acceptance_test/us3.txt" };
		System.out.println();
		EasyAccept.main(args);
	}
}
