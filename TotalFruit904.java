class TotalFruit904 {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1) return 1;
        //a queue record index of 2 types of fruit last appeared in window
        //{fruitTypes, index}
        List<int[]> baskets = new ArrayList<>();
        int[] fruit = {fruits[0], 0};
        baskets.add(fruit);
        int start = 0, end = 0, res = 0;
        for(; end <= fruits.length; end++){
            if(end == fruits.length){
                res = Math.max(end-start, res);
                break;
            }
            if(baskets.size() == 1){
                if(fruits[end] != baskets.get(0)[0]){
                    fruit = new int[2];
                    fruit[0] = fruits[end];
                    fruit[1] = end;
                    baskets.add(fruit);
                }                    
                else
                    baskets.get(0)[1]=end;
            }
            else{
                if(fruits[end] != baskets.get(0)[0] && fruits[end] != baskets.get(1)[0]){
                    int cur= end - start;
                    res = Math.max(cur, res);
                    //jump to the begin of latter type of fruit
                    if(baskets.get(0)[1] < baskets.get(1)[1]){
                        start = baskets.get(0)[1]+1;
                        baskets.remove(0);                        
                    }
                    else{
                        start = baskets.get(1)[1]+1;
                        baskets.remove(1);
                    }
                    fruit = new int[2];
                    fruit[0] = fruits[end];
                    fruit[1] = end;
                    baskets.add(fruit);
                }
                else if(fruits[end] == baskets.get(0)[0])
                    baskets.get(0)[1]=end;
                else if(fruits[end] == baskets.get(1)[0])
                    baskets.get(1)[1]=end;
            }

        }
        return res;
    }
}
