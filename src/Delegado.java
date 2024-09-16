import java.util.Objects;
import java.io.Serializable;
public class Delegado extends Alumno implements Serializable{

    private double valoracion;

    public static long delegadoid = 1;

    public Delegado() {
    }

    public Delegado(String nombre, String apellido, String DNI, String curso, double notamedia, double valoracion) {
        super(nombre, apellido, DNI, curso, notamedia);
        this.valoracion = valoracion;
    }


    public double getValoracion() { return valoracion; }
    public void setValoracion(double valoracion) { this.valoracion = valoracion; }


    @Override
    public String toString() {
        return  "Valoracion= " + valoracion + '\n' +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delegado delegado)) return false;
        return getValoracion() == delegado.getValoracion() && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValoracion());
    }

}
