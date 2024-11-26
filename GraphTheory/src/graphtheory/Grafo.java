package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    private int numNodos = 0;
    private ArrayList<Nodo> listNodo = new ArrayList<>();
    
    public Grafo(int[][] laberinto) {
        identificacionNodos(laberinto);
    }
    
    private void identificacionNodos(int[][] laberinto) {
        // FILAS
        for (int i = 1; i < laberinto.length-1; i++) {
            // COLUMNAS
            for (int j = 1; j < laberinto[i].length-1; j++) {
                
            }
        }
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
