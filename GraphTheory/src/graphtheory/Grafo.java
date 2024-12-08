package graphtheory;

import java.util.ArrayList;

/**
 *
 * @author L
 */
public class Grafo {
    // ELEMENTOS DEL GRAFO
    private ArrayList<Nodo> listNodo = new ArrayList<>();
    private int[][] matrizAdyacencia;
   
    // ELEMENTOS A CODIFICAR
    int[][] matriz;
    
    // MEDICIONES
    int numIteraciones=0;
    int numValidaciones=0;
    
    public Grafo() {
    }

    public Grafo(int[][] matriz) {
        this.matriz = matriz;
        crearGrafo(1, 1); 
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    private void crearGrafo(int inicioX, int inicioY) {
        Nodo nodoInicial = new Nodo(listNodo.size(), inicioX, inicioY);
        listNodo.add(nodoInicial);
        
        mapearNodos();
        calcularMatrizAdyacencia();
    }
    
    private void mapearNodos() {               
        for (int i = 0; i < listNodo.size(); i++) {
            numIteraciones++;
            mapearNodosAdyacentes(listNodo.get(i));
        } 
    }
    
    private void mapearNodosAdyacentes(Nodo nodo) {
        int posicionX = nodo.getPosicionX();
        int posicionY = nodo.getPosicionY();
        
        // MOVERSE ARRIBA
        for (int i = posicionY; i < matriz.length && matriz[i][posicionX] == 0; i++) {
            // VALIDAR SI HAY ESPACIOS EN BLANCO AL COSTADO
            if (!isVoidEjeY(posicionX, i)) {                                               
                continue;
            }
            
            if (!(i+1 < matriz.length && matriz[i+1][posicionX] == 1)) {
                continue;
            }
            
            if (addNodo(posicionX,i)) {
                nodo.addArco(new Arco(listNodo.getLast()));
                listNodo.get(listNodo.size()-1).addArco(new Arco(nodo));
            } 
        }
        
        // MOVERSE ABAJO
        for (int i = posicionY; i >= 0 && matriz[i][posicionX] == 0; i--) {
            // VALIDAR SI HAY ESPACIOS EN BLANCO AL COSTADO
            if (!isVoidEjeY(posicionX, i)) {                
                continue;
            }

            if (!(i-1 >= 0 && matriz[i-1][posicionX] == 1)) {
                continue;
            }
            
            if (addNodo(posicionX,i)) {
                nodo.addArco(new Arco(listNodo.getLast()));
                listNodo.get(listNodo.size()-1).addArco(new Arco(nodo));
            } 
        }
        
        // MOVERSE DERECHA
        for (int i = posicionX; i < matriz[posicionY].length && matriz[posicionY][i] == 0; i++) {
            // VALIDAR SI HAY ESPACIOS EN BLANCO EN EL EJE Y
            if (!isVoidEjeX(i, posicionY)) {                                
                continue;
            }
            
            if (!(i + 1 < matriz[posicionY].length && matriz[posicionY][i + 1] == 1)) {
                continue;
            }
            
            if (addNodo(i, posicionY)) {
                nodo.addArco(new Arco(listNodo.getLast()));
                listNodo.get(listNodo.size()-1).addArco(new Arco(nodo));
            } 
        }
        
        // MOVERSE IZQUIERDA
        for (int i = posicionX; i >= 0 && matriz[posicionY][i] == 0; i--) {
            // VALIDAR SI HAY ESPACIOS EN BLANCO EN EL EJE Y
            if (!isVoidEjeX(i, posicionY)) {
                continue;
            }
            
            if (!(i-1 >= 0 && matriz[posicionY][i-1] == 1)) {
                continue;
            }
            
            if (addNodo(i, posicionY)) {
                nodo.addArco(new Arco(listNodo.getLast()));
                listNodo.get(listNodo.size()-1).addArco(new Arco(nodo));
            }  
        }        
    }    
    
    private boolean isVoidEjeY(int posicionX, int posicionY) {
        // VALIDAR SI EN LA DERECHA HAY UN ESPACIO EN BLANCO
        if (posicionX+1 < matriz[posicionY].length && matriz[posicionY][posicionX+1] == 0) {                              
            return true;
        }
        // VALIDAR SI EN LA IZQUIERDA HAY UN ESPACIO EN BLANCO
        if (posicionX-1 >= 0 && matriz[posicionY][posicionX-1] == 0) {
            return true;
        }
        return false;
    }
    
    private boolean isVoidEjeX(int posicionX, int posicionY) {
        // VALIDAR SI ARRIBA HAY UN ESPACIO EN BLANCO
        if (posicionY + 1 < matriz.length && matriz[posicionY + 1][posicionX] == 0) {
            return true;
        }
        // VALIDAR SI ABAJO HAY UN ESPACIO EN BLANCO
        if (posicionY - 1 >= 0 && matriz[posicionY - 1][posicionX] == 0) {
            return true;
        }
        return false;
    }
        
    private boolean addNodo(int posicionX, int posicionY) {
        for (int i = 0; i < listNodo.size(); i++) {            
            if (listNodo.get(i).getPosicionX() == posicionX && listNodo.get(i).getPosicionY() == posicionY) {
                numValidaciones++;
                return false;
            }
        }   
        return listNodo.add(new Nodo(listNodo.size(), posicionX, posicionY));
    }
 
    private void calcularMatrizAdyacencia() {
        matrizAdyacencia = new int[listNodo.size()][listNodo.size()];
        
        for (Nodo nodo : listNodo) {
            int id = nodo.getNodoID();
            ArrayList<Arco> listArco = nodo.getListArco();
            for (int i = 0; i < listArco.size(); i++) {
                matrizAdyacencia[id][listArco.get(i).getNodo().getNodoID()] = 1;
            }            
        }
    }
    
    public void imprimirListNodos() {
        System.out.println("___________________________");
        System.out.println("LISTA DE NODOS");   
        System.out.println();
        for (Nodo nodo : listNodo) {
            System.out.print(nodo.getNodoID() + " ");
            System.out.printf("%-4s %-8s", "X:" + nodo.getPosicionX(), "Y:" + nodo.getPosicionY());
            System.out.print("GRADOS: "  + nodo.getListArco().size());
            System.out.print(" | ");

                if (nodo.getNodoID()%3==0) {
                    System.out.println();
                }            
        }
        System.out.println();
        System.out.println();
        System.out.println("NODOS MAPEADOS: "+listNodo.size());
        System.out.println("ITERACIONES: " + numIteraciones );
        System.out.println("VALIDACIONES EJECUTADAS: " + numValidaciones);
    }
    
}
