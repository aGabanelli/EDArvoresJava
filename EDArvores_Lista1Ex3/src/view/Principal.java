package view;

import fateczl.edu.br.arvore.ArvoreChar;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		ArvoreChar a = new ArvoreChar();
		char[] vetor = {'M', 'F', 'S', 'D', 'J', 'P', 'U', 'A', 'E', 'H', 'Q', 'T', 'W', 'K'};
		
		for(char i : vetor) {
			a.insert(i);
		}
		
		a.remove('F');
		a.remove('U');
		
		System.out.println("Pré-fixo:");
		a.prefixSearch();
		System.out.println("\nInfixo:");
		a.infixSearch();
		System.out.println("\nPos-fixo:");
		a.postfixSearch();
	}
	
}
