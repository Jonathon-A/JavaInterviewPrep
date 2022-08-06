package removeislandsfrommatrix;

import java.util.HashMap;
import java.util.Map;

public class RemoveIslandsFromMatrix {
//Wanted output
//{
//    {1,0,0,0,0,0},
//    {0,0,0,1,1,1},
//    {0,0,0,0,1,0},
//    {1,1,0,0,1,0},
//    {1,0,0,0,0,0},
//    {1,0,0,0,0,1}
//}

    public static void main(String[] args) {

        int[][] Matrix = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
        };

        System.out.println("Input");

        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println("");
        }

        GetEdgeIslands(Matrix);

        for (int i = 1; i < Matrix.length - 1; i++) {

            for (int j = 1; j < Matrix[0].length - 1; j++) {
                if (Matrix[i][j] == 1) {
                    CheckRecursively(i, j, Matrix);
                }

            }

        }
        System.out.println("Output");
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                if (Matrix[i][j] == 1) {
                    Matrix[i][j] = 0;
                } else if (Matrix[i][j] == 2) {
                    Matrix[i][j] = 1;
                }
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println("");
        }

        int[][] Matrix2 = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 1, 0},
            {1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
        };

        System.out.println("\nInput");

        for (int i = 0; i < Matrix2.length; i++) {
            for (int j = 0; j < Matrix2[0].length; j++) {
                System.out.print(Matrix2[i][j] + " ");
            }
            System.out.println("");
        }

        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < Matrix2.length; i++) {
            for (int j = 0; j < Matrix2[0].length; j++) {
                if (Matrix2[i][j] == 1) {
                    if (visited.get(i + " " + j) == null) {
                        count++;
                        LandCount = 1;
                        DFS(Matrix2, i, j);
                        if (LandCount > max) {
                            max = LandCount;
                        }
                        if (LandCount < min) {
                            min = LandCount;
                        }
                    }
                }
            }

        }
        System.out.println("Output:");
        System.out.println("Island count:            " + count);
        System.out.println("Smallest island size:    " + min);
        System.out.println("Largest island size:     " + max);

    }

    private static int LandCount = 0;

    private static Map<String, Integer> visited = new HashMap<>();

    private static void DFS(int[][] Matrix, int i, int j) {
        visited.put(i + " " + j, 0);
        
        if (i + 1 < Matrix.length && Matrix[i + 1][j] == 1 && visited.get((i + 1) + " " + j) == null) {
            LandCount++;
            DFS(Matrix, i + 1, j);

        }
        if (i - 1 >= 0 && Matrix[i - 1][j] == 1 && visited.get((i - 1) + " " + j) == null) {
            LandCount++;
            DFS(Matrix, i - 1, j);
        }

        if (j - 1 >= 0 && Matrix[i][j - 1] == 1 && visited.get(i + " " + (j - 1)) == null) {
            LandCount++;
            DFS(Matrix, i, j - 1);
        }

        if (j + 1 < Matrix[0].length && Matrix[i][j + 1] == 1 && visited.get(i + " " + (j + 1)) == null) {
            LandCount++;
            DFS(Matrix, i, j + 1);
        }

    }

    private static void GetEdgeIslands(int[][] Matrix) {
        for (int i = 0; i < Matrix[0].length; i++) {
            if (Matrix[0][i] == 1) {
                Matrix[0][i] = 2;
            }
        }

        for (int i = 0; i < Matrix[0].length; i++) {
            if (Matrix[Matrix.length - 1][i] == 1) {
                Matrix[Matrix.length - 1][i] = 2;
            }
        }

        for (int i = 0; i < Matrix.length; i++) {
            if (Matrix[i][0] == 1) {
                Matrix[i][0] = 2;
            }
        }

        for (int i = 0; i < Matrix.length; i++) {
            if (Matrix[i][Matrix.length - 1] == 1) {
                Matrix[i][Matrix.length - 1] = 2;
            }
        }
    }

    private static void CheckRecursively(int i, int j, int[][] Matrix) {

        if (Matrix[i - 1][j] == 2) {
            Matrix[i][j] = 2;
        }
        if (Matrix[i + 1][j] == 2) {
            Matrix[i][j] = 2;
        }
        if (Matrix[i][j - 1] == 2) {
            Matrix[i][j] = 2;
        }
        if (Matrix[i][j + 1] == 2) {
            Matrix[i][j] = 2;
        }

        if (Matrix[i][j] == 2) {
            if (Matrix[i - 1][j] == 1) {
                CheckRecursively(i - 1, j, Matrix);
            }
            if (Matrix[i + 1][j] == 1) {
                CheckRecursively(i + 1, j, Matrix);
            }
            if (Matrix[i][j - 1] == 1) {
                CheckRecursively(i, j - 1, Matrix);
            }
            if (Matrix[i][j + 1] == 1) {
                CheckRecursively(i, j + 1, Matrix);
            }
        }

    }

}
