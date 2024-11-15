package view;

import fateczl.edu.br.arvore.ArvoreChar;

public class Principal {

	public static void main(String[] args) throws Exception {

		ArvoreChar a = new ArvoreChar();
		char[] vetor = {'k', 'd', 'm', 'b', 'f', 'l', 't', 'c', 'p', 'z', 'r'};
		
		for(char i : vetor) {
			a.insert(i);
		}
		
		System.out.println("Pré-fixo:");
		a.prefixSearch();
		System.out.println("\nInfixo:");
		a.infixSearch();
		System.out.println("\nPos-fixo:");
		a.postfixSearch();
	
		a.remove('r');
		
		System.out.println("\n------------\nApós remover o r");
		System.out.println("\nInfixo:");
		a.infixSearch();
		
	}

}
