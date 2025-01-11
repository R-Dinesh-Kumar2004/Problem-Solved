class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        // quicksort(costs,0,n-1);
        Arrays.sort(costs);
        int count=0,sum=0;
        for(int i=0;i<n;i++){
            if(sum+costs[i]<=coins){
                sum+=costs[i];
                count++;
            }
            else break;
        }

        return count;
    }
    public static void quicksort(int arr[],int low,int high){
        if(low<high){
            int p = Partition(arr,low,high);
            quicksort(arr,low,p-1);
            quicksort(arr,p+1,high);
        }
    }
    public static int Partition(int arr[],int low,int high){
        int pi=arr[low];
        int i=low,j=high;

        while(i<=j){
            while(i<=high && arr[i]<=pi) i++;
            while(j>=low && arr[j]>pi) j--;

            if(i<j) swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void swap(int arr[],int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}