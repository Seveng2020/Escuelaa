import java.util.Objects;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;


public class Profesor extends Persona implements Serializable {
    private String especialidad;

    public static long profesorid = 1;

    public Profesor() {
    }
    public Profesor(String nombre, String apellido, String DNI, String especialidad) {
        super(nombre, apellido, DNI);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void guardarProfesores(ArrayList<Profesor> profesores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("profesores.dat"))) {
            oos.writeObject(profesores);
            System.out.println("Profesores guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los profesores.");
            e.printStackTrace();
        }
    }

    public ArrayList<Profesor> cargarProfesores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profesores.dat"))) {
            return (ArrayList<Profesor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los profesores.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    @Override
    public String toString() {
        return  "Especialidad= " + especialidad + '\n' +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor profesor)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getEspecialidad(), profesor.getEspecialidad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(especialidad, super.hashCode());
    }
}
