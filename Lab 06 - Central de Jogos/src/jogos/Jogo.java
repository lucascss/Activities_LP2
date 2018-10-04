package jogos;

import java.util.HashSet;

/**
 * A classe Jogo representa um Jogo no mundo real, um game. Ela encompora e dah
 * origem as subclasses: Luta, Plataforma e RPG. Cada jogo possui um conjunto de
 * jogabilidade, o que permite que cada jogo possua mais de um tipo de
 * "classificacao", como por exemplo, online e moba. Tal classe eh abstrata por
 * possuir metodos nos quais nao utilizaremos seu comportamento na classe em si
 * e, desta maneira, referimo-nos aos comportamentos abstratos, nos quais estes
 * sao sobrescritos nas subclasses com um tipo de comportamento diferente em
 * cada subclasse.
 * 
 * @author lucascss
 *
 */
public abstract class Jogo {

	private String nome;
	private double preco;
	protected int maiorScore;
	protected int qtdQueJogou;
	protected int qtdQueZerou;
	private HashSet<Jogabilidade> jogabilidade;

	/**
	 * Construtor: Inicia-se um objeto Jogo com os seguintes estados abaixo.
	 * Note que este metodo lanca exceptions:
	 * 
	 * @param nomeJogo
	 * @param precoJogo
	 * @throws Exception
	 */
	public Jogo(String nomeJogo, double precoJogo) throws Exception {

		if (nomeJogo == null || nomeJogo.trim().isEmpty()) {
			throw new Exception("O nome do jogo nao pode ser nulo ou vazio.");
		}
		if (precoJogo <= 0) {
			throw new Exception("O preco do jogo nao pode ser nulo ou negativo.");
		}

		this.nome = nomeJogo;
		this.preco = precoJogo;
		this.maiorScore = 0;
		this.qtdQueJogou = 0;
		this.qtdQueZerou = 0;
		this.jogabilidade = new HashSet<>();

	}

	/**
	 * Este comportamento registra uma jogada, uma vez que um jogo eh jogado. Eh
	 * abstrato devido a sua funcionalidade ser diferente em cada subclasse de
	 * Jogo. Neste metodo, veremos que podemos calcular bonus para o usuario por
	 * jogadas.
	 * 
	 * @param score
	 * @param zerou
	 * @return
	 */
	public abstract int registraJogada(int score, boolean zerou);

	/**
	 * Este metodo retorna uma String do nome do Jogo.
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
	 * Este metodo retorna um double que refere-se ao preco do Jogo.
	 * 
	 * @return
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Este metodo apenas altera o preco do Jogo.
	 * 
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Este metodo retorna o maior score de um Jogo, ou seja, a maior pontuacao
	 * que foi atingida em todas as vezes que o Jogo foi jogado.
	 * 
	 * @return
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * Este metodo remodela o maior score de um Jogo.
	 * 
	 * @param maiorScore
	 */
	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	/**
	 * Este comportamento retorna a quantidade de vezes que um Jogo foi jogado.
	 * 
	 * @return
	 */
	public int getQtdQueJogou() {
		return qtdQueJogou;
	}

	/**
	 * Este comportamento soma "mais um" a quantidade de vezes que um Jogo foi
	 * jogado.
	 */
	public void setQtdQueJogou() {
		this.qtdQueJogou++;
	}

	/**
	 * Este metodo retorna a quantidade de vezes que um Jogo foi zerado - ou
	 * concluido.
	 * 
	 * @return
	 */
	public int getQtdQueZerou() {
		return qtdQueZerou;
	}

	/**
	 * Este comportamento soma "mais um" a quantidade de vezes que um Jogo foi
	 * zerado.
	 */
	public void setQtdQueZerou() {
		this.qtdQueZerou++;
	}

	/**
	 * Este comportamento eh a representacao do objeto da superclasse Jogo.
	 */
	public String toString() {

		final String FIM_DE_LINHA = System.lineSeparator();

		String mensagem = "==> Jogou " + this.getQtdQueJogou() + " vez(es)" + FIM_DE_LINHA + "==>" + "Zerou "
				+ this.getQtdQueZerou() + " vez(es)" + FIM_DE_LINHA + "Maior score: " + this.getMaiorScore();

		return mensagem;
	}

	/**
	 * Este comportamento eh a representacao de um "ID" do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogabilidade == null) ? 0 : jogabilidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Este comportamento compara se dois objetos sao iguais; no caso em
	 * questao, se dois jogos sao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (jogabilidade == null) {
			if (other.jogabilidade != null)
				return false;
		} else if (!jogabilidade.equals(other.jogabilidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

}