class MyCalendar {
public:
    MyCalendar() {
        pair<int,int> dummy(0,0);
        calendar.push_back(dummy);
    }
    
    bool book(int start, int end) {
        int l = 0;
        int r = calendar.size()-1;
        //binary search find the left boundry the first left boundry
        //that is smaller than items
        while(l < r){
            int mid = l + (r - l + 1) / 2;
            if(calendar[mid].first == start){
                if(calendar[mid].second > start){
                    return false;
                }
                else{
                    calendar[mid].second = end;
                    return true;
                }
            }
            else if(calendar[mid].first > start){
                r = mid - 1;
            }
            else{
                l = mid;
            }
        }
        
        if(calendar[l].second <= start){
            if(l+1 < calendar.size()){
                if(calendar[l+1].first < end){
                    return false;
                }
            }
            pair<int,int> booked(start, end);
            calendar.insert(calendar.begin()+l+1, booked);
            return true;
        }
        else{
            return false;
        }
    }
private: 
    vector<pair<int, int>> calendar;
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */
