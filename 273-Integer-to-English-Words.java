class Solution {
    String one[]={\\,\ One\,\ Two\,\ Three\,\ Four\,\ Five\,\ Six\,\ Seven\,\ Eight\,\ Nine\,\ Ten\,\ Eleven\,\ Twelve\,\ Thirteen\,\ Fourteen\,\ Fifteen\,\ Sixteen\,\ Seventeen\,\ Eighteen\,\ Nineteen\,\\};
    String ten[]={\\,\\,\ Twenty\,\ Thirty\,\ Forty\,\ Fifty\,\ Sixty\,\ Seventy\,\ Eighty\,\ Ninety\};

    public String numberToWords(int num) {
        if(num==0)return \Zero\;
        return find(num).trim();
    }
    public String find(int n){
       StringBuffer sb=new StringBuffer();

       if(n<20) sb.append(one[n]);
       else if(n<100) sb.append(ten[n/10]).append(find(n%10));
       else if(n<1000)sb.append(find(n/100)).append(\ Hundred\).append(find(n%100));
       else if(n<1000000)sb.append(find(n/1000)).append(\ Thousand\).append(find(n%1000));
       else if(n<1000000000) sb.append(find(n/1000000)).append(\ Million\).append(find(n%1000000));
       else sb.append(find(n/1000000000)).append(\ Billion\).append(find(n%1000000000));

       return sb.toString();
    }
}