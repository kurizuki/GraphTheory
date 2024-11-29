package graphtheory;

import java.util.Random;

public class Calles {
    private int filas;
    private int columnas;
    private int[][] mapa;
    private Random random;

    public Calles(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        
        // Crear el mapa vacío (lleno de muros)
        mapa = new int[filas][columnas];
        random = new Random();
        
        // Inicializamos el mapa con caminos y muros
        inicializarMapa();
        
        // Mostrar el mapa
        mostrarMapa();
    }
    
    // Método para inicializar el mapa con caminos (0) y muros (1)
    public void inicializarMapa() {
        // Llenamos toda la matriz con muros (1)
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = 1;
            }
        }

        // Crear un borde de muros
        for (int i = 0; i < filas; i++) {
            mapa[i][0] = 1; // Primer columna (borde izquierdo)
            mapa[i][columnas - 1] = 1; // Última columna (borde derecho)
        }

        for (int j = 0; j < columnas; j++) {
            mapa[0][j] = 1; // Primera fila (borde superior)
            mapa[filas - 1][j] = 1; // Última fila (borde inferior)
        }

        // Generar caminos aleatorios
        generarCaminos();

        // También se pueden agregar calles fijas (si es necesario)
        // Ejemplo de calles horizontales y verticales:
        crearCallesFijas();
    }

    // Método para generar caminos aleatorios
    public void generarCaminos() {
        int cantidadDeCalles = (filas * columnas) / 4; // Aproximadamente un cuarto del mapa será caminos
        
        for (int i = 0; i < cantidadDeCalles; i++) {
            int fila = random.nextInt(filas - 2) + 1; // Asegura que la fila esté dentro del borde
            int columna = random.nextInt(columnas - 2) + 1; // Asegura que la columna esté dentro del borde
            mapa[fila][columna] = 0; // Generar camino en una posición aleatoria
        }
    }
    
    // Método para agregar algunas calles fijas (puedes personalizarlas)
    public void crearCallesFijas() {
        // Calle horizontal en la fila 2 (índice 1)
        for (int i = 0; i < mapa[1].length; i++) {
            mapa[1][i] = 0; // Camino en la fila 2
        }
        
        // Calle vertical en la columna 3 (índice 2)
        for (int i = 0; i < mapa.length; i++) {
            mapa[i][2] = 0; // Camino en la columna 3
        }

        // Otra calle horizontal en la fila 6 (índice 5)
        for (int i = 0; i < mapa[5].length; i++) {
            mapa[5][i] = 0; // Camino en la fila 6
        }
        
        // Otra calle vertical en la columna 8 (índice 7)
        for (int i = 0; i < mapa.length; i++) {
            mapa[i][7] = 0; // Camino en la columna 8
        }
    }

    // Método para mostrar el mapa de calles
    public void mostrarMapa() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] == 0) {
                    System.out.print("□ "); // '0' representa un camino
                } else {
                    System.out.print("■ "); // '1' representa un muro
                }
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    public int[][] getMapa() {
        return mapa;
    }
    
}
