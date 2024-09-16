import java.util.Objects;

public class Director extends Persona {

    private double valoracion;

    public Director() {

    }
    public Director(String nombre, String apellido, String DNI, double valoracion) {
        super(nombre, apellido, DNI);
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
        if (!(o instanceof Director director)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getValoracion(), director.getValoracion()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValoracion());
    }
}