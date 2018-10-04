package supermercado;

/**
 * Abstração de um estoque de loja (nossa "budega"), no qual possui os produtos
 * disponíveis para a venda.
 * 
 * @author Christopher
 */

public class Estoque {

	private Produto[] produtos;
	private int totalCadastrados;
	public final String FIM_DE_LINHA;

	/**
	 * Construtor da classe "Estoque".
	 */
	public Estoque() {
		this.produtos = new Produto[3];
		this.totalCadastrados = 0;
		this.FIM_DE_LINHA = System.lineSeparator();
	}

	/**
	 * Adiciona produtos no estoque da loja.
	 * 
	 * @param nomeProduto
	 * @param valorProduto
	 * @param categoria
	 * @param quantidadeProduto
	 */
	public void recebeProduto(String nomeProduto, double valorProduto, String categoria, int quantidadeProduto) {
		Produto novoProduto = new Produto(nomeProduto, valorProduto, categoria, quantidadeProduto);
		this.adicionaProdutos(novoProduto);

	}

	/**
	 * Adiciona um novo produto ao estoque.
	 * 
	 * @param novoProduto
	 */
	public void adicionaProdutos(Produto novoProduto) {
		this.duplicaArray();
		this.produtos[this.totalCadastrados] = novoProduto;
		this.totalCadastrados++;
	}

	/**
	 * Busca um produto pelo seu nome.
	 * 
	 * @param nome
	 * @return O produto, caso exista; caso contrário, retorna null.
	 */
	public Produto buscaProduto(String nome) {
		Produto pesquisa = null;

		for (int i = 0; i < this.produtos.length; i++) {

			if (this.produtos[i] != null) {
				if (this.produtos[i].getNome().equalsIgnoreCase(nome)) {
					pesquisa = this.produtos[i];
				}
			}
		}
		return pesquisa;
	}

	public int getTotalCadastrados() {
		return this.totalCadastrados;
	}

	private void duplicaArray() {
		if (this.totalCadastrados == this.produtos.length) {
			Produto[] novoArray = new Produto[this.produtos.length * 2];

			for (int i = 0; i < this.produtos.length; i++) {
				novoArray[i] = this.produtos[i];
			}
			this.produtos = novoArray;
		}
	}

	/**
	 * Confere a quantidade de um certo produto no estoque.
	 * 
	 * @param nome
	 * @param quantidadeProdutos
	 * @return true, se a quantidade passada como parâmetro do produto é verdade;
	 *         falso, caso contrário.
	 */
	public boolean confereEstoque(String nome, int quantidadeProdutos) {
		Produto produto = buscaProduto(nome);

		if (produto != null) {
			if (produto.getQuantidade() > 0 && produto.getQuantidade() >= quantidadeProdutos) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se o estoque possui o produto passado como parâmetro.
	 * 
	 * @param nome
	 * @return true, caso o produto esteja em estoque; falso, caso contrário.
	 */
	public boolean verificaProdutoNoEstoque(String nome) {
		for (int i = 0; i < this.totalCadastrados; i++) {

			if (this.produtos[i].getNome().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String resposta = "";

		for (int i = 0; i < this.totalCadastrados; i++) {
			if (this.produtos[i] != null) {
				resposta += (i + 1) + ")" + this.produtos[i].toString() + " Restante: "
						+ this.produtos[i].getQuantidade() + this.FIM_DE_LINHA;
			}
		}
		return resposta;
	}

	/**
	 * Diminui a quantidade de um certo produto no estoque.
	 * 
	 * @param nomeProduto
	 * @param quantidadeProdutos
	 */
	public void diminuiQuantidade(String nomeProduto, int quantidadeProdutos) {
		Produto produto = buscaProduto(nomeProduto);
		produto.setQuantidade(produto.getQuantidade() - quantidadeProdutos);
	}

	/**
	 * Reúne o total a ser arrecadado sobre o preço dos produtos.
	 * 
	 * @return
	 */
	public double totalAserArrecadado() {
		double totalArrecadado = 0.0;

		for (int i = 0; i < this.produtos.length; i++) {

			if (this.produtos[i] != null) {
				totalArrecadado += this.produtos[i].getQuantidade() * this.produtos[i].getPreco();
			}
		}
		return totalArrecadado;
	}

}