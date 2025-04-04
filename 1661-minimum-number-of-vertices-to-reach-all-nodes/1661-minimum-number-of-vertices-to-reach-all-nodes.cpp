class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<int> ans;
        vector<int> indeg(n,0);
        
        for(auto& it:edges){
            int d = it[1];
            indeg[d]++;
        }

        for(int i=0;i<n;i++){
            if(indeg[i] == 0) ans.push_back(i);
        }
        return ans;
    }
};