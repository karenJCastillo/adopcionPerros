import java.util.ArrayList;
import java.util.List;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String documento;
    protected List<Perro> perritoslista = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    int limitedeperros=3;
    public void AdoptarPerritos (Perro nuevoPerrito){//METODO
        if (perritoslista.size()<limitedeperros){
            System.out.println("el perrito ha sido adoptado con exito ");
            perritoslista.add(nuevoPerrito); // se agrega a la lista de la persona
        } else {
            System.out.println("no puedes adoptar más perritos");
        }
    }
    public void perroGrande (){ //  METODO PARA QUE APARESCA EL PERRO MÁS GRANDE
        if (perritoslista.isEmpty()) { // si la lsita esta vacia
            System.out.println("No hay perritos en la lista.");
            return;
        }
        Perro masGrande = perritoslista.get(0); // se crea una variable de tipo perro que nos puede almacenar objetos de los perros
        for (Perro perrito : perritoslista){
            if ( perrito.getEdad()>masGrande.getEdad()){ // se compara la informacion
                masGrande = perrito; // aqui actualizamos a la aviable del más grnade con la informacion del perrito de la lista
            }
        }
        System.out.println("El perrito más grande es "+ masGrande.getNombre()+"con "+masGrande.getEdad()+" años de edad");
    }
    public void mostrarInformacion (){
        System.out.println("Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                '}');
        if (perritoslista.isEmpty()) { // si la lsita esta vacia
            System.out.println("No hay perritos en la lista.");

        }else {
            for (Perro perrito : perritoslista){
                System.out.println("Perro" +
                        "placa='" + perrito.getPlaca() + '\'' +
                        ", nombre='" + perrito.getNombre() + '\'' +
                        ", raza='" + perrito.getRaza() + '\'' +
                        ", edad=" + perrito.getEdad() +
                        ", tamaño='" + perrito.getTamaño() + '\'' +
                        '}');
            }
        }
        System.out.println("total de perritos adoptados:"+"   " +perritoslista.size());
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                ", perritos adoptados =" + perritoslista.size() +
                '}';
    }
}
