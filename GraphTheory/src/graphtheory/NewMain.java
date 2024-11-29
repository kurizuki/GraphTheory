package graphtheory;

/**
 *
 * @author L
 */
public class NewMain {
    public static void main(String[] args) {        
        Laberinto laberinto = new Laberinto(13,13);
        laberinto.imprimirLaberinto();
        Grafo grafo = new Grafo(laberinto);       
        
        
        grafo.imprimirListNodos();          
    }
    
}
