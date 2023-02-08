
package práctica.parcial.pkg1.lista.dinámica;

import javax.swing.JOptionPane;

public class PrácticaParcial1ListaDinámica {

    
    
    public static void main(String[] args) {
        
        //Problema: porque no me deja usar el short???
        //Preguntas: porqué no me deja hacer el intercambio con apuntadores
        String nombre;
        int numero, tamaño, tiempo,toDelete;
        Lista x = new Lista();
        
        String menuFormat = "Escoja una opción\n"
                + "1.- Capturar nuevo proceso\n"
                + "2.- Ordenar lista por tamaño\n"
                + "3.- Ordenar lista por tiempo\n"
                + "4- Ordenar lista por número\n"
                + "5.- Mostrar datos\n"
                + "6.- Elimnar proceso por número\n"
                + "7.- Salir del menú\n";
        int option;
        
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, menuFormat));
            switch(option){
                case 1:
                    nombre = JOptionPane.showInputDialog("Insertar nombre: ");
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Insertar número: "));
                    tamaño = Integer.parseInt(JOptionPane.showInputDialog("Insertar tamaño: "));
                    tiempo = Integer.parseInt(JOptionPane.showInputDialog("Insertar tiempo: "));
                    x.PUSH(nombre, numero, tamaño, tiempo); 
                    break;
                case 2:
                    x.ordenarXtamaño();
                    break;
                case 3:
                    x.ordenarXtiempo();
                    break;
                case 4:
                    x.ordenarXnumero();
                    break;
                case 5:
                    x.mostrarDatos();
                    break;
                case 6:
                    toDelete = Integer.parseInt(JOptionPane.showInputDialog("Número a eliminar: "));
                    x.POPxNumero(1);
                    break;
                case 7:
                    x.mostrarDatos();
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida");
                    break;
            }
        }while(option != 7);

    }
    
}

class Proceso{
    String nombre;
    int numero;
    int tamaño;
    int tiempo;
    Proceso next;
    
    public Proceso(String nombre, int numero, int tamaño, int tiempo){
        this.nombre = nombre;
        this.numero = numero;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
        this.next = null;
    }
}

class Lista{
    Proceso start = null;
    int size = 0;
    
    public void PUSH(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        if(start == null){
            start = nuevoProceso;
        }else{
            Proceso aux = start;
            while(aux.next != null){
                aux = aux.next;
            }aux.next = nuevoProceso;
        }
        size++;
    }
    
    public void POPxNumero(int numero){
        Proceso aux = start;
        Proceso vigilante=start;
        while(aux != null && aux.numero != numero){
            vigilante = aux;
            aux = aux.next;
        }
        
        if(aux != null && aux.numero == numero){
            if(aux == start){
                start = aux.next;
            }else{
                vigilante.next = aux.next;
            }
        }else{
            System.out.println("No lo encontró");
        }
    }
    
    public void ordenarXnumero(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.numero;
        int vueltas = size;
        boolean cambioNecesario;
        

        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.numero < menorLista){
                    menorLista = aux.numero;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
                //intercambioProceso2(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.numero;
            vueltas--;
        }
    }
    
    public void ordenarXtamaño(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.tamaño;
        int vueltas = size;
        boolean cambioNecesario;

        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.tamaño < menorLista){
                    menorLista = aux.tamaño;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.tamaño;
            vueltas--;
        }
    }
    
    public void ordenarXtiempo(){
        Proceso auxInicioRelativo = start;
        Proceso auxMenor = start; 
        Proceso aux = start;
        int menorLista = start.tiempo;
        int vueltas = size;
        boolean cambioNecesario;
        

        while(auxInicioRelativo.next != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.numero < menorLista){
                    menorLista = aux.tiempo;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.next;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.next;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.tiempo;
            vueltas--;
        }
    }
    
    public void intercambioProceso(Proceso menor, Proceso inicioRelativo){
        String auxNombre = inicioRelativo.nombre;
        int auxNum = inicioRelativo.numero;
        int auxTam = inicioRelativo.tamaño;
        int auxTiempo = inicioRelativo.tiempo;
        
        inicioRelativo.nombre = menor.nombre;
        inicioRelativo.numero = menor.numero;
        inicioRelativo.tamaño = menor.tamaño;
        inicioRelativo.tiempo = menor.tiempo;
        
        menor.nombre = auxNombre;
        menor.numero = auxNum;
        menor.tamaño = auxTam;
        menor.tiempo = auxTiempo;
    }
    
    public void intercambioProceso2(Proceso menor, Proceso inicioRelativo){
        Proceso aux = menor;
        menor = inicioRelativo;
        inicioRelativo = aux;
    }
    
    public void mostrarDatos(){
        Proceso aux = start;
        int vuelta = 0;
        
        while(aux != null){
            System.out.println("Proceso #"+(++vuelta));
            System.out.println("Nombre: "+aux.nombre);
            System.out.println("Número: "+aux.numero);
            System.out.println("Tamaño: "+aux.tamaño);
            System.out.println("Tiempo: "+aux.tiempo+"\n");
            aux = aux.next;
        }
    }
}

