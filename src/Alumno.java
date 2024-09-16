import java.util.Objects;

public class Alumno extends Persona {

    private String curso;
    private double notamedia;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String DNI, String curso, double notamedia) {
        super(nombre, apellido, DNI);
        this.curso = curso;
        this.notamedia = notamedia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    @Override
    public String toString() {
        return  "Curso= " + curso + '\n' +
                "NotaMedia= " + notamedia + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return getNotamedia() == alumno.getNotamedia() && getCurso().equals(alumno.getCurso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurso(), getNotamedia());
    }
}
