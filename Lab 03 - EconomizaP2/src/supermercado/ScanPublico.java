package supermercado;

import java.util.Scanner;

/**
 * Classe de um "scanner" para encapsular a leitura de objetos primitivos.   
 * @author Christopher
 */

public class ScanPublico {

	public Scanner input = new Scanner(System.in);

	public int lerInteiro(String mensagem) {
		System.out.print(mensagem);
		int valor = this.input.nextInt();
		this.input.nextLine();
		return valor;
	}

	public double lerDouble(String mensagem) {
		System.out.print(mensagem);
		double valor = this.input.nextDouble();
		this.input.nextLine();
		return valor;
	}

	public String lerString(String mensagem) {
		System.out.print(mensagem);
		String valor = this.input.nextLine();
		return valor;
	}

	public String lerString() {
		String mensagem = this.input.nextLine();
		return mensagem;
	}

	public int lerInteiro() {
		int valor = this.input.nextInt();
		this.input.nextLine();
		return valor;
	}

	public double lerDouble() {
		double valor = this.input.nextDouble();
		this.input.nextLine();
		return valor;
	}
}
