package usuario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import excecoes.BuscaInvalidaException;
import excecoes.CreditoInvalidoException;
import excecoes.MudancaInvalidaException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogo;
/**
 * A classe Usuario representa um Usuario no mundo real. Um usuario de uma loja, possui um nome, um login de acesso
 * a loja e uma colecao de Jogos. Cada Usuario pode efeturar depositos em sua conta, comprar jogos e registrar jogadas.
 * Esta classe implementa uma Interface.
 * @author Christopher
 *
 */
public class Usuario {

	public final String FIM_DE_LINHA;

	private TipoDeUsuarioIF statusDoUsuario;

	private String nome;
	private String login;
	protected Set<Jogo> meusJogos;
	protected double credito;
	protected int xp2;

	/**
	 * Construtor de um Usuario. Todo Usuario comeca do tipo Noob, podendo evoluir para Veterano ou nao.
	 * Cada Usuario possui um nome e um login.
	 * @param nome
	 * @param login
	 * @throws StringInvalidaException
	 */
	public Usuario(String nome, String login) throws StringInvalidaException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("O nome do usuario nao pode ser nulo ou vazio.");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("O login do usuario nao pode ser nulo ou vazio.");
		}

		this.nome = nome;
		this.login = login;
		this.credito = 0;
		this.FIM_DE_LINHA = System.lineSeparator();
		this.meusJogos = new HashSet<Jogo>();
		this.statusDoUsuario = new Noob();

	}

	/**
	 * Metodo para efetuar a comprar de jogos.
	 * @param jogo
	 * @throws ValorInvalidoException
	 */
	// CHAMADA POLIMORFICA
	public void compraJogo(Jogo jogo) throws ValorInvalidoException {

		if (this.getCredito() < jogo.getPreco()) {
			throw new CreditoInvalidoException("Credito insuficiente para realizar a compra.");
		} 
		else {
			this.setCredito(this.getCredito() - statusDoUsuario.compraJogo(jogo));
			meusJogos.add(jogo);
			this.setXp2(this.getXp2() + this.statusDoUsuario.getX2p(jogo));

		}
	}

	/**
	 * Comportamento que procura um Jogo em meio aum conjunto de jogos que o Usuario possui.
	 * @param nomeJogo
	 * @return
	 * @throws BuscaInvalidaException
	 */
	private Jogo buscaJogo(String nomeJogo) throws BuscaInvalidaException {
		for (Jogo jogo : meusJogos) {
			if (jogo.getNome().equalsIgnoreCase(nomeJogo)) {
				return jogo;
			}
		}
		throw new BuscaInvalidaException("O jogo nao foi encontrado.");
	}

	/**
	 * Comportamento que calcula o preco total dos jogos que um Usuario possui, 
	 * percorrendo seu conjunto de jogos.
	 * @return
	 */
	public double calculaPrecoTotal() {
		double total = 0;
		Iterator iterador = meusJogos.iterator();
		while (iterador.hasNext()) {
			Jogo achado = (Jogo) iterador.next();
			total += achado.getPreco();
		}
		return total;
	}

	/**
	 * Metodo que recompensa um Usuario com x2p.
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws BuscaInvalidaException
	 * @throws ValorInvalidoException
	 */
	// CHAMADA POLIMORFICA
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou)
			throws BuscaInvalidaException, ValorInvalidoException {
		Jogo jogo = buscaJogo(nomeJogo);
		int novoX2p = this.getXp2() + jogo.registraJogada(scoreObtido, zerou) + statusDoUsuario.recompensar(jogo);
		this.setXp2(novoX2p);
	}
	/**
	 * Comportamento que pune um Usuario em x2p. 
	 * @param nomeJogo
	 * @param scoreObtido
	 * @param zerou
	 * @throws BuscaInvalidaException
	 * @throws ValorInvalidoException
	 */
	// CHAMADA POLIMORFICA
	public void punir(String nomeJogo, int scoreObtido, boolean zerou)
			throws BuscaInvalidaException, ValorInvalidoException {
		Jogo jogo = buscaJogo(nomeJogo);
		int novoX2p = this.getXp2() - statusDoUsuario.punir(jogo) + jogo.registraJogada(scoreObtido, zerou);
		this.setXp2(novoX2p);
	}
	/**
	 * Comportamento no qual "upa" um Usuario de Noob para Veterano.
	 * @throws MudancaInvalidaException
	 */
	public void upgrade() throws MudancaInvalidaException {
		if (this.getXp2() < 1000) {
			throw new MudancaInvalidaException("Impossivel realizar upgrade, quantidade de x2p insuficiente!");
		}
		if (this.statusDoUsuario.getClass().equals(Veterano.class)) {
			throw new MudancaInvalidaException("Upgrade impossivel de ser realizado, usuario ja eh veterano");
		}
		this.statusDoUsuario = new Veterano();
	}
	/**
	 * Comportamento que rebaixa um Usuario de Veterano para Noob.
	 * @throws MudancaInvalidaException
	 */
	public void downgrade() throws MudancaInvalidaException {
		if (this.statusDoUsuario.getClass().equals(Noob.class)) {
			throw new MudancaInvalidaException("Downgrade impossivel de ser realizado, o usuario ja eh noob");
		}
		this.statusDoUsuario = new Noob();
	}
	/**
	 * Comportamento que retorna uma String do nome do Usuario.
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Metodo que modifica o nome de um Usuario.
	 * @param nome
	 * @throws StringInvalidaException
	 */
	public void setNome(String nome) throws StringInvalidaException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("O novo nome nao pode ser nulo ou vazio.");
		}
		this.nome = nome;
	}
	/**
	 * Comportamento que retorna uma String do login do Usuario.
	 * @return
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Metodo que modifica o lgin de um Usuario.
	 * @param login
	 * @throws StringInvalidaException
	 */
	public void setLogin(String login) throws StringInvalidaException {
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("O novo login nao pode ser nulo ou vazio.");
		}
		this.login = login;
	}
	/**
	 * Comportamento que retorna um Inteiro da quantidade de creditos de um Usuario.
	 * @return
	 */
	public double getCredito() {
		return this.credito;
	}
	/**
	 * Comportamento que altera a quantidade de creditos de um Usuario.
	 * @param novoValor
	 * @throws ValorInvalidoException
	 */
	public void setCredito(double novoValor) throws ValorInvalidoException {
		if (novoValor < 0) {
			throw new ValorInvalidoException("O novo valor nao pode ser menor que zero.");
		}
		this.credito = novoValor;
	}
	/**
	 * Comportamento que retorna um Inteiro da quantidade de x2p de um Usuario.
	 * @return
	 */
	public int getXp2() {
		return this.xp2;
	}
	/**
	 * Comportamento que modifica a quantidade de x2p de um Usuario.
	 * @param novoValor
	 */
	public void setXp2(int novoValor) {
		this.xp2 = novoValor;
	}
	/**
	 * Comportamento que retorna um conjunto de jogos de um Usuario.
	 * @return
	 */
	public Set<Jogo> getMeusJogos() {
		return meusJogos;
	}
	/**
	 * Comportamento que altera um conjunto de jogos de um Usuario.
	 * @param meusJogos
	 */
	public void setMeusJogos(Set<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}
	/**
	 * Comportamento que retorna o status de um Usuario (se ele eh do tipo Noob ou Veterano).
	 * @return
	 */
	public TipoDeUsuarioIF getStatusDoUsuario() {
		return statusDoUsuario;
	}
	/**
	 * Comportamento que altera o status de um Usuario.
	 * @param statusDoUsuario
	 */
	public void setStatusDoUsuario(TipoDeUsuarioIF statusDoUsuario) {
		this.statusDoUsuario = statusDoUsuario;
	}
	/**
	 * Metodo que adiciona um Jogo no conjunto de jogos de um Usuario.
	 * @param jogo
	 */
	public void cadastraJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}
	/**
	 * Representacao de um Usuario em String.
	 */
	// CHAMADA POLIMORFICA
	public String toString(){
		String string = statusDoUsuario.toString() + getLogin() + this.FIM_DE_LINHA;
		string += String.format("%s - %d x2p\n", getNome(), getXp2());
		string += "Lista de Jogos:" + this.FIM_DE_LINHA;
		for(Jogo jogo : meusJogos){
			string += "+ " + jogo.toString() + "\n";
		}
		return string;
	}

	/**
	 * Este comportamento eh a representacao de um "ID" do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	/**
	 * Este comportamento compara se dois objetos sao iguais; no caso em questao, se dois
	 * Usuarios sao iguais. O criterio utilizado nesta analise sao o nome e o login dos Usuarios.
	 */
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Usuario) {
			Usuario novoUsuario = (Usuario) objeto;
			return this.getNome().equals(novoUsuario.getNome()) && this.getLogin().equals(novoUsuario.getLogin());
		} else {
			return false;
		}
	}

}