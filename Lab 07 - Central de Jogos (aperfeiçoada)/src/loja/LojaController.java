package loja;

import java.util.HashMap;
import java.util.HashSet;

import excecoes.BuscaInvalidaException;
import excecoes.MudancaInvalidaException;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.TrocaInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.FactoryJogo;
import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.Usuario;
/**
 * O controller eh q ponte entre a Facade e o "obscuro" do codigo, no qual o cliente nao necessariamente
 * tem interesse em conhecer. Ele oculta do cliente as informacaoes.
 * @author Christopher
 *
 */
public class LojaController {

	private HashMap<String, Usuario> meusUsuarios;
	private FactoryJogo fabricaJogos;

	/**
	 * Construtor da LojaController.
	 */
	public LojaController() {
		this.meusUsuarios = new HashMap<>();
		this.fabricaJogos = new FactoryJogo();
	}

	/**
	 * Metodo que cria um Usuario.
	 * @param nomeUsuario
	 * @param loginUsuario
	 * @throws StringInvalidaException
	 */
	public void criaUsuario(String nomeUsuario, String loginUsuario) throws StringInvalidaException {
		Usuario usuario = new Usuario(nomeUsuario, loginUsuario);
		meusUsuarios.put(loginUsuario, usuario);
	}
	/**
	 * Metodo que adiciona um usuario num mapa de Usuarios, tendo como par chave(login do Usuario) -> valor(Usuario).
	 * @param nomeUsuario
	 * @param loginUsuario
	 * @throws StringInvalidaException
	 */
	public void adicionaUsuario(String nomeUsuario, String loginUsuario) throws StringInvalidaException{
		Usuario usuario = new Usuario(nomeUsuario, loginUsuario);
		this.meusUsuarios.put(loginUsuario, usuario);
		
	}
	/**
	 * Metodo que procura um Usuario no mapa de Usuarios.
	 * @param login
	 * @return
	 * @throws BuscaInvalidaException
	 */
	public Usuario buscaUsuario(String login) throws BuscaInvalidaException {
		if (this.meusUsuarios.containsKey(login)) {
			return meusUsuarios.get(login);
		}
		throw new BuscaInvalidaException("Usuario nao encontrado.");
	}
	/**
	 * Comportamento que adiciona creditos a um Usuario.
	 * @param login
	 * @param credito
	 * @throws BuscaInvalidaException
	 * @throws ValorInvalidoException
	 */
	public void adicionaCredito(String login, double credito) throws BuscaInvalidaException, ValorInvalidoException {
		Usuario usuario = this.buscaUsuario(login);
		usuario.setCredito(usuario.getCredito() + credito);
	}
	/**
	 * Metodo que verifica os creditos de um Usuario.
	 * @param login
	 * @return
	 * @throws BuscaInvalidaException
	 */
	public double confereCredito(String login) throws BuscaInvalidaException {
		Usuario procurado = buscaUsuario(login);
		return procurado.getCredito();
	}
	/**
	 * Comportamento que vende um Jogo a um Usuario.
	 * @param nomeJogo
	 * @param precoJogo
	 * @param jogabilidades
	 * @param estiloJogo
	 * @param loginUsuario
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 * @throws ValorInvalidoException
	 * @throws BuscaInvalidaException
	 */
	public void vendeJogo(String nomeJogo, double precoJogo, String jogabilidades, String estiloJogo, String loginUsuario)
			throws StringInvalidaException, PrecoInvalidoException, ValorInvalidoException, BuscaInvalidaException {

		Jogo jogo = this.fabricaJogos.criaJogo(nomeJogo, precoJogo, jogabilidades, estiloJogo);
		
		Usuario procurado = this.buscaUsuario(loginUsuario);
		procurado.compraJogo(jogo);
	}
	/**
	 * Este metodo "upa" um Usuario do tipo Noob para Veterano.
	 * @param login
	 * @throws BuscaInvalidaException
	 * @throws TrocaInvalidaException
	 * @throws MudancaInvalidaException
	 */
	public void upgrade(String login) throws BuscaInvalidaException, TrocaInvalidaException, MudancaInvalidaException {
		Usuario antigo = buscaUsuario(login);
		antigo.upgrade();
	}
	/**
	 * Comportamento que rebaixa um Usuario do tipo Veterano para Noob.
	 * @param login
	 * @throws BuscaInvalidaException
	 * @throws TrocaInvalidaException
	 * @throws MudancaInvalidaException
	 */
	public void downgrade(String login) throws BuscaInvalidaException, TrocaInvalidaException, MudancaInvalidaException {
		Usuario antigo = buscaUsuario(login);
		antigo.downgrade();
	}
	/**
	 * Comportamento que retorna informacoes do Usuario.
	 * @return
	 */
	public String informacaoUsuarios() {
		final String FIM_DE_LINHA = System.lineSeparator();
		float totalPreco = 0;
		String string = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (int i = 0; i < meusUsuarios.size(); i++) {
			string += meusUsuarios.get(i).toString() + FIM_DE_LINHA;
			totalPreco += meusUsuarios.get(i).calculaPrecoTotal();
		}
		string += String.format("\nTotal de preco dos jogos: R$ %.2f\n\n--------------------------------------------",
				totalPreco);
		return string;
	}
	/**
	 * Comportamento que retorna um Inteiro da quantidade de x2p do Usuario.
	 * @param login
	 * @return
	 * @throws BuscaInvalidaException
	 */
	public int getX2p(String login) throws BuscaInvalidaException {
		Usuario procurado = this.buscaUsuario(login);
		return procurado.getXp2();
	}
	/**
	 * Metodo que pune um Usuario em x2p.
	 * @param login
	 * @param nome
	 * @param score
	 * @param zerou
	 * @throws BuscaInvalidaException
	 * @throws ValorInvalidoException
	 */
	// CHAMADA POLIMORFICA
	public void punir(String login, String nome, int score, boolean zerou)
			throws BuscaInvalidaException, ValorInvalidoException {
		Usuario usuario = buscaUsuario(login);
		usuario.punir(nome, score, zerou);
	}
	/**
	 * Metodo que recompensa um Usuarioem x2p.
	 * @param login
	 * @param nome
	 * @param score
	 * @param zerou
	 * @throws ValorInvalidoException
	 * @throws BuscaInvalidaException
	 */
	// CHAMADA POLIMORFICA
	public void recompensar(String login, String nome, int score, boolean zerou)
			throws ValorInvalidoException, BuscaInvalidaException {
		Usuario usuario = buscaUsuario(login);
		usuario.recompensar(nome, score, zerou);
	}

}
