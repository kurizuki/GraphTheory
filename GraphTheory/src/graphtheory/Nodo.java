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

}
