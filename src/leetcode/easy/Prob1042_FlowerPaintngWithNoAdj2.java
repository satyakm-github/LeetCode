package leetcode.easy;

public class Prob1042_FlowerPaintngWithNoAdj2 {

	public static void main(String[] args) {

		System.out.println(java.util.Arrays.toString(gardenNoAdj(3, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } })));
		System.out.println(java.util.Arrays.toString(gardenNoAdj(4, new int[][] { { 1, 2 }, { 3, 4 } })));
		System.out.println(java.util.Arrays
				.toString(gardenNoAdj(4, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 3 }, { 2, 4 } })));

		System.out.println(java.util.Arrays
				.toString(gardenNoAdj(5, new int[][] { { 4, 1 }, { 4, 2 }, { 4, 3 }, { 2, 5 }, { 1, 2 }, { 1, 5 } })));

		System.out.println(java.util.Arrays.toString(gardenNoAdj(10000, new int[][] {})));
	}

	static public int[] gardenNoAdj(int N, int[][] paths) {
		boolean[] visited = new boolean[N + 1];
		int[] colorAllocations = new int[N + 1];

		// make edges
		java.util.List<Integer>[] adj = new java.util.ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new java.util.ArrayList<Integer>();
		}

		for (int[] eachEdge : paths) {
			adj[eachEdge[0]].add(eachEdge[1]);
			adj[eachEdge[1]].add(eachEdge[0]);
		}

		// call DFS
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				DFSUtil(i, adj, visited, colorAllocations);
			}
		}

		return java.util.Arrays.copyOfRange(colorAllocations, 1, colorAllocations.length);
	}

	static private void DFSUtil(int i, java.util.List<Integer>[] adj, boolean[] visited, int[] colorAllocations) {
		visited[i] = true;
		getSafeColortoPaint(i, colorAllocations, adj);

		for (int eachAdjVer : adj[i]) {
			if (visited[eachAdjVer] == false) {
				DFSUtil(eachAdjVer, adj, visited, colorAllocations);
			}
		}
	}

	private static void getSafeColortoPaint(int i, int[] colorAllocations, java.util.List<Integer>[] adj) {
		for (int color = 1; color <= 4; color++) {
			boolean safeColor = true;
			for (int adjVert : adj[i]) {
				if (colorAllocations[adjVert] == color) {
					safeColor = false;
				}
			}

			if (safeColor) {
				colorAllocations[i] = color;
				break;
			}
		}
	}

}
