package graphtheory;

/**
 *
 * @author L
 */
public class Arco {
    private float peso;
    private int nodoID;

    public Arco() {
    }

    public Arco(float peso, int nodoID) {
        this.peso = peso;
        this.nodoID = nodoID;
    }

    public float getPeso() {
        return peso;
    }

    public int getNodoID() {
        return nodoID;
    }
  
}
