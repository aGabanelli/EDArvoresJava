package fateczl.edu.br.arvore;

public class ArvoreChar {

	NoChar raiz = new NoChar();

	public ArvoreChar() {
		raiz = null;
	}

	// alterar o valor do char para int
	private int valorChar(char caractere) {
		int valorChar = caractere - 0;
		return valorChar;
	}

	// inserir um elemento
	private void insertLeaf(NoChar no, NoChar raizSubarvore) {
		if (raiz == null) {
			raiz = no;
		} else {
			if (valorChar(no.dado) < valorChar(raizSubarvore.dado)) {
				if (raizSubarvore.esquerda == null) {
					raizSubarvore.esquerda = no;
				} else {
					insertLeaf(no, raizSubarvore.esquerda);
				}
			}
			if (valorChar(no.dado) >= valorChar(raizSubarvore.dado)) {
				if (raizSubarvore.direita == null) {
					raizSubarvore.direita = no;
				} else {
					insertLeaf(no, raizSubarvore.direita);
				}
			}
		}

	}

	public void insert(char dado) {
		NoChar no = new NoChar();
		no.dado = dado;
		no.esquerda = null;
		no.direita = null;
		insertLeaf(no, raiz);
	}

	// buscando um elemento
	private NoChar nodeSearch(NoChar raizSubarvore, char valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valorChar(valor) < valorChar(raizSubarvore.dado)) {
			return nodeSearch(raizSubarvore.esquerda, valor);
		} else if (valorChar(valor) > valorChar(raizSubarvore.dado)) {
			return nodeSearch(raizSubarvore.direita, valor);
		} else {
			return raizSubarvore;
		}
	}

	private int nodeLevel(NoChar raizSubarvore, char valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valorChar(valor) < valorChar(raizSubarvore.dado)) {
			return 1 + nodeLevel(raizSubarvore.esquerda, valor);
		} else if (valorChar(valor) > valorChar(raizSubarvore.dado)) {
			return 1 + nodeLevel(raizSubarvore.direita, valor);
		} else {
			return 0;
		}
	}

	public void search(char valor) throws Exception {
		try {
			NoChar no = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Dado " + no.dado + " | Nível: " + level);
		} catch (Exception e) {
			throw new Exception("Valor não existe");
		}
	}

	public boolean exists(char valor) {
		try {
			nodeSearch(raiz, valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// removendo elementos
	private void removeChild(NoChar raizSubarvore, char valor) throws Exception {
		NoChar no = nodeSearch(raizSubarvore, valor);
		if (no != null) {
			NoChar pai = nodeParent(null, raiz, no.dado);
			if (no.esquerda != null & no.direita != null) {
				NoChar noTroca = no.esquerda;
				while (noTroca.direita != null) {
					noTroca = noTroca.direita;
				}
				pai = nodeParent(null, raizSubarvore, noTroca.dado);
				no.dado = noTroca.dado;
				noTroca.dado = valor;
				removeOneOrZeroLeaf(pai, noTroca);
			} else {
				removeOneOrZeroLeaf(pai, no);
			}
		} else {
			throw new Exception("Valor inexistente");
		}
	}

	private void removeOneOrZeroLeaf(NoChar parent, NoChar no) {
		if (no.esquerda == null && no.direita == null) {
			if (parent == null) {
				raiz = null;
			} else {
				change(parent, no, null);
			}
		} else if (no.direita != null) {
			if (parent == null) {
				raiz = no.direita;
			} else {
				change(parent, no, no.direita);
			}
		} else if (no.direita == null) {
			if (parent == null) {
				raiz = no.esquerda;
			} else {
				change(parent, no, no.esquerda);
			}
		}
	}

	private void change(NoChar parent, NoChar no, NoChar novoNo) {
		if (parent.esquerda != null && valorChar(parent.esquerda.dado) == valorChar(no.dado)) {
			parent.esquerda = novoNo;
		} else if (valorChar(parent.direita.dado) == valorChar(no.dado)) {
			parent.direita = novoNo;
		}
	}

	private NoChar nodeParent(NoChar parent, NoChar raizSubarvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valor < raizSubarvore.dado) {
			return nodeParent(raizSubarvore, raizSubarvore.esquerda, valor);
		} else if (valor > raizSubarvore.dado) {
			return nodeParent(raizSubarvore, raizSubarvore.direita, valor);
		} else {
			if (parent == null) {
				return raiz;
			} else {
				return parent;
			}
		}
	}

	public void remove(char valor) throws Exception {
		try {
			removeChild(raiz, valor);
		} catch (Exception e) {
			throw new Exception("Valor não existente");
		}
	}

	// atravessamento prefixo
	private void prefix(NoChar raizSubarvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			System.out.print(raizSubarvore.dado);
			System.out.print(" ");
			if (raizSubarvore.esquerda != null) {
				prefix(raizSubarvore.esquerda);
			}
			if (raizSubarvore.direita != null) {
				prefix(raizSubarvore.direita);
			}
		}
	}

	public void prefixSearch() throws Exception {
		prefix(raiz);
	}

	// atravessamento infixo
	private void infix(NoChar raizSubarvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (raizSubarvore.esquerda != null) {
				infix(raizSubarvore.esquerda);
			}
			System.out.print(raizSubarvore.dado + " (" + valorChar(raizSubarvore.dado) + ")");
			System.out.print(" ");
			if (raizSubarvore.direita != null) {
				infix(raizSubarvore.direita);
			}
		}
	}

	public void infixSearch() throws Exception {
		infix(raiz);
	}

	// atravessamento posfixo
	private void postfix(NoChar raizSubarvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (raizSubarvore.esquerda != null) {
				postfix(raizSubarvore.esquerda);
			}
			if (raizSubarvore.direita != null) {
				postfix(raizSubarvore.direita);
			}
			System.out.print(raizSubarvore.dado);
			System.out.print(" ");
		}
	}

	public void postfixSearch() throws Exception {
		postfix(raiz);
	}

}
