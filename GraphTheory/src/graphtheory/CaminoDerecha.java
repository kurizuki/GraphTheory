package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class CaminoDerecha {
    private ArrayList<Nodo> listNodo;
    private ArrayList<Nodo> listNodosVisitados = new ArrayList<>();
    private ArrayList<ArrayList<Nodo>> caminosPosibles = new  ArrayList<>();
    private int metaX, metaY;
    private int inicioX, inicioY;

    public CaminoDerecha() {
    }

    public CaminoDerecha(ArrayList<Nodo> listNodo, int metaX, int metaY, int inicioX, int inicioY) {
        this.listNodo = listNodo;
        this.metaX = metaX;
        this.metaY = metaY;
        this.inicioX = inicioX;
        this.inicioY = inicioY;
        
        buscarCaminoCorto(listNodo.getFirst());
    }
    
    private int numVisted = 0;
    private void buscarCaminoCorto(Nodo nodo) {
        if (isNodoVisited(nodo)) {
            numVisted++;
        } else {
            numVisted = 0;
        }
        if (numVisted==2) {
            numVisted = 0;
            return;
        }
        
        listNodosVisitados.add(nodo);
        int posicionX = nodo.getPosicionX();
        int posicionY = nodo.getPosicionY();
        
        if (metaX == posicionX && metaY == posicionY) {
            caminosPosibles.add(listNodosVisitados);
            return;
        } 
        
        ArrayList<Arco> arcoList = nodo.getListArco();
        
        Nodo nodoDerecho = null;
        Nodo nodoIzquierdo = null;
        Nodo nodoArriba = null;
        
        for (Arco arco : arcoList) {
            Nodo nodoArco = arco.getNodo();
            // SI EL NODO ESTA A LA DERECHA
            if (posicionX < nodoArco.getPosicionX()) {
                nodoDerecho = nodoArco;
                System.out.println("DERECJO");
                continue;
            }
            // SI EL NODO ESTA ARRIBA          
            if (posicionY < nodoArco.getPosicionY()) {
                nodoArriba = nodoArco;
                System.out.println("ARRIBA");
                continue;
            }
            // SI EL NODO ESTA A LA IZQUIERDA            
            if (posicionX > nodoArco.getPosicionX()) {
                nodoIzquierdo = nodoArco;
                System.out.println("IZQUIERDA");
            }  
        }     
        
        // ORDEN DE PRIORIDADES
        buscarCaminoCorto(nodoArriba);
        buscarCaminoCorto(nodoDerecho);
        buscarCaminoCorto(nodoIzquierdo);
    }
    
    private void marcaDireccion() {
        
    }
    
    private boolean isNodoVisited(Nodo nodo) {
        for (Nodo nodoVisited : listNodosVisitados) {
            if (nodoVisited.getPosicionX() == nodo.getPosicionX() && nodoVisited.getPosicionY() == nodo.getPosicionY()) {
                return true;
            }
        }
        return false;
    }
}
