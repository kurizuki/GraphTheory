package graphtheory;

/**
 *
 * @author L
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calles calles = new Calles(100,100);
        calles.getMapa();
        Grafo grafo = new Grafo(calles.getMapa());       
        
        
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
                    System.out.print("  "); 
                }
            }
            System.out.println(); 
        }
    }
    
}
