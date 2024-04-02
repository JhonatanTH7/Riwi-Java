package Utilities;

public class ImprimirMatrices {
    public static void imprimirMatrizDouble(double[][] matriz) {
        System.out.println(" ");
        for (double[] fila : matriz) {
            for (double columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void imprimirMatrizInt(int[][] matriz) {
        System.out.println(" ");
        for (int[] fila : matriz) {
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void imprimirMatrizString(String[][] matriz) {
        System.out.println(" ");
        for (String[] fila : matriz) {
            for (String columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void imprimirMatrizBoolean(boolean[][] matriz) {
        System.out.println(" ");
        for (boolean[] fila : matriz) {
            for (boolean columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
