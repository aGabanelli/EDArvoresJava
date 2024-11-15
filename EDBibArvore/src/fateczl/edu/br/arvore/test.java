package fateczl.edu.br.arvore;

public class test {

	
	public static void main(String[] args) throws Exception {
		
		ArvoreChar c = new ArvoreChar();
		ArvoreInt i = new ArvoreInt();
		
		i.insert(2);
		i.insert(4);
		i.insert(1);
		i.insert(5);
		i.insert(7);

		c.insert('A');
		c.insert('a');
		c.insert('B');
		c.insert('b');
		
		i.infixSearch();
		c.infixSearch();
		
	}
}
