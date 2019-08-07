import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEquality {
    public static void main(String[] args){
        int testCase=0;
        int arraySize=0;
        ArrayList<int[]> allInput= new ArrayList<>();
        int[] input;
        Scanner scan = new Scanner(System.in);
        testCase=scan.nextInt();
        arraySize=scan.nextInt();
        input=new int[arraySize];
        for(int i=0;i<testCase;i++){
            for(int k=0;k<2;k++){
                for(int j=0;j<arraySize;j++){
                    input[j]=scan.nextInt();
                }
                allInput.add(input);
            }
        }
        int j=0;
        for(int i=0;i<testCase;i++){
            checkEquality(allInput.get(j),allInput.get(j+1));
            j+=2;
        }
    }

    private static void checkEquality(int[] array1, int[] array2) {
        ArrayList<Integer> list1=new ArrayList<Integer>();
        for(int num:array1){System.out.print("-"+num);
            list1.add(num);
        }
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i));
        }

    }
}
