class Solution {
    private static  int st[];
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        st = new int[4*n];
        buildSeg(0,0,n-1,words);

        int ans[] = new int[queries.length];
        int i=0;
        for(int q[]:queries){
            ans[i++]=query(0,0,n-1,q[0],q[1]);
        }
        return ans;
    }
    public static void buildSeg(int i,int low,int high,String words[]){
        if(low==high){
            st[i]=isValid(words[low]);
            return;
        }
        int mid=(low+high)/2;
        buildSeg(2*i+1,low,mid,words);
        buildSeg(2*i+2,mid+1,high,words);

        st[i]=st[2*i+1]+st[2*i+2];
    }

    public static int isValid(String s){
        int n=s.length();
        if(isVowel(s.charAt(0)) && isVowel(s.charAt(n-1))) return 1;
        return 0;
    } 

    public static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static int query(int i,int low,int high,int l,int r){
        if(low>=l && r>=high) return st[i];
        if(low>r || high<l) return 0;
        int mid=(low+high)/2;
        int left=query(2*i+1,low,mid,l,r);
        int right=query(2*i+2,mid+1,high,l,r);

        return left+right;
    }
}