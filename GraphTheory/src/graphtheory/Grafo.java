package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    private int numNodos = 0;
    private ArrayList<Nodo> listNodo;
    
    public Grafo() {
        listNodo = new ArrayList<>();
    }

    public void setNodo(Nodo nodo) {
        if (listNodo.add(nodo)) {
            numNodos++;
        } else {
            System.out.println("ERROR AL AGREGAR EL NODO");
        }
    }
 
    public void getMatrizAdyacencia() {
        
    }
    
}
