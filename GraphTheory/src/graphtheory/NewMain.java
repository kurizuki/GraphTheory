package graphtheory;

/**
 *
 * @author L
 */
public class NewMain {
    private static boolean caminoEncontrado = false;
    public static void main(String[] args) {    
        Calle calle = new Calle(3);
        calle.imprimir();
        do {            
            inicio();
        } while (!caminoEncontrado);   
    }  

    private static void inicio() {
        Laberinto laberinto = new Laberinto(13,13);
        laberinto.imprimirLaberinto();
        Grafo grafo = new Grafo(laberinto.getLaberinto(), laberinto.getMetaX(), laberinto.getMetaY());       
        
        
        grafo.imprimirListNodos();    
        System.out.println("");
        System.out.println("META");
        System.out.println("X: " + laberinto.getMetaX() + "     Y: " + laberinto.getMetaY());
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
        
        CaminoDerecha caminoDerecha = new CaminoDerecha(grafo.getListNodo(), laberinto.getMetaX(), laberinto.getMetaY(), laberinto.getInicioX(), laberinto.getInicioY());
        caminoDerecha.imprimirListaCaminos();
        if (caminoDerecha.getCaminoPosibles() >= 1) {
            caminoEncontrado = true;
        }
    }
    
    private void space() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("");
        }
    }

}
