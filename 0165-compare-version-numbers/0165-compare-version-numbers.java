class Solution {
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("[.]");
        String s2[] = version2.split("[.]");
        int n = Math.max(s1.length,s2.length);

        for(int i=0;i<n;i++){
            int v1 = 0,v2 = 0;
            if(i<s1.length){
                v1 = Integer.parseInt(s1[i]);
            }
            if(i<s2.length){
                v2 = Integer.parseInt(s2[i]);
            }
            if(v1<v2) return -1;
            else if(v2<v1) return 1;
            // System.out.println(v1+" "+v2);
        }
        return 0;
    }
}