package leetcode;

import java.util.*;

public class CriticalConnections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> tmp = new ArrayList<>();
		List<Integer> l1 = new ArrayList<>();
		l1.add(0);
		l1.add(1);

		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		l2.add(2);

		tmp.add(l1);
		tmp.add(l2);
		List<List<Integer>> res = helper(3, tmp);

		for (List<Integer> l : res) {
			System.out.println(l.get(0) + " . " + l.get(1));
		}

	}

	private static List<List<Integer>>  helper(int n, List<List<Integer>> connections) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		boolean[] visited = new boolean[n];
		int[] ids = new int[n];
		int[] low = new int[n];

		// List<Integer> l = connections.get(0);
		for (List<Integer> connection : connections) {
			graph.get(connection.get(0)).add(connection.get(1));
			graph.get(connection.get(1)).add(connection.get(0));
		}

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, visited, ids, low, i, -1, res);
			}
		}
		
		return res;

	}

	static int id = 0;

	private static void dfs(List<List<Integer>> graph, boolean[] visited, int[] ids, int[] low, int at, int parent,
			List<List<Integer>> res) {

		ids[at] = low[at] = ++id;
		visited[at] = true;

		for (Integer to : graph.get(at)) {
			if (to == parent) {
				continue;
			}
			if (!visited[to]) {
				dfs(graph, visited, ids, low, to, at, res);
				low[at] = Math.min(low[at], low[to]);
				if (ids[at] < low[to]) {
					List<Integer> list = new ArrayList<>();
					list.add(at);
					list.add(to);
					res.add(new ArrayList<>(list));
				}
			} else {
				low[at] = Math.min(low[at], ids[to]);
			}
		}

	}

}
