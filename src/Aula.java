import java.util.ArrayList;
import java.util.Objects;
import java.io.Serializable;
import java.util.Scanner;

public class Aula implements Serializable {
    private static long aulaid = 1;

    private ArrayList <Alumno> alumnos;
    private Profesor profesor;
    private String idaula;


    public Aula(String idaula, Profesor profesor, ArrayList<Alumno> alumnos) {
        this.idaula = idaula;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public Aula() {
    }

    public ArrayList<Alumno> getAlumnos() { return alumnos; }
    public void setAlumnos(ArrayList<Alumno> alumnos) { this.alumnos = alumnos; }

    public Profesor getProfesor() { return profesor; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }

    public String getIdaula() { return idaula; }
    public void setIdaula(String idaula) { this.idaula = idaula; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aula aula)) return false;
        return getIdaula().equals(aula.getIdaula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdaula());
    }

}
