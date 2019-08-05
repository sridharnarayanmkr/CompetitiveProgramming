import java.util.*;
/*
This Program is to convert decimal to binary and find the count of substring which contains odd number of 0's and 1's.
Line 1: Number of test cases
From Line 2: decimal input values
 */
class BinaryCount{
    public static void main(String[] args){
        String tmpNum;int num;
        List<String> list = new ArrayList<>();
        Scanner intScan = new Scanner(System.in);
        tmpNum= intScan.nextLine();
        num=Integer.parseInt(tmpNum);
        for(int i=0;i<num;i++){
            String temp=intScan.nextLine();
            list.add(temp);
        }
        processList(list);
    }
    public static void processList(List<String> list) {
        List<String> binaryValues = new ArrayList<>();int oneCount=0,zeroCount=0;
        String subString = new String();
        for(int i=0;i<list.size();i++){
            binaryValues.add(computeBinary(list.get(i)));
        }
        for(int i=0;i<binaryValues.size();i++){

            for(int m =0;m<binaryValues.get(i).length();m++){
                for(int n=m+1;n<=binaryValues.get(i).length();n++){
                    subString=binaryValues.get(i).substring(m,n);
                    if((subString.chars().filter(c->c=='1').count())%2!=0){
                        oneCount++;
                    } if((subString.chars().filter(c->c=='0').count())%2!=0){
                        zeroCount++;
                    }
                }
            }
            System.out.println(zeroCount+" "+oneCount);
            zeroCount=oneCount=0;
        }
    }
    public static String computeBinary(String num) {
        String outputBinary;
        if(num.equals("0")){
            outputBinary="0";
        }else{
            outputBinary="";
            while(!num.equals("0")){
                outputBinary=oddCheck(num)+""+outputBinary;
                num=binaryConvert(num);
            }
        }
        return outputBinary;
    }
    public static String binaryConvert(String num) {
        String newString=new String();int add =0,digitValue;
        for(int i=0;i<num.length();i++){
            digitValue=(num.charAt(i)-'0')/2+add;
            newString=newString+""+digitValue;
            add=oddCheck(""+num.charAt(i))*5;
        }
        if(!newString.equals("0") && newString.startsWith("0")){
            newString=newString.substring(1);
        }
        return newString;
    }
    public static int oddCheck(String num) {
        if(num.endsWith("1")||num.endsWith("3")||num.endsWith("5")||num.endsWith("7")||num.endsWith("9")){
            return 1;
        }
        return 0;
    }
}
