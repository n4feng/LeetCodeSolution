class Combinations77 {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        walkThrough(path, n, k);
        return result;
    }
    public void walkThrough(List<Integer> path, int n, int k){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = path.size() > 0 ? path.get(0)+1 : 1; i < n + 1; i++){
            path.add(0, i);
            walkThrough(path, n, k);
            path.remove(0);
        }
        return;
    }
}
