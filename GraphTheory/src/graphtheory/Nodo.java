package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Nodo {
    private ArrayList<Arco> listArco = new ArrayList<>();
    private int nodoID;
    
    // PROPIEDADES DE LO QUE CONTENDRA EL NODO
    private int posicionX;
    private int posicionY;

    public Nodo() {
    }

    public Nodo(int nodoID, int posicionX, int posicionY) {
        this.nodoID = nodoID;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public int getNodoID() {
        return nodoID;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }  

    public ArrayList<Arco> getListArco() {
        return listArco;
    }

    public boolean addArco(Arco arco) {        
        return listArco.add(arco);
    }
    
    public static boolean equals(Nodo nodo1, Nodo nodo2) {
        if (nodo1.getPosicionX() == nodo2.getPosicionX() && nodo1.getPosicionY() == nodo2.getPosicionY()) {
            return true;
        }
        return false;
    }
    
    public static boolean equals(Nodo nodo, int posicionX, int posicionY) {
        if (posicionX == nodo.posicionX && posicionY == nodo.posicionY) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nodo{" + "listArco=" + listArco + ", nodoID=" + nodoID + ", posicionX=" + posicionX + ", posicionY=" + posicionY + '}';
    }
}
