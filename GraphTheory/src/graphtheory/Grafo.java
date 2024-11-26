package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    private int numNodos = 0;
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
        Nodo nodoInicial = new Nodo(numNodos, inicioX, inicioY);
        isNodo(laberinto.getInicioX(), laberinto.getInicioY());
        
    }

    public boolean isNodo(int posicionX, int posicionY) {
        int arriba, derecha, abajo, izquierda;

        // Intentar obtener el valor de arriba
        try {
            arriba = laberinto.getMatrizLaberinto()[posicionX][posicionY + 1];
        } catch (Exception e) {
            arriba = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de derecha
        try {
            derecha = laberinto.getMatrizLaberinto()[posicionX + 1][posicionY];
        } catch (Exception e) {
            derecha = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de abajo
        try {
            abajo = laberinto.getMatrizLaberinto()[posicionX][posicionY - 1];
        } catch (Exception e) {
            abajo = 1; // Si ocurre una excepción, asigna una pared
        }

        // Intentar obtener el valor de izquierda
        try {
            izquierda = laberinto.getMatrizLaberinto()[posicionX - 1][posicionY];
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

    private void addNodo(Nodo nodo) {
        if (listNodo.add(nodo)) {
            numNodos++;
        } else {
            System.out.println("ERROR AL AGREGAR EL NODO");
        }
    }
 
    public void getMatrizAdyacencia() {
        
    }
    
}
