class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i){
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[numCourses];
        int[] indegree = new int[numCourses];
        for(int[] pre: prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; ++i){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while(que.size() > 0){
            int rem = que.poll();
            if(visited[rem] == true) continue;
            visited[rem] = true;
            ans[idx++] = rem;
            for(int nbrs: adj.get(rem)){
                indegree[nbrs]--;
                if(indegree[nbrs] == 0){
                    que.add(nbrs);
                }
            }
        }
        
        return idx == ans.length ? true: false;
    }
}
