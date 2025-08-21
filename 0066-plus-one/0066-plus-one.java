class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> li=new ArrayList<>();
        int carry=0,i=0,sum=1;
        for(i=digits.length-1;i>=0;i--){
           sum+=digits[i]+carry;
           carry=sum/10;
           li.add(sum%10);
           sum=0;
        }
        if(carry!=0){
            li.add(carry);
        }
        i=0;
        int ans[]=new int[li.size()];
        for(int j=li.size()-1;j>=0;j--){
            ans[i++]=li.get(j);
        }
        return ans;
    }
}