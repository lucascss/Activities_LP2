package supermercado;

/**
 * Abstra��o de um caixa de loja, no qual possui as opera��es de: cadastrar
 * produtos, vender produtos ou imprimir o balan�o.
 * 
 * @author Christopher
 */

public class Caixa {

	private ScanPublico leitor;
	private Estoque deposito;
	private double totalArrecadado;

	/**
	 * Construtor da classe "Caixa".
	 */
	public Caixa() {
		this.deposito = new Estoque();
		this.leitor = new ScanPublico();
		this.deposito = new Estoque();
		this.totalArrecadado = 0;
	}

	/**
	 * M�todo respons�vel pelo cadastro de produtos.
	 */
	public void cadastraProdutos() {
		String opcao = "";
		System.out.println("= = = = Cadastro de Produtos = = = =");

		do {
			if (opcao.equalsIgnoreCase("n�o") || opcao.equalsIgnoreCase("nao")) {
				break;
			}
			
			String nomeProduto = leitor.lerString("Digite o nome do produto: ");
			double valorProduto = leitor.lerDouble("Digite o pre�o unit�rio do produto: ");
			String categoria = leitor.lerString("Digite o tipo do produto: ");
			int quantidadeProduto = leitor.lerInteiro("Digite a quantidade no estoque: ");

			deposito.recebeProduto(nomeProduto, valorProduto, categoria, quantidadeProduto);

			System.out.println(quantidadeProduto + " un. de " + nomeProduto + " cadastrado(s) com sucesso.");

			System.out.println();

			opcao = leitor.lerString("Deseja cadastrar outro produto? ");
			System.out.println();

		} while (opcao.equalsIgnoreCase("sim"));

	}

	/**
	 * M�todo respons�vel pela venda de um produto.
	 */
	public void vendaProdutos() {
		String entrada = null;
		System.out.println("= = = = Venda de Produtos = = = =");

		do {
			if (entrada.equalsIgnoreCase("n�o") || entrada.equalsIgnoreCase("nao")) {
				break;
			}
			
			String nomeProduto = leitor.lerString("Digite o nome do produto: ");
			Produto verificaPraVenda = deposito.buscaProduto(nomeProduto);

			if (verificaPraVenda == null) {
				System.out.println("==> " + nomeProduto + " n�o est� cadastrado(a) no sistema.");
			}

			else {
				System.out.println();
				int quantidade = leitor.lerInteiro("Digite a quantidade que desejas vender: ");

				if (deposito.confereEstoque(nomeProduto, quantidade)) {
					deposito.diminuiQuantidade(nomeProduto, quantidade);
					totalArrecadado += verificaPraVenda.getPreco() * quantidade;
					System.out.println("==> Total arrecadado: R$ " + formataDouble(totalArrecadado));
				}

				else {
					System.out.println("N�o � poss�vel vender, pois n�o h�" + nomeProduto + " suficiente(s).");
				}
			}

			System.out.print("Deseja vender outro produto? ");
			entrada = leitor.lerString();

		} while (entrada.equalsIgnoreCase("sim"));
	}

	/**
	 * M�todo que imprime o balan�o atual, mostrando: - Total de produtos
	 * cadastrados; - Total de produtos no estoque; - Total arrecadado em vendas; -
	 * Total que pode ser arrecadado;
	 */
	public void imprimeBalanco() {
		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados:");
		System.out.println(deposito.toString());
		System.out.println("Total arrecadado em vendas: R$ " + totalArrecadado);
		System.out.println("Total que pode ser arrecadado: R$ " + deposito.totalAserArrecadado());
	}

	public String formataDouble(double numero) {
		String string = String.format("%.2f", numero);
		return string;
	}

}
