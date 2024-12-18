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
    
    private int caminoPosibles=0;

    public CaminoDerecha() {
    }

    public CaminoDerecha(ArrayList<Nodo> listNodo, int metaX, int metaY, int inicioX, int inicioY) {
        this.listNodo = listNodo;
        this.metaX = metaX;
        this.metaY = metaY;
        this.inicioX = inicioX;
        this.inicioY = inicioY;
        
        buscarCaminoCorto(listNodo.getFirst());
        imprimirLista();
    }
    
    private int numVisted = 0;
    private void buscarCaminoCorto(Nodo nodo) {
        if (isNodoVisited(nodo)) {
            numVisted++;
        } else {
            numVisted = 0;
        }
        if (numVisted==2) {
            System.out.println("HUY NO MI CHAMO");
            numVisted = 0;            
            return;
        }
        
        listNodosVisitados.add(nodo);
        int posicionX = nodo.getPosicionX();
        int posicionY = nodo.getPosicionY();
        
        if (metaX == posicionX && metaY == posicionY) {
            ArrayList<Nodo> auxiliar = new ArrayList<>(listNodosVisitados);
            caminosPosibles.add(auxiliar);
            return;
        } 
        
        ArrayList<Arco> arcoList = nodo.getListArco();
        
        Nodo nodoDerecho = null;
        Nodo nodoIzquierdo = null;
        Nodo nodoFrente = null;
        
        for (Arco arco : arcoList) {
            Nodo nodoOfArco = arco.getNodo();   
            String direccion = "";
            if (listNodosVisitados.size() >= 2) {
                direccion = Nodo.getDireccionEntreNodos(listNodosVisitados.get(listNodosVisitados.size()-2), nodo);                
            } else {
                direccion = Nodo.getDireccionEntreNodos(nodo, nodoOfArco);
            }
            
            switch (direccion) {
                case "Norte" -> {
                    // SI EL NODO ESTA A LA DERECHA
                    if (posicionX < nodoOfArco.getPosicionX()) {
                        nodoDerecho = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA AL FRENTE            
                    if (posicionY < nodoOfArco.getPosicionY()) {
                        nodoFrente = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA A LA IZQUIERDA            
                    if (posicionX > nodoOfArco.getPosicionX()) {
                        nodoIzquierdo = nodoOfArco;
                    }  
                }
                case "Sur" -> {
                    // SI EL NODO ESTA A LA DERECHA
                    if (posicionX > nodoOfArco.getPosicionX()) {
                        nodoDerecho = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO AL FRENTE          
                    if (posicionY > nodoOfArco.getPosicionY()) {
                        nodoFrente = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA A LA IZQUIERDA            
                    if (posicionX < nodoOfArco.getPosicionX()) {
                        nodoIzquierdo = nodoOfArco;
                    }  
                }
                case "Este" -> {
                    // SI EL NODO ESTA A LA DERECHA
                    if (posicionY > nodoOfArco.getPosicionY()) {
                        nodoDerecho = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA AL FRENTE          
                    if (posicionX < nodoOfArco.getPosicionX()) {
                        nodoFrente = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA A LA IZQUIERDA            
                    if (posicionY < nodoOfArco.getPosicionY()) {
                        nodoIzquierdo = nodoOfArco;
                    } 
                }
                case "Oeste" -> {
                    // SI EL NODO ESTA A LA DERECHA
                    if (posicionY < nodoOfArco.getPosicionY()) {
                        nodoDerecho = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA AL FRENTE          
                    if (posicionX > nodoOfArco.getPosicionX()) {
                        nodoFrente = nodoOfArco;
                        continue;
                    }
                    // SI EL NODO ESTA A LA IZQUIERDA            
                    if (posicionY > nodoOfArco.getPosicionY()) {
                        nodoIzquierdo = nodoOfArco;
                    } 
                }
                default -> {
                    throw new AssertionError();
                }                
            }            
        }        
        
        // ORDEN DE PRIORIDADES
        if (nodoFrente != null) {
            buscarCaminoCorto(nodoFrente);
            listNodosVisitados.removeLast();
        }
        if (nodoDerecho != null) {
            buscarCaminoCorto(nodoDerecho);
            listNodosVisitados.removeLast();
        }
        if (nodoIzquierdo != null) {
            buscarCaminoCorto(nodoIzquierdo);
            listNodosVisitados.removeLast();
        }        
    }

    public int getCaminoPosibles() {
        return caminoPosibles;
    }

    private void imprimirLista() {
        caminoPosibles = caminosPosibles.size();
        System.out.println("NUM CAMINOS POSIBLES " + caminosPosibles.size());
    }
    
    private boolean isNodoVisited(Nodo nodo) {
        for (Nodo nodoVisited : listNodosVisitados) {
            if (nodoVisited.getPosicionX() == nodo.getPosicionX() && nodoVisited.getPosicionY() == nodo.getPosicionY()) {
                return true;
            }
        }
        return false;
    }
    public void imprimirListaCaminos() {
        int i = 0;
        for (ArrayList<Nodo> camino : caminosPosibles) {
            i++;
            System.out.println("");
            System.out.println("CAMINO POSIBLE  " + i);
            System.out.println("_________________");
            for (Nodo nodo : camino) {
                System.out.print(nodo.getNodoID() + " ");
                System.out.printf("%-4s %-8s", "X:" + nodo.getPosicionX(), "Y:" + nodo.getPosicionY());
                System.out.print(" | ");

                if (nodo.getNodoID()%3==0) {
                    System.out.println();
                }
            }
            
            System.out.println();  // Nueva línea después de cada camino
        }
    }
}
