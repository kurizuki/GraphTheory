package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    private ArrayList<Nodo> listNodo = new ArrayList<>();
    
    
    // ELEMENTOS A CODIFICAR
    Laberinto laberintoObject;
    int[][] laberinto;
    
    // MEDICIONES
    int numIteraciones=0;
    
    public Grafo() {
    }

     public Grafo(Laberinto laberinto) {
        this.laberintoObject = laberinto;
        this.laberinto = laberinto.getLaberinto();

        crearGrafo(laberinto.getInicioX(), laberinto.getInicioY());              
    }
    
    private void crearGrafo(int inicioX, int inicioY) {
        Nodo nodoInicial = new Nodo(listNodo.size(), inicioX, inicioY);
        listNodo.add(nodoInicial);
        
        mapearNodos();
    }
    
    private void mapearNodos() {               
        for (int i = 0; i < listNodo.size(); i++) {
            numIteraciones++;
            buscarNodosAdyacentes(listNodo.get(i));
        } 
    }
    
    private void buscarNodosAdyacentes(Nodo nodo) {
        int posicionX = nodo.getPosicionX();
        int posicionY = nodo.getPosicionY();
        
        // MOVERSE ARRIBA
        for (int i = posicionY; i < laberinto.length && laberinto[i][posicionX] == 0; i++) {
            // VALIDAR SI EN LA DERECHA HAY UN ESPACIO EN BLANCO
            if (posicionX+1 < laberinto[i].length && laberinto[i][posicionX+1] == 0) {
                addNodo(posicionX,i);
                continue;
            }
            // VALIDAR SI EN LA IZQUIERDA HAY UN ESPACIO EN BLANCO
            if (posicionX-1 >= 0 && laberinto[i][posicionX-1] == 0) {
                addNodo(posicionX,i);
                continue;
            }
            if (i+1 < laberinto.length && laberinto[i+1][posicionX] == 1) {
                addNodo(posicionX,i);
            }
        }
        
        // MOVERSE ABAJO
        for (int i = posicionY; i >= 0 && laberinto[i][posicionX] == 0; i--) {
            // VALIDAR SI EN LA DERECHA HAY UN ESPACIO EN BLANCO
            if (posicionX+1 < laberinto[i].length && laberinto[i][posicionX+1] == 0) {
                addNodo(posicionX,i);
                continue;
            }
            // VALIDAR SI EN LA IZQUIERDA HAY UN ESPACIO EN BLANCO
            if (posicionX-1 >= 0 && laberinto[i][posicionX-1] == 0) {
                addNodo(posicionX,i);
                continue;
            }
            if (i-1 >= 0 && laberinto[i-1][posicionX] == 1) {
                addNodo(posicionX,i);
            }
        }
        
        // MOVERSE DERECHA
        for (int i = posicionX; i < laberinto[posicionY].length && laberinto[posicionY][i] == 0; i++) {
            // VALIDAR SI ARRIBA HAY UN ESPACIO EN BLANCO
            if (posicionY + 1 < laberinto.length && laberinto[posicionY + 1][i] == 0) {
                addNodo(i, posicionY);
                continue;
            }
            // VALIDAR SI ABAJO HAY UN ESPACIO EN BLANCO
            if (posicionY - 1 >= 0 && laberinto[posicionY - 1][i] == 0) {
                addNodo(i, posicionY); 
                continue;
            }
            if (i + 1 < laberinto[posicionY].length && laberinto[posicionY][i + 1] == 1) {
                addNodo(i, posicionY);
            }
        }
        
        // MOVERSE IZQUIERDA
        for (int i = posicionX; i >= 0 && laberinto[posicionY][i] == 0; i--) {
            // VALIDAR SI ARRIBA HAY UN ESPACIO EN BLANCO
            if (posicionY+1 < laberinto.length && laberinto[posicionY+1][i] == 0) {
                addNodo(i,posicionY);
                continue;
            }
            // VALIDAR SI ABAJO HAY UN ESPACIO EN BLANCO
            if (posicionY-1 >= 0 && laberinto[posicionY-1][i] == 0) {
                addNodo(i,posicionY);
                continue;
            }
            if (i-1 >= 0 && laberinto[posicionY][i-1] == 1) {
                addNodo(i,posicionY);
            }
        }        
    }    
    
    private boolean addNodo(int posicionX, int posicionY) {
        for (int i = 0; i < listNodo.size(); i++) {            
            if (listNodo.get(i).getPosicionX() == posicionX && listNodo.get(i).getPosicionY() == posicionY) {
                return false;
            }
        }   
        return listNodo.add(new Nodo(listNodo.size(), posicionX, posicionY));
    }
 
    public void getMatrizAdyacencia() {
        
    }
    
    public void imprimirListNodos() {
        System.out.println("");
        System.out.println("LISTA DE NODOS");        
        for (Nodo nodo : listNodo) {
        System.out.printf("%-4s %-8s", "X:" + nodo.getPosicionX(), "Y:" + nodo.getPosicionY());
        System.out.print(" | ");
            
            if (nodo.getNodoID()%3==0) {
                System.out.println();
            }            
        }
        System.out.println("");
        System.out.println("NODOS MAPEADOS: "+listNodo.size());
        System.out.println("ITERACIONES NECESARIAS: " + numIteraciones );
    }
    
}
