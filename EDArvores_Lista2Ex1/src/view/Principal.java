package view;

import fateczl.edu.br.arvore.ArvoreInt;

public class Principal {

	public static void main(String[] args) throws Exception {

		ArvoreInt a = new ArvoreInt();
		int[] vetor = { 30, 15, 60, 10, 20, 40, 80 };

		for (int i : vetor) {
			a.insert(i);
		}

		System.out.println("Pré-fixo:");
		a.prefixSearch();
		System.out.println("\nInfixo:");
		a.infixSearch();
		System.out.println("\nPos-fixo:");
		a.postfixSearch();

		a.remove(60);
		
		System.out.println("\n------------\nApós remover o 60");
		System.out.println("\nInfixo:");
		a.infixSearch();

	}

}
