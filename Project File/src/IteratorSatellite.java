import java.util.*;
public class IteratorSatellite implements Iterator<Integer> {
    private int size;
    private int column;
    private int row;
    Integer[] array2D;
    private int count;

    public  IteratorSatellite(int[][] list) {
        column = list[0].length;
        row = list.length;
        size = column*row;
        array2D = new Integer[size];
        count = 0;
    }
    private void print(){
        for(int i =0; i<size; i++){
            System.out.print(array2D[i]+" ");
        }
    }
    /*these helper functions missions is eliminating loops within the Gokturk3 function*/
    private int helper1(int i,int t, int rowS,int a[][]){
        if(i>=column) return t;
        else{
            array2D[t] = a[rowS][i];
            t++;
            i++;
        }return helper1(i,t,rowS,a);
    }
    private int helper2(int i,int t,int a[][]){
        if(i>=row) return t;
        else{
            array2D[t]=a[i][column-1];
            t++;
            i++;
        }
        return helper2(i,t,a);
    }
    private int helper3(int i, int colS,int t, int a[][]){
        if(i<colS) return t;
        else{
            array2D[t]=a[row-1][i];
            t++;
            i--;
        }
        return helper3(i,colS,t,a);
    }
    private int helper4(int i,int rowS,int colS,int t, int a[][]){
        if(i<rowS) return t;
        else{
            array2D[t]=a[i][colS];
            t++;
            i--;
        }
        return helper4(i,rowS,colS,t,a);
    }


    public void wrapper(int arr[][]){
        Gokturk3(0,0,0,0,arr);
    }
    public int Gokturk3(int i, int t,int rowS,int colS, int a[][]) {
        if(rowS >=row && colS>=column && t==size){
            return 0;
        }
        else{
            t=helper1(colS,t,rowS,a);
            rowS++;
            t=helper2(rowS,t,a);
            column--;
            if (rowS < row) {
                t=helper3(column-1,colS,t,a);
                row--;
            }

            if (colS < column) {
                t = helper4(row-1,rowS,colS,t,a);
                colS++;
            }
        }
        return Gokturk3(i,t,rowS,colS,a);
    }

    @Override
    public boolean hasNext() {
        if(count<size){
            count++;
            return true;
        }
        count++;
            return false;
    }
    @Override
    public Integer next() {
        int data = array2D[count-1];
        return data;
    }
}
