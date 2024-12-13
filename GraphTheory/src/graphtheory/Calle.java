package graphtheory;

import java.util.Random;

/**
 *
 * @author L
 */
public class Calle {
    Random random = new Random();
    int[][] matriz;

    public Calle(int tamaño) {
        tamaño*=5;
        tamaño+=2;
        matriz = new int[tamaño][tamaño];
        generarCalles();
    }

    public int[][] getMatriz() {
        return matriz;
    }

    private void generarCalles() {
        for (int i = 2; i < matriz.length-2; i++) {
            for (int j = 2; j < matriz[i].length; j++) {
                j++;
                matriz[i][j] = 1;
                j++;
                matriz[i][j] = 1;
                j++;
                matriz[i][j] = 1;                
            }
        }
    }
    
    public void imprimir() {
        for (int i = 0; i < matriz.length; i++) {  // Recorremos las filas
            for (int j = 0; j < matriz[i].length; j++) {  // Recorremos las columnas
                System.out.print(matriz[i][j] + " ");  // Imprimimos cada valor de la matriz
            }
            System.out.println();  // Nueva línea al final de cada fila
        }
    }

}
