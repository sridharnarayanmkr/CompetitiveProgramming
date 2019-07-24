import java.util.Arrays;
import java.util.Vector;
//Find a path from (0,0) to (m-1,n-1)
public class MatrixTraverse {
    public static void main(String[] args){
        int[][] array={ { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        findPath(array,array.length);
    }

    private static void findPath(int[][] array, int n) {
        Vector<String> possible=new Vector<>();
        StringBuilder path=new StringBuilder();
        boolean visited[][]=new boolean[n][n];
        //Arrays.fill(visited,false);
        printPathUtil(0,0,array,n,possible,path,visited);
        for(String val:possible){
            System.out.println(val);
        }
    }

    private static void printPathUtil(int row, int col, int[][] array, int n, Vector<String> possible, StringBuilder path, boolean[][] visited) {
        if(row==-1||row==n||col==-1||col==n||visited[row][col]||array[row][col]==0)
            return;
        if(row==n-1&&col==n-1){
            possible.add(path.toString());
            return;
        }
        visited[row][col]=true;

        if(isSafe(row,col+1,array,n,visited)){
            path.append("R");
            printPathUtil(row,col+1,array,n,possible,path,visited);
            path.deleteCharAt(path.length()-1);

        }
        if(isSafe(row+1,col,array,n,visited)){
            path.append("D");
            printPathUtil(row+1,col,array,n,possible,path,visited);
            path.deleteCharAt(path.length()-1);
        }
        if(isSafe(row,col-1,array,n,visited)){
            path.append("L");
            printPathUtil(row,col-1,array,n,possible,path,visited);
            path.deleteCharAt(path.length()-1);
        }
        if(isSafe(row-1,col+1,array,n,visited)){
            path.append("U");
            printPathUtil(row-1,col,array,n,possible,path,visited);
            path.deleteCharAt(path.length()-1);
        }
        visited[row][col]=false;
    }
    private static boolean isSafe(int row, int col, int[][] array,int n,boolean visited[][]){

        if(row==-1||row==n||col==-1||col==n||visited[row][col]||array[row][col]==0)
            return false;
        return true;
    }
}
