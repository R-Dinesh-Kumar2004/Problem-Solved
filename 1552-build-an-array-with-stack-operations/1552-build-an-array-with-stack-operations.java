class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> operations = new ArrayList<>();
        int st[] = new int[n];
        int top = -1,idx = 0;

        for(int i=1;i<=n && idx < len;i++){
            st[++top] = i;
            operations.add("Push");

            if(target[idx] == st[top]){
                idx++;
            }
            else{
                top--;
                operations.add("Pop");
            }
        }

        return operations;
    }
}