class NetworkDelayTime743 {
    Map<Integer, List<int[]>> edges;
    int[] currentMin;
    boolean[] underestimated;
    public int networkDelayTime(int[][] times, int n, int k) {
        //in the value, first element is destination
        //second element is time taken
        edges = new HashMap<>();
        //store time taken to path at a node if already been calculated
        currentMin = new int[n];
        underestimated = new boolean[n];
        for(int i = 0; i < n; i++) currentMin[i] = Integer.MAX_VALUE;
        currentMin[k-1] = 0;
        
        //initial edges map to search in O(m) where m is average
        //edges number of given node (m = times.size() / n)
        for(int[] i : times){
            int[] newEdge = new int[2];
            newEdge[0] = i[1];
            newEdge[1] = i[2];
            if(edges.containsKey(i[0]))
                edges.get(i[0]).add(newEdge);
            else{
                List<int[]> newEdges = new ArrayList<>();
                newEdges.add(newEdge);
                edges.put(i[0], newEdges);
            }
        }

        dfsTime(k, 0);
        int maxTime = -1;
        for(int i = 0; i < n; i++){
            if(currentMin[i] == Integer.MAX_VALUE) return -1;
            else if(currentMin[i] > maxTime) maxTime = currentMin[i];
        }
        return maxTime;
    }
    //DFS to fill the map
    public void dfsTime(int k, int curTime){
        //break if in loop, or current time is longger than estimated one
        if(underestimated[k-1]) return;
        else if(currentMin[k-1] < curTime) return;
        currentMin[k-1] = curTime;
        underestimated[k-1] = true;
        //keep on iterating until no next edge or breaked
        if(edges.containsKey(k)){
            for(int[] i : edges.get(k)){
                dfsTime(i[0], curTime+i[1]);
            }
        }
        underestimated[k-1] = false;
        return;
    }
}
