package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    private ArrayList<Nodo> listNodo = new ArrayList<>();
    
    
    // ELEMENTOS A CODIFICAR
    Laberinto laberinto;
    
    public Grafo() {
    }

    public Grafo(Laberinto laberinto) {
        this.laberinto = laberinto;
        crearGrafo(laberinto.getInicioX(), laberinto.getInicioY());              
    }
    
    private void crearGrafo(int inicioX, int inicioY) {
        Nodo nodoInicial = new Nodo(listNodo.size(), inicioX, inicioY);
        listNodo.add(nodoInicial);
        
        Nodo nodoFinal = new Nodo(listNodo.size(), laberinto.getMetaX(), laberinto.getMetaY());      
        listNodo.add(nodoFinal);
        
        recorrerLaberinto();
    }
    
    public void recorrerLaberinto() {
        int[][] laberinto = this.laberinto.getLaberinto();
        // FILAS
        for (int i = 0; i < laberinto.length; i++) {
            // COLUMNAS
            for (int j = 0; j < laberinto[i].length; j++) {
                if (laberinto[i][j] == 0) {
                    if (isNodo(i, j)) {
                        listNodo.add(new Nodo(listNodo.size(), i, j));
                    }
                }                
            }
        }
    }

    public boolean isNodo(int posicionX, int posicionY) {
        int[][] laberinto = this.laberinto.getLaberinto();
        int arriba, derecha, abajo, izquierda;

        // Intentar obtener el valor de arriba
        try {
            arriba = laberinto[posicionX][posicionY + 1];
        } catch (Exception e) {
            arriba = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de derecha
        try {
            derecha = laberinto[posicionX + 1][posicionY];
        } catch (Exception e) {
            derecha = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de abajo
        try {
            abajo = laberinto[posicionX][posicionY - 1];
        } catch (Exception e) {
            abajo = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de izquierda
        try {
            izquierda = laberinto[posicionX - 1][posicionY];
        } catch (Exception e) {
            izquierda = 1; // Si ocurre una excepción, asigna una pared
        }
        
        int numArcos = 0;
        if (arriba == 0) {
            numArcos++;
        } 
        if (derecha == 0) {
            numArcos++;
        } 
        if (abajo == 0) {
            numArcos++;
        } 
        if (izquierda == 0) {
            numArcos++;
        }
        
        if (numArcos > 2) {
            return true;
        }
        return false;
    }
 
    public void getMatrizAdyacencia() {
        
    }
    
    public void imprimirListNodos() {
        for (Nodo nodo : listNodo) {
            System.out.println(nodo.getPosicionX() + "   " +nodo.getPosicionY());
        }
    }
    
}
