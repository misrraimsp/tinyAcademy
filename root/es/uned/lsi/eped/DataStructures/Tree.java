package es.uned.lsi.eped.DataStructures;

public class Tree<T> implements TreeIF<T> {
	
	private T root;
	private ListIF<TreeIF<T>> children; 
	
	//constructor por defecto: construye un árbol n-ário vacío
	public Tree(){
		root = null;
		children = new List<TreeIF<T>>();
	}
	//constructor por parámetro: construye un árbol n-ário sin hijos
	//cuya raíz es el elemento dado por parámetro
	public Tree(T e){
		setRoot(e);
		children = new List<TreeIF<T>>();
	}
	//constructor por copia
	public Tree(Tree<T> T){
		this();
		setRoot(T.getRoot());
		IteratorIF<TreeIF<T>> iterator = T.getChildren().iterator();
		while(iterator.hasNext()){
			TreeIF<T> child = iterator.getNext();
			int numChildren = children.size();
			addChild(numChildren+1, child);
		}
	}
	
	public int size() {
		if(isEmpty()){
			return 0;
		}
		int numChildren = 1; //nodo ra�z
		IteratorIF<TreeIF<T>> iterator = children.iterator();
		//sumar los nodos de los hijos
		while (iterator.hasNext()){
			TreeIF<T> child = iterator.getNext();
			numChildren = numChildren+child.size();
		}
		return numChildren;
	}

	public boolean isEmpty() {
		return root==null;
	}
	
	public boolean contains(T e) {
		if(isEmpty()){
			return false;
		}
		//comprobar si el elemento se corresponde con la raíz del árbol.
		T root = getRoot();
		if(root.equals(e)){
			return true;
		}
		//comprobar si el elemento aparece en alguno de los hijos
		IteratorIF<TreeIF<T>> iterator = children.iterator();
		while (iterator.hasNext()){
			TreeIF<T> child = iterator.getNext();
			T rootChild = child.getRoot();
			if(rootChild.equals(e) || child.contains(e)){
				return true;
			}
		}
		return false;
	}

	public void clear() {
		root = null;
		children = null;
	}

	public IteratorIF<T> iterator() {
		return new TreeIterator<T>(this, 0);
	}
	
	public T getRoot() {
		return root;
	}

	public void setRoot(T e) {
		root = e;
	}

	public ListIF<TreeIF<T>> getChildren() {
		return children;
	}

	public TreeIF<T> getChild(int pos) {
		return children.get(pos);
	}

	public void addChild(int pos, TreeIF<T> e) {
		children.insert(e, pos);
	}

	public void removeChild(int pos) {
		children.remove(pos);
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}

	public IteratorIF<T> iterator(int traversal) {
		return new TreeIterator<T>(this,traversal);
	}
	
	/* Busca dentro del arbol llamante el subarbol para	el		*
	 * cual el parametro es su raiz								*
	 * @return el subarbol encontrado. Null si no se			*
	 * encuentra												*
     * @param elem el elemento raiz del subarbol buscado			*/
	public Tree<T> getSubTree(T elem) {
		
		//if(root == elem){return this;}
		
		Stack<TreeIF<T>> stack = new Stack<TreeIF<T>>();
		Tree<T> tree = this;
		
		stack.push(tree);
		while (!stack.isEmpty()) {
			tree = (Tree<T>) stack.getTop();
			stack.pop();
			if (tree.getRoot().equals(elem)) {
				return tree;
			}
			if (!tree.isLeaf()) {
				IteratorIF<TreeIF<T>> ite = tree.getChildren().iterator();
				while (ite.hasNext()) {
					stack.push(ite.getNext());
				}
			}
		}
		return null;
	}

	
	/* Busca dentro del arbol llamante el superarbol para el	*
	 * cual el parametro es hijo								*
	 * @return el superarbol encontrado. Null si no se			*
	 * encuentra, esto es, elem es la raiz del arbol llamante	*
     * @param elem el elemento hijo del super arbol buscado		*	
     * @pre this.contains(elem)									*/
	public TreeIF<T> getSuperTree(T elem) {
		StackIF<TreeIF<T>> stack = new Stack<TreeIF<T>>();
		TreeIF<T> tree;
		
		stack.push(this);
		while (!stack.isEmpty()) {
			tree = stack.getTop();
			stack.pop();
			IteratorIF<TreeIF<T>> ite = tree.getChildren().iterator();
			while (ite.hasNext()){
				TreeIF<T> hijo = ite.getNext();
				if(hijo.getRoot().equals(elem)){
					return tree;
				}
				else {
					stack.push(hijo);
				}
			}
		}
		return null;
	}

}
