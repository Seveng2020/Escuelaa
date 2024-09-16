import java.time.LocalDate;
import java.util.Objects;
import java.io.Serializable;
public class Persona implements Serializable{
    private static final long personaid = 1;
    private String nombre;
    private String apellido;
    private String DNI;

    private LocalDate fechaNacimiento;
    public Persona() {
    }
    public Persona(String nombre, String apellido, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.fechaNacimiento = LocalDate.now();
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return  "Nombre= " + nombre + '\n' +
                "Apellido= " + apellido + '\n' +
                "DNI= " + DNI + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido) && Objects.equals(DNI, persona.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, DNI);
    }
}
