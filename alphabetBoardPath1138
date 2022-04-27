class Solution {
    
    public String alphabetBoardPath(String target) {
        Map<Character, List<Integer>> keyboard = new HashMap<>();
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                List<Integer> corrdinate = new ArrayList<>();
                corrdinate.add(i);
                corrdinate.add(j);
                keyboard.put((char)('a'+ i*5 + j), corrdinate);
            }
        }
        //add z seperately to keyboard
        List<Integer> corrdinateZ = new ArrayList<>();
        corrdinateZ.add(5);
        corrdinateZ.add(0);
        keyboard.put('z', corrdinateZ);
        StringBuilder res = new StringBuilder();
        char current = 'a';
        for(char c : target.toCharArray()){
            //if original char is 'z', move it up to 'u' and do the rest of work
            if(current == 'z' && c != 'z'){
                res.append("U");
                current = 'u';
            }
            res.append(findLatestPath(keyboard.get(current), keyboard.get(c)));
            res.append("!");
            current = c;
        }
        return res.toString();
    }
    
    public String findLatestPath(List<Integer> cor1, List<Integer> cor2){
        StringBuilder path = new StringBuilder();
        int row1, row2, col1, col2;
        row1 = cor1.get(0); 
        row2 = cor2.get(0); 
        col1 = cor1.get(1); 
        col2 = cor2.get(1);
        //first move horizontally to make sure it does not go
        //out of board
        if(col1 > col2){
            for(int i = 0; i < col1 - col2; i++){
                path.append("L");
            }
        }
        else if (col1 < col2){
            for(int i = 0; i < col2 - col1; i++){
                path.append("R");
            }
        }
        if(row1 > row2){
            for(int i = 0; i < row1 - row2; i++){
                path.append("U");
            }
        }
        else if (row1 < row2){
            for(int i = 0; i < row2 - row1; i++){
                path.append("D");
            }
        }
        

        return path.toString();
    }
}
