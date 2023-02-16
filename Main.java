import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Problema: porque no me deja usar el short???
        // Preguntas: porqué no me deja hacer el intercambio con apuntadores
        ListaDinamica listaDinamica = new ListaDinamica();
        int option;

        String menuFormat = "\n\n------SELECCIONE UNA OPCIÓN------\n"
                + "1.- Capturar nuevo proceso\n"
                + "2.- Ordenar lista por tamaño\n"
                + "3.- Ordenar lista por tiempo\n"
                + "4- Ordenar lista por número\n"
                + "5.- Mostrar datos\n"
                + "6.- Eliminar proceso por número\n"
                + "7.- Salir del menú\n";

        do {
            System.out.println(menuFormat);
            option = Integer.parseInt(sc.next());
            switch (option) {
                case 1:
                    System.out.println("Inserte nombre: ");
                    String nombre = sc.next();
                    System.out.println("Inserte número: ");
                    int numero = sc.nextInt();
                    System.out.println("Inserte tamaño: ");
                    int tamaño = sc.nextInt();
                    System.out.println("Inserte tiempo");
                    int tiempo = sc.nextInt();
                    listaDinamica.push(nombre, numero, tamaño, tiempo);
                    break;
                case 2:
                    listaDinamica.ordenarXtamaño();
                    break;
                case 3:
                    listaDinamica.ordenarXtiempo();
                    break;
                case 4:
                    listaDinamica.ordenarXnumero();
                    break;
                case 5:
                    listaDinamica.mostrarDatos();
                    break;
                case 6:
                    System.out.println("Ingrese el número del proceso a eliminar");
                    int numeroAEliminar = sc.nextInt();
                    listaDinamica.POPxNumero(numeroAEliminar);
                    break;
                case 7:
                    listaDinamica.mostrarDatos();
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }
        } while (option != 7);

        sc.close();
    }

}
