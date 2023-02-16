public class Proceso{
    String nombre;
    int numero;
    int tamaño;
    int tiempo;
    Proceso siguiente;
    
    public Proceso(String nombre, int numero, int tamaño, int tiempo){
        this.nombre = nombre;
        this.numero = numero;
        this.tamaño = tamaño;
        this.tiempo = tiempo;
        this.siguiente = null;
    }
}
