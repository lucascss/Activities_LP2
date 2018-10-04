package usuario;

import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;

/**
 * Esta eh uma subclasse do tipo Usuario. Um Noob eh um Usuario menos experiente, um iniciante.
 * Possui os mesmo membros de sua superclasse e implementa uma Interface TipoDeUsuarioIF.
 * @author Christopher
 *
 */
public class Noob implements TipoDeUsuarioIF {
	private final double DESCONTO_NOOB;
	private final int VALOR_XP2;
	private final int PONTOS_JOGO_COMPETITIVO;
	private final int PONTOS_JOGO_OFFLINE;
	private final int PONTOS_JOGO_ONLINE;
	private final int PONTOS_JOGO_COOPERATIVO;
	private final int PONTOS_JOGO_MULTIPLAYER;

	/**
	 * Como Noob eh uma classe que implementa uma Interface e essa Interface compoe um Usuario, podemos definir
	 * um Noob com um construtor "default", ou seja, "vazio". Abaixo, apenas constantes que evitam numeros magicos.
	 */
	public Noob(){
		this.DESCONTO_NOOB = 0.10;
		this.VALOR_XP2 = 10;
		this.PONTOS_JOGO_ONLINE = 10;
		this.PONTOS_JOGO_COMPETITIVO = 20;
		this.PONTOS_JOGO_COOPERATIVO = 50;
		this.PONTOS_JOGO_OFFLINE = 30;
		this.PONTOS_JOGO_MULTIPLAYER = 10;
	}

	/**
	 * Metodo para efetuar a comprar de jogos, no qual eh sobrescrito da superclasse.
	 */
	@Override
	public double compraJogo(Jogo jogo) throws ValorInvalidoException {
		double desconto = jogo.getPreco() - (jogo.getPreco() * this.DESCONTO_NOOB);
		return desconto;
	}

	/**
	 * Este comportamento retorna um Interiro da quantidade ganha de x2p a partir do preco de um Jogo.
	 */
	public int getX2p(Jogo jogo) {
		return (int) (jogo.getPreco() * this.VALOR_XP2);
	}

	/**
	 * Comportamento que bonifica o x2p de um usuario de acordo com o tipo de Jogabilidade
	 * do jogo que o Usuario Noob joga.
	 */
	public int recompensar(Jogo jogo) {
		int totalRecompensa = 0;
		if (jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)) {
			totalRecompensa += this.PONTOS_JOGO_OFFLINE;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.MULTIPLAYER)) {
			totalRecompensa += this.PONTOS_JOGO_MULTIPLAYER;
		}
		return totalRecompensa;

	}

	/**
	 * Comportamento que retira x2p de um usuario de acordo com o tipo de Jogabilidade
	 * do jogo que o Usuario Noob joga.
	 */
	@Override
	public int punir(Jogo jogo) {
		int totalRecompensa = 0;
		if (jogo.getJogabilidade().contains(Jogabilidade.ONLINE)) {
			totalRecompensa += this.PONTOS_JOGO_ONLINE;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)) {
			totalRecompensa += this.PONTOS_JOGO_COOPERATIVO;
		}
		if (jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)) {
			totalRecompensa += this.PONTOS_JOGO_COMPETITIVO;
		}
		return totalRecompensa;
	}

	/**
	 * Representacao de um Usuario Noob em String.
	 */
	public String toString() {
		String myString = "Jogador Noob: ";
		return myString;
	}

}