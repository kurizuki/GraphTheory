package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class NewMain {
    public static void main(String[] args) {        
        Laberinto laberinto = new Laberinto(13,13);
        laberinto.imprimirLaberinto();
        Grafo grafo = new Grafo(laberinto.getLaberinto());       
        
        
        grafo.imprimirListNodos();    
        System.out.println("____________________________");
        System.out.println("MATRIZ DE ADYACENCIA");
        System.out.println("");
        int[][] matrizAdyacencia = grafo.getMatrizAdyacencia();
        
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                if (i != j) {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                } else {
                    System.out.print("□ "); 
                }
            }
            System.out.println(); 
        }
        
        buscarCaminoCorto(grafo.getListNodo().getFirst());
    }
    
    public static void buscarCaminoCorto(Nodo nodo) {
        ArrayList<Arco> nodoArrayList = nodo.getListArco();
        int posicionX = nodo.getPosicionX();
        int posicionY = nodo.getPosicionY();       
        
        
        for (int i = 0; i < nodoArrayList.size(); i++) {
            if (posicionX > nodoArrayList.get(i).getNodo().getPosicionX()) {
                
            }
        }
        return;
    }
    
}
