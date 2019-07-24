public class LargeSumSubarray {
//Find the subarray of largest contiguous sum
    public static void  main(String[] args){
        int[] arrayInput={1,2,-2,-2};
        findLargeSum(arrayInput,arrayInput.length);
    }
    private static void findLargeSum(int[] arrayInput, int length) {
        int newMax=0,max=Integer.MIN_VALUE,startIndex=0,endIndex=0,tmp=0;
        for(int i=0;i<length;i++){
            newMax+=arrayInput[i];
            if(newMax>max){
                max=newMax;
                startIndex=tmp;
                endIndex=i;
            }
            if(newMax<0){
                newMax=0;
                tmp+=1;
            }
        }
        System.out.println("Start Index: "+startIndex+", End Index: "+endIndex+", with Maximum value: "+max);
    }
}
