package graphtheory;

/**
 *
 * @author L
 */
public class NewMain {
    private static Laberinto laberinto;

    public static void main(String[] args) {        
        laberinto = new Laberinto(21,21);
        
        laberinto.imprimirLaberinto();
        laberinto.imprimirMatriz();
        
        
        
    }
    
}
