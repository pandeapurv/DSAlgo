package leetcode;

public class UnionFind2 {

	//array to represent root of each element
	// array to represent size of each component
	// noOfComponents
	//
	
	private int noOfComponents;
	private int size;
	private int[] id;
	private int[] sz;
	
	public UnionFind2(int size) {
		this.size = size;
		this.noOfComponents = size;
		id = new int[size];
		sz = new int[size];
		
		for(int i=0;i<size;i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int noOfComponents() {
		return noOfComponents;
	}
	
	public int find(int p) {
		int root = p;
		while(root !=id[root]) {
			root = id[root];
		}
		while(p !=root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}
		return root;
	}
	
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int size(int p) {
		return sz[p];
	}
	
	public void unify(int p, int q) {
		int root1 = find(p);
		int root2 = find(q);
		
		if(root1 == root2) {
			return;
		}
		
		if(sz[root1] < sz[root2]) {
			id[root1] = root2;
			sz[root2] +=sz[root1];
		}else {
			id[root2] = root1;
			sz[root1] +=sz[root2];
		}
		noOfComponents--;
	}
	
	
	
}
