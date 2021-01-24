package leetcode;
import java.util.*;
public class NumberofIslandsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m,n);
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<positions.length;i++){
           
                int k = positions[i][0];
                int l = positions[i][1];
                uf.add(k,l);
                for(int[] d : dir){
                    int q = uf.getId(k+d[0],l+d[1]);
                    if(q > 0 && !uf.isConnected(uf.getId(k,l),q)){
                        uf.unify(uf.getId(k,l),q);
                    }
                }
            
            res.add(uf.component());
        }
        
        return res;
    }
}

class UnionFind{
    private int[] id;
    private int[] sz;
    private int noOfComponents;
    private int m;
    private int n;
    
    public UnionFind(int m, int n){
        this.m = m;
        this.n = n;
        id = new int[m*n+1];
        sz = new int[m*n+1];
    }
    
    public int index(int x, int y){
        return n*x +y+1;
    }
    
    public int getId(int x, int y){
        if(x>=0 && x<m && y>=0 && y<n ){
            return id[index(x,y)];
        }
        return 0;
    }
    
    public int component(){
        return noOfComponents;
    }
    
    public int find(int p){
        int root = p;
        while(root !=id[root]){
            root = id[root];
        }
        while(p!=root){
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }
    
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }
    
    public void add(int x, int y){
        int index = index(x,y);
        if(id[index] != 0){
            return;
        }
        id[index] = index;
        noOfComponents++;
        sz[index] = 1;
    }
    
    public void unify(int p, int q){
        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2){
            noOfComponents--;
            return;
        }
        if(sz[root1] < sz[root2]){
            id[root1] = root2;
            sz[root2] +=sz[root1];
        }else{
            id[root2] = root1;
            sz[root1] +=sz[root2];
        }
        
        noOfComponents--;
    }
}
