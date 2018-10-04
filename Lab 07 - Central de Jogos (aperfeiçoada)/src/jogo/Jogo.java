package jogo;

import java.util.HashSet;
import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;

/**
 * A classe Jogo representa um Jogo no mundo real, um game. Ela encompora e dah origem as subclasses:
 * Luta, Plataforma e RPG. Cada jogo possui um conjunto de jogabilidade, o que permite que cada jogo
 * possua mais de um tipo de "classificacao", como por exemplo, online e moba.
 * Tal classe eh abstrata por possuir metodos nos quais nao utilizaremos seu comportamento na classe
 * em si e, desta maneira, referimo-nos aos comportamentos abstratos, nos quais estes sao sobrescritos
 * nas subclasses com um tipo de comportamento diferente em cada subclasse.
 * @author Christopher
 *
 */
public abstract class Jogo {

	public final String FIM_DE_LINHA;

	private String nome;
	private double preco;
	private int vezesJogadas;
	private int vezesConcluidas;
	private int maiorScore;
	private Set<Jogabilidade> jogabilidades;

	/**
	 * Construtor: Inicia-se um objeto Jogo com os seguintes estados abaixo. Note que este metodo
	 * lanca exceptions.
	 * @param nome
	 * @param preco
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("O nome do jogo nao pode ser nulo ou vazio.");
		}
		if (preco <= 0) {
			throw new PrecoInvalidoException("O preco do jogo nao pode ser nulo ou negativo.");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		this.jogabilidades = new HashSet<Jogabilidade>();
		this.FIM_DE_LINHA = System.lineSeparator();
	}

	/**
	 * Tambem um construtor de Jogo. Porem, este construtor de Jogo recebe como parametro
	 * um conjunto de jogabilidades. Note que, este comportamento tambem lanca exceptions.
	 * @param nome
	 * @param preco
	 * @param jogabilidades
	 * @throws StringInvalidaException
	 * @throws PrecoInvalidoException
	 */
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {

		this(nome, preco);
		this.jogabilidades = jogabilidades;

	}

	/**
	 * Este comportamento registra uma jogada, uma vez que um jogo eh jogado. Eh abstrato devido
	 * a sua funcionalidade ser diferente em cada subclasse de Jogo. Neste metodo, veremos que
	 * podemos calcular bonus para o usuario por jogadas. 
	 * @param score
	 * @param venceu
	 * @return
	 * @throws ValorInvalidoException
	 */
	public abstract int registraJogada(int score, boolean venceu) throws ValorInvalidoException;

	/**
	 * Este metodo retorna uma String do nome do Jogo.
	 * @return
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Este metodo retorna um Inteiro de maior score obtido de um Jogo.
	 * @return
	 */
	public int getMaiorScore() {
		return this.maiorScore;
	}

	/**
	 * Metodo que altera o maior score de um Jogo.
	 * @param novoScore
	 * @throws ValorInvalidoException
	 */
	public void setMaiorScore(int novoScore) throws ValorInvalidoException {
		if (novoScore < 0) {
			throw new ValorInvalidoException("Novo score não pode ser menor que zero.");
		}
		this.maiorScore = novoScore;
	}

	/**
	 * Comportamento que retorna a quantidade de vezes que um Jogo foi concluido.
	 * @return
	 */
	public int getvezesConcluidas() {
		return this.vezesConcluidas;
	}

	/**
	 * Comportamento que modifica a quantidade de vezes que um Jogo foi concluido.
	 * @param novaQuantidade
	 * @throws ValorInvalidoException
	 */
	public void setVezesConcluidas(int novaQuantidade) throws ValorInvalidoException {
		if (novaQuantidade < 0) {
			throw new ValorInvalidoException("A quantidade de jogadas nao pode ser menor que zero.");
		}
		this.vezesConcluidas = novaQuantidade;
	}
	/**
	 * Comportamento que retorna a quantidade de vezes qe um Jogo foi jogado.
	 * @return
	 */
	public int getVezesJogadas() {
		return this.vezesJogadas;
	}
	/**
	 * Metodo que altera a quantidade de vezes que um Jogo foi jogado.
	 * @param novaQuantidade
	 * @throws ValorInvalidoException
	 */
	public void setVezesJogadas(int novaQuantidade) throws ValorInvalidoException {
		if (novaQuantidade < 0) {
			throw new ValorInvalidoException("A quantidade de conclusoes nao pode ser menor que zero.");
		}
		this.vezesJogadas = novaQuantidade;
	}
	/**
	 * Este comportamento retorna um conjunto de jogabilidades.
	 * @return
	 */
	public Set<Jogabilidade> getJogabilidade() {
		return this.jogabilidades;
	}
	/**
	 * Este comportamento modifica um conjunto de jogabilidades.
	 * @param jogabilidades
	 */
	public void setJogabilidades(Set<Jogabilidade> jogabilidades) {
		this.jogabilidades = jogabilidades;
	}
	/**
	 * Este metodo retorna um Double do preco do Jogo.
	 * @return
	 */
	public double getPreco() {
		return this.preco;
	}
	/**
	 * Metodo que apenas incrementa "um" na quantidade de vezes que um Jogo foi jogado.
	 */
	public void incrementaJogada(){
		this.vezesJogadas ++;
	}
	/**
	 * Metodo que apenas incrementa "um" na quantidade de vezes que um Jogo foi concluido.
	 */
	public void incrementaConclusao(){
		this.vezesConcluidas ++;
	}
	/**
	 * Representacao de String de um Jogo.
	 */
	@Override
	public String toString() {
		String resultado = "==> Jogou " + getVezesJogadas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Zerou " + getvezesConcluidas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Maior Score: " + getMaiorScore() + FIM_DE_LINHA;
		return resultado;
	}

	/**
	 * Este comportamento eh a representacao de um "ID" do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Este comportamento compara se dois objetos sao iguais; no caso em questao, se dois 
	 * jogos sao iguais.
	 */
	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Jogo) {
			Jogo novoJogo = (Jogo) objeto;
			return this.getNome().equals(novoJogo.getNome())
					&& this.getPreco() == novoJogo.getPreco();
		} else {
			return false;
		}
	}

}
