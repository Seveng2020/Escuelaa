
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Colegio implements Serializable {
    private static long colegioid = 1;
    private static ArrayList<Aula> aulas = new ArrayList<>();
    private String nombre;
    private Director director;

    public Colegio() {}

    public Colegio(String nombre, Director director, ArrayList<Aula> aulas) {
        this.nombre = nombre;
        this.director = director;
        this.aulas = aulas;
    }

    public static void guardarColegio(Colegio colegio) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("colegio.dat"))) {
            oos.writeObject(colegio);
            System.out.println("Colegio guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el colegio.");
            e.printStackTrace();
        }
    }
    public static Colegio cargarColegio() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("colegio.dat"))) {
            return (Colegio) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el colegio.");
            e.printStackTrace();
            return null;
        }
    }
    public void agregarAula(Scanner sc) {
        System.out.println("---------Crear Aula---------");
        System.out.print("ID Aula: ");
        String idAula = sc.next();

        System.out.println("---------Crear Profesor---------");
        Profesor profesor = new Profesor();
        System.out.print("Nombre: ");
        profesor.setNombre(sc.next());
        System.out.print("Apellido: ");
        profesor.setApellido(sc.next());
        System.out.print("DNI: ");
        profesor.setDNI(sc.next());
        System.out.print("Especialidad: ");
        profesor.setEspecialidad(sc.next());

        ArrayList<Alumno> alumnos = new ArrayList<>();
        int numAlumnos;
        System.out.print("Número de alumnos: ");
        numAlumnos = sc.nextInt();

        for (int i = 0; i < numAlumnos; i++) {
            System.out.println("---------Crear Alumno " + (i + 1) + "---------");
            Alumno alumno = new Alumno();
            System.out.print("Nombre: ");
            alumno.setNombre(sc.next());
            System.out.print("Apellido: ");
            alumno.setApellido(sc.next());
            System.out.print("DNI: ");
            alumno.setDNI(sc.next());
            System.out.print("Curso: ");
            alumno.setCurso(sc.next());
            System.out.print("Nota Media: ");
            alumno.setNotamedia(sc.nextDouble());
            alumnos.add(alumno);
        }

        Aula aula = new Aula(idAula, profesor, alumnos);
        aulas.add(aula);
        System.out.println("Aula creada y agregada al colegio.");
    }

    public static void guardarAulas(ArrayList<Aula> aulas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aulas.dat"))) {
            oos.writeObject(aulas);
            System.out.println("Aulas guardadas exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las aulas.");
            e.printStackTrace();
        }
    }
    public static ArrayList<Aula> cargarAulas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aulas.dat"))) {
            return (ArrayList<Aula>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las aulas.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public double getNotaMedia() {
        double totalNotas = 0;
        int numAlumnos = 0;
        for (Aula aula : aulas) {
            for (Alumno alumno : aula.getAlumnos()) {
                totalNotas += alumno.getNotamedia();
                numAlumnos++;
            }
        }
        if (numAlumnos > 0) {
            return totalNotas / numAlumnos;
        } else {
            return 0;
        }
    }

    public Alumno getMejorAlumno() {
        Alumno mejorAlumno= null;
        double mejorNota = 0;

        for (Aula aula : aulas) {
            for (Alumno alumno : aula.getAlumnos()) {
                if (alumno.getNotamedia() > mejorNota) {
                    mejorNota = alumno.getNotamedia();
                    mejorAlumno = alumno;
                }
            }
        }
        return mejorAlumno;
    }


    public void imprimirEstadisticas() {
        System.out.println("Nombre del colegio: " + nombre);
        System.out.println("Director: " + director.getNombre() + " " + director.getApellido());
        System.out.println("Nota media de los alumnos: " + getNotaMedia());
        Alumno mejorAlumno = getMejorAlumno();
        if (mejorAlumno != null) {
            System.out.println("Mejor alumno: " + mejorAlumno.getNombre() + " " + mejorAlumno.getApellido());
        }
    }


    public static long getColegioid() { return colegioid; }


    public ArrayList<Aula>  getAulas() { return aulas; }
    public void setAulas(ArrayList<Aula> aulas) { this.aulas = aulas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Director getDirector() { return director; }
    public void setDirector(Director director) { this.director = director; }
}
