package supermercado;

/**
 * Classe que representa a abstração de um produto qualquer de uma "budega".
 * @author Christopher
 */

public class Produto {

	private String nome;
	private String categoria;
	private double preco;
	private int quantidade;

	/**
	 * Construtor da classe "Produto".
	 * @param nomeProduto  
	 * @param precoProduto 
	 * @param tipoProduto  
	 * @param quantidadeProdutos
	 */
	public Produto(String nomeProduto, double precoProduto, String tipoProduto, int quantidadeProdutos) {
		this.nome = nomeProduto;
		this.preco = precoProduto;
		this.categoria = tipoProduto;
		this.quantidade = quantidadeProdutos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return categoria;
	}

	public void setTipo(String tipo) {
		this.categoria = tipo;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantia) {
		this.quantidade = quantia;
	}

	public String toString() {
		return this.nome + "(" + this.categoria + "). R$" + formataDouble(this.preco);
	}

	public String formataDouble(double valor) {
		return String.format("%.2f", valor);

	}

}