class Solution {
public:
    struct Compare{
        bool operator()(int sub1, int sub2){
            return sub1 > sub2;
        }
    };
    
    int minRefuelStops(int target, int startFuel, vector<vector<int>>& stations) {
        priority_queue<int> passedStation;
        int traveled = 0;
        int tank = startFuel;
        int stop = 0;
        int i = 0;
        while(i < stations.size()){
            tank -= stations[i][0] - (i > 0 ? stations[i-1][0] : 0);
            //if tank can't make it to next stop
            while(tank < 0){
                //refill tank with station has most fuel traveled
                if(passedStation.size() == 0) return -1;
                int topStation = passedStation.top();
                passedStation.pop();
                tank+=topStation;
                stop+=1;
            }
            passedStation.push(stations[i][1]);
            if(i == stations.size()-1) traveled = stations[i][0];
            i+=1;
        }
        while(traveled + tank < target){
            if(passedStation.size() == 0) return -1;
            int topStation = passedStation.top();
            passedStation.pop();
            tank+=topStation;
            stop+=1;
        }
        return stop;
    }
};
