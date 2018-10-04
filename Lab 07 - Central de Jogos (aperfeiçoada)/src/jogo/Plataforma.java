package jogo;

import java.util.HashSet;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;

/**
 * Esta eh uma subclasse do tipo Jogo que representa um Jogo do tipo Plataforma.
 * @author Christopher
 *
 */
public class Plataforma extends Jogo {
	
	public final int BONUS_POR_ZERACAO;
	public final int BONUS_NULO;
	public final int MAXIMO_SCORE;
	/**
	 * Construtor: Inicia-se um objeto RPG de acordou com os atributos da superclasse.
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Plataforma(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
		this.BONUS_POR_ZERACAO = 20;
		this.BONUS_NULO = 0;
		this.MAXIMO_SCORE = 100000;

	}

	/**
	 * Tambem um construtor, porem, este alem de receber um nome e um preco de um Jogo,
	 *  recebe um conjunto de jogabilidades como paramentro.
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Plataforma(String nome, double preco, HashSet<Jogabilidade> jogabilidades)
			throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
		this.BONUS_POR_ZERACAO = 20;
		this.BONUS_NULO = 0;
		this.MAXIMO_SCORE = 100000;

	}

	/**
	 * Metodo que registra jogada de um Jogo e incrementa a quantidade de vezes que jogou e/ou
	 * zerou um jogo.
	 */
	@Override
	public int registraJogada(int score, boolean venceu) throws ValorInvalidoException {
		
		this.incrementaJogada();
		if (score > this.getMaiorScore() /*&& score <= this.MAXIMO_SCORE*/) {
			this.setMaiorScore(score);
		}
		else if (score > this.MAXIMO_SCORE) {
			this.setMaiorScore(this.MAXIMO_SCORE);
		}
		
		if (venceu) {
			this.incrementaConclusao();
			return this.BONUS_POR_ZERACAO;
		}
		return BONUS_NULO;
		/*int bonus = this.getvezesConcluidas() * this.BONUS_POR_ZERACAO;
		return bonus;*/
	}
	/**
	 * Este comportamento eh a representacao do objeto da superclasse Jogo.
	 */
	public String toString() {
		
		String resultado = "+ " + getNome() + " - Plataforma:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
