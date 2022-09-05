class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]:edges)
        {
            adj.get(edge[0]).add(edge[1]);
                        
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean vis[] = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        
        while(!q.isEmpty())
        {
            int rem = q.remove();
            
            if(vis[rem]==true)
                continue;
            
            vis[rem] = true;
            
            for(Integer i:adj.get(rem))
            {
                if(vis[i]==false)
                    q.add(i);
            }
        }
        
        return vis[destination];
    }
}
