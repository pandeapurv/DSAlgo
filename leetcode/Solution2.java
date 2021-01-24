package leetcode;

import java.util.*;

public class Solution2 {

	public int minimumCost(int N, int[][] connections) {
		UnionFind uf = new UnionFind(N);

		Arrays.sort(connections, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}

		});
		int res = 0;
		for (int[] arr : connections) {
			int p = arr[0];
			int q = arr[1];
			int cost = arr[2];
			if (!uf.isConnected(p, q)) {
				uf.unify(p, q);
				res += cost;
			}
		}

		return res;
	}

	class UnionFind {
		private int size;
		private int noOfComponents;
		private int[] ids;
		private int[] sz;

		public UnionFind(int size) {
			this.size = size;
			this.noOfComponents = size;
			ids = new int[size + 1];
			sz = new int[size + 1];
			for (int i = 1; i <= size; i++) {
				ids[i] = i;
				sz[i] = 1;
			}
		}

		public int getSize(int n) {
			return sz[n];
		}

		public boolean isConnected(int p, int q) {
			return find(p) == find(q);
		}

		public int find(int p) {
			int root = p;
			while (root != ids[root]) {
				root = ids[root];
			}

			while (p != root) {
				int next = ids[p];
				ids[p] = root;
				p = next;
			}

			return root;
		}

		public int noOfComponents() {
			return this.noOfComponents;
		}

		public void unify(int p, int q) {
			int root1 = find(p);
			int root2 = find(q);

			if (root1 == root2) {
				return;
			}

			if (sz[root1] < sz[root2]) {
				sz[root2] += sz[root1];
				ids[root1] = root2;
			} else {
				sz[root1] += sz[root2];
				ids[root2] = root1;
			}
			noOfComponents--;

		}
	}

}
