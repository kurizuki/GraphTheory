package graphtheory;

/**
 *
 * @author L
 */
public class Arco {
    private float peso;
    private Nodo nodo;

    public Arco() {
    }

    public Arco(Nodo nodo) {
        this.peso = 1;
        this.nodo = nodo;
    }
    
    public Arco(Nodo nodo, float peso) {
        this.peso = peso;
        this.nodo = nodo;
    }

    public float getPeso() {
        return peso;
    }

    public Nodo getNodo() {
        return nodo;
    }

}
