package supermercado;

/**
 * Menu principal da nossa aplicação. 
 * @author Christopher
 */

public class MenuPrincipal {

	public static void main(String[] args) {

		Caixa caixa = new Caixa();
		ScanPublico leitor = new ScanPublico();

		int opcao;
		final int CADASTRO = 1;
		final int VENDA = 2;
		final int IMPRIME = 3;
		final int SAIR = 4;

		do {
			System.out.println();
			System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");
			System.out.println("Digite a opção desejada:");
			System.out.println("1 - Cadastrar um Produto");
			System.out.println("2 - Vender um Produto");
			System.out.println("3 - Imprimir Balanção");
			System.out.println("4 - Sair");
			System.out.println();
			opcao = leitor.lerInteiro("Opção: ");

			switch (opcao) {
			case CADASTRO:
				caixa.cadastraProdutos();
				break;
			case VENDA:
				caixa.vendaProdutos();
				break;
			case IMPRIME:
				caixa.imprimeBalanco();
				break;
			default:
				break;
			}
		} while (opcao < SAIR);
	}

}