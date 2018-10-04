package usuario;

import excecoes.ValorInvalidoException;
import jogo.Jogabilidade;
import jogo.Jogo;
/**
 * Esta eh uma subclasse do tipo Usuario. Um Veterano eh um Usuario mais experiente, um usuario
 * com bom tempo de "pratica". Possui os mesmo membros de sua superclasse e implementa uma Interface TipoDeUsuarioIF.
 * @author Christopher
 *
 */
public class Veterano implements TipoDeUsuarioIF{
	private final double DESCONTO_VETERANO;
	private final int VALOR_XP2;
	private final int PONTOS_JOGO_COMPETITIVO;
	private final int PONTOS_JOGO_OFFLINE;
	private final int PONTOS_JOGO_ONLINE;
	private final int PONTOS_JOGO_COOPERATIVO;
	
	/**
	 * Como Veterano eh uma classe que implementa uma Interface e essa Interface compoe um Usuario, podemos definir
	 * um Veterano com um construtor "default", ou seja, "vazio". Abaixo, apenas constantes que evitam numeros magicos.
	 */
	public Veterano(){
		this.DESCONTO_VETERANO = 0.20;
		this.VALOR_XP2 = 15;
		this.PONTOS_JOGO_COMPETITIVO = 20;
		this.PONTOS_JOGO_OFFLINE = 20;
		this.PONTOS_JOGO_ONLINE = 10;
		this.PONTOS_JOGO_COOPERATIVO = 20;
	}
	
	/**
	 * Metodo para efetuar a comprar de jogos, no qual eh sobrescrito da superclasse.
	 */
	public double compraJogo(Jogo jogo) throws ValorInvalidoException {
		double desconto = jogo.getPreco() - (jogo.getPreco() * DESCONTO_VETERANO);
		return desconto;
	}
	/**
	 * Este comportamento retorna um Interiro da quantidade ganha de x2p a partir do preco de um Jogo.
	 */
	public int getX2p(Jogo jogo){
		return (int) (jogo.getPreco() * VALOR_XP2);
	}

	/**
	 * Comportamento que bonifica o x2p de um usuario de acordo com o tipo de Jogabilidade
	 * do jogo que o Usuario Veterano joga.
	 */
	@Override
	public int recompensar(Jogo jogo) {
		int totalRecompensa = 0;
		if(jogo.getJogabilidade().contains(Jogabilidade.ONLINE)){
			totalRecompensa += this.PONTOS_JOGO_ONLINE;
		}
		if(jogo.getJogabilidade().contains(Jogabilidade.COOPERATIVO)){
			totalRecompensa += this.PONTOS_JOGO_COOPERATIVO;
		}
		return totalRecompensa;
	}

	/**
	 * Comportamento que retira x2p de um usuario de acordo com o tipo de Jogabilidade
	 * do jogo que o Usuario Veterano joga.
	 */
	@Override
	public int punir(Jogo jogo) {
		int totalRecompensa = 0;
		if(jogo.getJogabilidade().contains(Jogabilidade.OFFLINE)){
			totalRecompensa += this.PONTOS_JOGO_OFFLINE;
		}
		if(jogo.getJogabilidade().contains(Jogabilidade.COMPETITIVO)){
				totalRecompensa += this.PONTOS_JOGO_COMPETITIVO;
		}
		return totalRecompensa;
		
	}

	/**
	 * Representacao de um Usuario Noob em String.
	 */
	public String toString() {
		String myString = "Jogador Veterano: ";
		return myString;
	}
	
}
