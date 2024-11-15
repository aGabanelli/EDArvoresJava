package view;

import fateczl.edu.br.arvore.ArvoreInt;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		ArvoreInt a = new ArvoreInt();
		int[] vetor = {33, 15, 41, 38, 47, 34, 49, 43};
		
		for(int i : vetor) {
			a.insert(i);
		}
		
		System.out.println("Pré-fixo:");
		a.prefixSearch();
		System.out.println("\nInfixo:");
		a.infixSearch();
		System.out.println("\nPos-fixo:");
		a.postfixSearch();
	}
	
}
