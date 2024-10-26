package graphtheory;

import java.util.Random;

/**
 *
 * @author L
 */
public class NewMain {
    private static final int MURO = 1;
    private static final int CAMINO = 0;
    private static final int FILAS = 21;  // Debe ser impar
    private static final int COLUMNAS = 21;  // Debe ser impar
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[][] laberinto = new int[FILAS][COLUMNAS];
        crearLaberinto(laberinto);
        mostrarLaberinto(laberinto);
    }

    private static void crearLaberinto(int[][] laberinto) {
        // Inicializar el laberinto con muros
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                laberinto[i][j] = MURO;
            }
        }

        // Comenzar desde una posición inicial
        int inicioX = 1;
        int inicioY = 1;
        laberinto[inicioX][inicioY] = CAMINO;

        // Generar el laberinto
        generarCaminos(laberinto, inicioX, inicioY);
    }

    private static void generarCaminos(int[][] laberinto, int x, int y) {
        // Direcciones posibles: [x, y] -> [abajo, arriba, derecha, izquierda]
        int[][] direcciones = {
            {2, 0},  // Abajo
            {-2, 0}, // Arriba
            {0, 2},  // Derecha
            {0, -2}  // Izquierda
        };

        // Mezclar las direcciones
        for (int i = 0; i < direcciones.length; i++) {
            int j = random.nextInt(direcciones.length);
            int[] temp = direcciones[i];
            direcciones[i] = direcciones[j];
            direcciones[j] = temp;
        }

        // Recorrer las direcciones
        for (int[] dir : direcciones) {
            int nuevoX = x + dir[0];
            int nuevoY = y + dir[1];

            // Verificar si la nueva posición está dentro de los límites
            if (nuevoX > 0 && nuevoX < laberinto.length - 1 && nuevoY > 0 && nuevoY < laberinto[0].length - 1) {
                if (laberinto[nuevoX][nuevoY] == MURO) {
                    // Crear un camino entre la posición actual y la nueva posición
                    laberinto[x + dir[0] / 2][y + dir[1] / 2] = CAMINO;
                    laberinto[nuevoX][nuevoY] = CAMINO;

                    // Llamada recursiva
                    generarCaminos(laberinto, nuevoX, nuevoY);
                }
            }
        }
    }

    private static void mostrarLaberinto(int[][] laberinto) {
        for (int[] fila : laberinto) {
            for (int celda : fila) {
                System.out.print(celda == MURO ? "■" : "□");
            }
            System.out.println();
        }
    }
}
