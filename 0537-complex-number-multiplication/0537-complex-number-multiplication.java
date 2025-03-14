class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        num1 = num1.replace("i","");
        num2 = num2.replace("i","");

        String arr1[] = num1.split("\\+");
        String arr2[] = num2.split("\\+");

        int a = Integer.parseInt(arr1[0]);
        int b = Integer.parseInt(arr1[1]);
        int c = Integer.parseInt(arr2[0]);
        int d = Integer.parseInt(arr2[1]);

        int real = a*c - b*d;
        int com = a*d + b*c;

        StringBuffer sb = new StringBuffer();
        sb.append(real).append("+").append(com).append("i");

        return sb.toString();
    }
}