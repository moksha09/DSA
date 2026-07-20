package org.example.dsa.array;

public class Main {
    public static void main(String[] args){
        Rotate2DArray rotate2DArray = new Rotate2DArray();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //rotate2DArray.rotate(matrix);

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralMatrix.spiralOrder(matrix1));



    }
}
