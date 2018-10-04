package usuarios;

import java.util.HashSet;

import jogos.Jogo;

/**
 * A classe Usuario representa um Usuario no mundo real. Um usuario de uma loja,
 * possui um nome, um login de acesso a loja e uma colecao de Jogos. Cada
 * Usuario pode efeturar depositos em sua conta, comprar jogos e registrar
 * jogadas. A classe Usuario eh abstrata, devido suas subclasses possuirem
 * padroes de construcao e calculo semelhantes, mas nao iguais. Assim, se nao o
 * fosse abstrata, nao teria utilidade alguma.
 * 
 * @author lucascss
 *
 */
public abstract class Usuario {

	protected String nome;
	protected String username;
	protected HashSet<Jogo> meusJogos;
	protected double dinheiro;
	protected int x2p;

	/**
	 * Construtor: Inicia-se um objeto Usuario de acordou com os atributos
	 * abaixo, podendo lancar exceptions:
	 * 
	 * @param nomeUsuario
	 * @param username
	 * @throws Exception
	 */
	public Usuario(String nomeUsuario, String username) throws Exception {

		if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
			throw new Exception("O nome do usuario nao pode ser nulo ou vazio.");
		}
		if (username == null || username.trim().isEmpty()) {
			throw new Exception("O login do usuario nao pode ser nulo ou vazio.");
		}

		this.meusJogos = new HashSet<>();
		this.nome = nomeUsuario;
		this.username = username;
		this.dinheiro = 0;
		this.x2p = 0;

	}

	/**
	 * Este metodo permite que o usuario deposite mais dinheiro em sua conta.
	 * 
	 * @param dinheiro
	 */
	public void depositaDinheiro(double dinheiro) {
		double novaQuantia = this.dinheiro + dinheiro;
		this.setDinheiro(novaQuantia);
	}

	/**
	 * Metodo abstrato de comprar jogos, no qual eh sobrescrevido pelas
	 * subclasses.
	 * 
	 * @param nomeJogo
	 * @param precoJogo
	 * @param tipoJogo
	 * @return
	 * @throws Exception
	 */
	public abstract boolean compraJogos(String nomeJogo, double precoJogo, String tipoJogo) throws Exception;

	/**
	 * Metodo abstrato de registrar jogadas, no qual eh sobrescrevido pelas
	 * subclasses.
	 * 
	 * @param nomeDoJogo
	 * @param score
	 * @param zerou
	 * @return
	 */
	public abstract boolean registraJogada(String nomeDoJogo, int score, boolean zerou);

	/**
	 * Este metodo retorna um nome, que no caso, o nome do Usuario.
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Este comportamento apenas modifica um nome, no caso, do Jogo.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Este comportamento retorna o login, no caso, do Usuario.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Este comportamento apenas modifica o login do Usuario.
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Este comportamento retorna a quantia de dinheiro que o Usuario tem em sua
	 * conta.
	 * 
	 * @return
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * Este comportamento unicamente modifica a quantia de dinheiro que o
	 * Usuario tem em sua conta.
	 * 
	 * @param dinheiro
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	/**
	 * Este comportamento retorna a quantia de x2p do Usuario.
	 * 
	 * @return
	 */
	public int getX2p() {
		return x2p;
	}

	/**
	 * Este comportamento modifica a quantia de x2p do Usuario.
	 * 
	 * @param x2p
	 */
	public void setX2p(int x2p) {
		this.x2p += x2p;
	}

	/**
	 * Este comportamento retorna a colecao de Jogos do Usuario.
	 * 
	 * @return
	 */
	public HashSet<Jogo> getMeusJogos() {
		return meusJogos;
	}

	/**
	 * Este comportamento modifica a colecao de Jogos do Usuario.
	 * 
	 * @param meusJogos
	 */
	public void setMeusJogos(HashSet<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}

	/**
	 * Este comportamento eh a representacao do objeto da superclasse Usuario.
	 */
	@Override
	public String toString() {

		final String FIM_DE_LINHA = System.lineSeparator();

		double precoTotal = 0;

		String mensagem = this.getUsername() + FIM_DE_LINHA + this.getNome() + FIM_DE_LINHA + " - Jogador Noob";
		for (Jogo jogo : this.meusJogos) {
			mensagem += jogo.toString();
			precoTotal += jogo.getPreco();
		}

		mensagem += "Total de preco dos jogos: R$ %n" + precoTotal + FIM_DE_LINHA
				+ "--------------------------------------------";

		return mensagem;
	}

	/**
	 * Este comportamento eh a representacao de um "ID" do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * Este comportamento compara se dois objetos sao iguais; no caso em
	 * questao, se dois Usuarios sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
