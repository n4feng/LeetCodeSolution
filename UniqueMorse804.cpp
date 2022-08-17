class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        char* morseCode[26] = {".-","-...","-.-.","-..",".",
                               "..-.","--.","....","..",".---",
                               "-.-",".-..","--","-.","---",
                               ".--.","--.-",".-.","...","-",
                               "..-","...-",".--","-..-","-.--","--.."};
        unordered_set<string> uniqueTrans;
        for(string word : words){
            stringstream morse;
            for(char c : word){
                morse << morseCode[c-'a'];
            }
            string trans = morse.str();
            if(uniqueTrans.find(trans) == uniqueTrans.end()){
                uniqueTrans.insert(trans);
            }
        }
        return uniqueTrans.size();
    }
};
