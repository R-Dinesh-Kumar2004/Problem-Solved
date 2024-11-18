class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<String> li=new ArrayList<>();
        Arrays.sort(arr);
        permute(0,arr,li);
        if(li.size()==0)return "";        
        String max="";
        for(String s:li){
            if(s.compareTo(max)>0){
                max=s;
            }
        }
        StringBuffer sb=new StringBuffer(max);
        sb.insert(2,':');
        return sb.toString();
    }
    public void permute(int i,int arr[],List<String> li){
        if(i==4){
            int hour=arr[0]*10+arr[1];
            int min=arr[2]*10+arr[3];
            if(hour<24 && min<60)li.add(""+arr[0]+arr[1]+arr[2]+arr[3]);
            return;
        }
        for(int j=i;j<4;j++){
            if(j>i && arr[j]==arr[j-1])continue;
            swap(arr,i,j);
            permute(i+1,arr,li);
            swap(arr,i,j);
        }
    }
    public void swap(int arr[], int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}