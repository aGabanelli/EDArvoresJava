package view;

import fateczl.edu.br.arvore.ArvoreInt;

public class Principal {

	public static void main(String[] args) throws Exception {

		ArvoreInt a = new ArvoreInt();
		int[] vetor = { 7, 8, 3, 4, 2, 1, 6, 5 };

		for (int i : vetor) {
			a.insert(i);
		}
		
		a.remove(7);
		a.remove(6);

		System.out.println("Pré-fixo:");
		a.prefixSearch();
		System.out.println("\nInfixo:");
		a.infixSearch();
		System.out.println("\nPos-fixo:");
		a.postfixSearch();
	}

}
