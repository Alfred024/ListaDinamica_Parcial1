public class ListaDinamica{
    Proceso inicio = null;
    int tamaño = 0;
    


    public void push(String nombre, int numero, int tamaño, int tiempo){
        Proceso nuevoProceso = new Proceso(nombre, numero, tamaño, tiempo);
        if(inicio == null){
            inicio = nuevoProceso;
        }else{
            Proceso aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }aux.siguiente = nuevoProceso;
        }
        tamaño++;
    }
    


    public void POPxNumero(int numero){
        Proceso aux = inicio;
        Proceso vigilante=inicio;
        while(aux != null && aux.numero != numero){
            vigilante = aux;
            aux = aux.siguiente;
        }
        
        if(aux != null && aux.numero == numero){
            if(aux == inicio){
                inicio = aux.siguiente;
            }else{
                vigilante.siguiente = aux.siguiente;
            }
        }else{
            System.out.println("No lo encontró");
        }
    }
    


    public void ordenarXnumero(){
        Proceso auxInicioRelativo = inicio;
        Proceso auxMenor = inicio; 
        Proceso aux = inicio;
        int menorLista = inicio.numero;
        int vueltas = tamaño;
        boolean cambioNecesario;
        

        while(auxInicioRelativo.siguiente != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.numero < menorLista){
                    menorLista = aux.numero;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.siguiente;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
                //intercambioProceso2(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.siguiente;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.numero;
            vueltas--;
        }
    }
    


    public void ordenarXtamaño(){
        Proceso auxInicioRelativo = inicio;
        Proceso auxMenor = inicio; 
        Proceso aux = inicio;
        int menorLista = inicio.tamaño;
        int vueltas = tamaño;
        boolean cambioNecesario;

        while(auxInicioRelativo.siguiente != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.tamaño < menorLista){
                    menorLista = aux.tamaño;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.siguiente;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.siguiente;
            auxMenor = aux = auxInicioRelativo;
            menorLista = auxInicioRelativo.tamaño;
            vueltas--;
        }
    }
    


    public void ordenarXtiempo(){
        Proceso auxInicioRelativo = inicio;
        Proceso auxMenor = inicio; 
        Proceso aux = inicio;
        int menorLista = inicio.tiempo;
        int vueltas = tamaño;
        boolean cambioNecesario;
        

        while(auxInicioRelativo.siguiente != null){
            cambioNecesario = false;
            for (int i = 0; i < vueltas; i++) {
                if(aux.numero < menorLista){
                    menorLista = aux.tiempo;
                    auxMenor = aux;
                    cambioNecesario = true;
                }aux = aux.siguiente;
            }
            
            if(cambioNecesario){
                intercambioProceso(auxMenor, auxInicioRelativo);
            }
            auxInicioRelativo = auxInicioRelativo.siguiente;
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
        Proceso aux = inicio;
        int vuelta = 0;
        
        while(aux != null){
            System.out.println("Proceso #"+(++vuelta));
            System.out.println("Nombre: "+aux.nombre);
            System.out.println("Número: "+aux.numero);
            System.out.println("Tamaño: "+aux.tamaño);
            System.out.println("Tiempo: "+aux.tiempo+"\n");
            aux = aux.siguiente;
        }
    }
}