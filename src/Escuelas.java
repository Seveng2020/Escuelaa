import java.util.Scanner;
import java.util.ArrayList;

public class Escuelas {
    private static Colegio colegio = new Colegio();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("-------Menu-------");
            System.out.println("1. Cargar Colegio");
            System.out.println("2. Agregar Colegio");
            System.out.println("3. Imprimir Estadisticas de Colegio");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    Colegio colegioCargado = Colegio.cargarColegio();
                    if (colegioCargado != null) {
                        colegio = colegioCargado;
                        System.out.println("Colegio cargado exitosamente.");
                    } else {
                        System.out.println("No se pudo cargar el colegio.");
                    }
                    break;
                case 2:
                    agregarColegio(sc);
                    break;
                case 3:
                    colegio.imprimirEstadisticas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 4);
    }

    private static void agregarColegio(Scanner sc) {
        System.out.println("Ingrese Nombre Del Colegio:");
        sc.nextLine();
        String nombre = sc.nextLine();
        colegio.setNombre(nombre);
        int op;
        do {
            System.out.println("---------Agregar Colegio---------");
            System.out.println("1. Crear Director");
            System.out.println("2. Crear Aula");
            System.out.println("3. Guardar Aulas");
            System.out.println("4. Cargar Aulas");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("---------Crear Director---------");
                    Director director = new Director();
                    System.out.print("Nombre: ");
                    director.setNombre(sc.next());
                    System.out.print("Apellido: ");
                    director.setApellido(sc.next());
                    System.out.print("DNI: ");
                    director.setDNI(sc.next());
                    System.out.print("Valoracion: ");
                    director.setValoracion(sc.nextDouble());
                    colegio.setDirector(director);
                    break;
                case 2:
                    System.out.println("---------Crear Aula---------");
                    colegio.agregarAula(sc);
                    break;
                case 3:
                    Colegio.guardarAulas(colegio.getAulas());
                    Colegio.guardarColegio(colegio);
                    break;
                case 4:
                    ArrayList<Aula> aulasCargadas = Colegio.cargarAulas();
                    colegio.setAulas(aulasCargadas);
                    System.out.println("Aulas cargadas exitosamente.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 4);
    }
}