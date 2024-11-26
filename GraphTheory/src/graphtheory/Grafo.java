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
        das(laberinto);
    }
    
    private void das(int[][] laberinto) {
        for (int i = 0; i < 10; i++) {
            
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
