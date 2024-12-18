package graphtheory;

import java.util.Random;

/**
 *
 * @author L
 */
public final class Laberinto {
    private final Random random = new Random();    
    private final int MURO = 1;
    private final int CAMINO = 0;
    private final int META = 2;
    private int filas;  // Debe ser impar
    private int columnas;  // Debe ser impar
    private int[][] laberinto;
    
    // Comenzar desde una posición inicial
    private int inicioX = 1;
    private int inicioY = 1;
    
    private int metaX;
    private int metaY;

    public Laberinto() {
    }
    
    public Laberinto(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.laberinto = new int[filas][columnas];
        crearLaberinto();
        
        // ASIGNAMOS UNA META 
        asignarMeta();
    }

    public int[][] getLaberinto() {
        return laberinto;
    }
  
    public int getInicioX() {
        return inicioX;
    }

    public int getInicioY() {
        return inicioY;
    }

    public int getMetaX() {
        return metaX;
    }

    public int getMetaY() {
        return metaY;
    }
    
    private void crearLaberinto() {
        // Inicializar el laberinto con muros
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                laberinto[i][j] = MURO;
            }
        }
        
        laberinto[inicioX][inicioY] = CAMINO;

        // Generar el laberinto
        generarCaminos(inicioX, inicioY);
    }

    private void generarCaminos(int x, int y) {
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
            if (nuevoX > 0 && nuevoX < laberinto.length  && nuevoY > 0 && nuevoY < laberinto[0].length ) {
                if (laberinto[nuevoX][nuevoY] == MURO) {
                    // Crear un camino entre la posición actual y la nueva posición
                    laberinto[x + dir[0] / 2][y + dir[1] / 2] = CAMINO;
                    laberinto[nuevoX][nuevoY] = CAMINO;

                    // Llamada recursiva
                    generarCaminos(nuevoX, nuevoY);
                }
            }
        }
    }
    
    public void asignarMeta() {
        metaX = random.nextInt(filas -2) + 1;
        metaY = random.nextInt(columnas -2) + 1;

        laberinto[metaY][metaX] = 0;                
    }
     
    public void imprimirLaberinto() {
        // □
        // FILAS 
        for (int i = laberinto.length-1; i >= 0; i--) {
            // COLUMNAS
            if (i < 10) {
                System.out.print(i + "  ");
            } else {
                System.out.print(i + " ");
            }
                 
            for (int j = 0; j < laberinto[i].length; j++) {
                //█
                switch (laberinto[i][j]) {
                    case MURO:
                        System.out.print("■" + j);
                        break;
                    case CAMINO:
                        System.out.print("□" + j);
                        break;
                    case META:
                        System.out.print("M ");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }
    
    public void imprimirMatriz() {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                System.out.println(laberinto[i][j]);
            }
        }
    }  
    
}
