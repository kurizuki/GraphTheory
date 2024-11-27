package graphtheory;

/**
 *
 * @author L
 */
public class NewMain {
    public static void main(String[] args) {        
        Laberinto laberinto = new Laberinto(21,21);
        Grafo grafo = new Grafo(laberinto);
        
        laberinto.imprimirLaberinto();
        
        grafo.imprimirListNodos();
        
        
        
        
        
        
        
    }
    
}
