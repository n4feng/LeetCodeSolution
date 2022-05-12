class CourseScheduleII210 {
    static int white = 0; //not being taken
    static int gray = 1; //being iterating, if appear in preRequest means there is a loop
    static int black = 2; //already being taken
    
    boolean isPossible;
    Map<Integer, List<Integer>> adj_map;
    int[] status;
    List<Integer> order;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj_map = new HashMap<>();
        isPossible = true;
        order = new ArrayList<>();
        //initial status, site all to 0 (means untaken)
        status = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            status[i] = 0;
            List<Integer> l = new ArrayList<>();
            adj_map.put(i,l);
        }
        //key is the course id, value is a list of all prerequeisites of this course 
        for(int[] pre : prerequisites){
            adj_map.get(pre[0]).add(pre[1]);
        }

        
        //dfs all the courses
        for(int i = 0; i < numCourses; i++){
            if(status[i] == 0){
                dfs(i);
            }
        }
        if (!isPossible){
            return new int[0];
        }
        return order.stream().mapToInt(i->i).toArray();
    }
    
    public void dfs(int course){
        if (!isPossible) return;
        //mark current as gray
        status[course] = 1;
        for(int i : adj_map.get(course)){
            //we find the loop, mark as inpossible and break
            if (status[i] == 1){
                isPossible = false;
                return;
            }
            // if untaken
            else if(status[i] == 0){
                status[i] = 1;
                dfs(i);
            }
        }
        //if all pre are filled, mark course as taken
        status[course] = 2;
        order.add(course);
    }
}
