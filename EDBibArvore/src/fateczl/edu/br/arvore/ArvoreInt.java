package fateczl.edu.br.arvore;

public class ArvoreInt {

	NoInt raiz = new NoInt();

	public ArvoreInt() {
		raiz = null;
	}

	// inserir um elemento
	private void insertLeaf(NoInt no, NoInt raizSubarvore) {
		if (raiz == null) {
			raiz = no;
		} else {
			if (no.dado < raizSubarvore.dado) {
				if (raizSubarvore.esquerda == null) {
					raizSubarvore.esquerda = no;
				} else {
					insertLeaf(no, raizSubarvore.esquerda);
				}
			}
			if (no.dado >= raizSubarvore.dado) {
				if (raizSubarvore.direita == null) {
					raizSubarvore.direita = no;
				} else {
					insertLeaf(no, raizSubarvore.direita);
				}
			}
		}

	}

	public void insert(int dado) {
		NoInt no = new NoInt();
		no.dado = dado;
		no.esquerda = null;
		no.direita = null;
		insertLeaf(no, raiz);
	}
	
	// buscando um elemento
	private NoInt nodeSearch(NoInt raizSubarvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valor < raizSubarvore.dado) {
			return nodeSearch(raizSubarvore.esquerda, valor);
		} else if (valor > raizSubarvore.dado) {
			return nodeSearch(raizSubarvore.direita, valor);
		} else {
			return raizSubarvore;
		}
	}

	private int nodeLevel(NoInt raizSubarvore, int valor) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else if (valor < raizSubarvore.dado) {
			return 1 + nodeLevel(raizSubarvore.esquerda, valor);
		} else if (valor > raizSubarvore.dado) {
			return 1 + nodeLevel(raizSubarvore.direita, valor);
		} else {
			return 0;
		}
	}
	
	public void search(int valor) throws Exception {
		try {
			NoInt no = nodeSearch(raiz, valor);
			int level = nodeLevel(raiz, valor);
			System.out.println("Dado " + no.dado + " | Nível: " + level);
		} catch (Exception e) {
			throw new Exception("Valor não existe");
		}
	}
	
	public boolean exists(int valor) {
		try {
			nodeSearch(raiz, valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// removendo elementos
	private void removeChild(NoInt raizSubarvore, int valor) throws Exception {
		NoInt no = nodeSearch(raizSubarvore, valor);
		if (no != null) {
			NoInt pai = nodeParent(null, raiz, no.dado);
			if (no.esquerda != null & no.direita != null) {
				NoInt noTroca = no.esquerda;
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

	private void removeOneOrZeroLeaf(NoInt parent, NoInt no) {
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

	private void change(NoInt parent, NoInt no, NoInt novoNo) {
		if (parent.esquerda != null && parent.esquerda.dado == no.dado) {
			parent.esquerda = novoNo;
		} else if (parent.direita.dado == no.dado) {
			parent.direita = novoNo;
		}
	}

	private NoInt nodeParent(NoInt parent, NoInt raizSubarvore, int valor) throws Exception {
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

	public void remove(int valor) throws Exception {
		try {
			removeChild(raiz, valor);
		} catch (Exception e) {
			throw new Exception("Valor não existente");
		}
	}

	// atravessamento prefixo
	private void prefix(NoInt raizSubarvore) throws Exception {
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
	private void infix(NoInt raizSubarvore) throws Exception {
		if (raiz == null) {
			throw new Exception("Árvore vazia");
		} else {
			if (raizSubarvore.esquerda != null) {
				infix(raizSubarvore.esquerda);
			}
			System.out.print(raizSubarvore.dado);
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
	private void postfix(NoInt raizSubarvore) throws Exception {
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
