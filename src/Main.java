import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        boolean estado = true;
        List<Persona> listapersonas = new ArrayList<>(); // lista de gente
        List<Perro> listaPERROS = new ArrayList<>(); // lista de perritos

        do {
            System.out.println("""
                    1. Registrar Persona.
                    2.Registrar perro.
                    3.Personas Registradas.
                    4. Perros Disponibles.
                    5. Adoptar Perro.
                    6. Perro más viejo adoptado.
                    7. Salir.""");
            int op = teclado.nextInt(); // escoger opcion
            switch (op) {
                case 1 -> {
                    System.out.println("nombre ");
                    String nombre = teclado.next();
                    System.out.println("apellido");
                    String apellido = teclado.next();
                    System.out.println("edad");
                    int edad = teclado.nextInt();
                    System.out.println("documento ");
                    String documento = teclado.next();
                    listapersonas.add(new Persona(nombre, apellido, edad, documento)); // se crea la persona
                }
                case 2 -> { //String placa, String nombre, String raza, int edad, String tamaño
                    System.out.println("placa ");
                    String placa = teclado.next();
                    System.out.println("nombre");
                    String nombre = teclado.next();
                    System.out.println("raza");
                    String raza = teclado.next();
                    System.out.println("edad ");
                    int edad = teclado.nextInt();
                    System.out.println("tamaño");
                    String tamaño = teclado.next();
                    listaPERROS.add(new Perro(placa, nombre, raza, edad, tamaño)); // se crea perrito
                }
                case 3 -> {
                    if (listapersonas.isEmpty()) {
                        System.out.println(" no hay personas registradas ");
                    } else {
                        for (Persona pp : listapersonas) {
                            System.out.println(pp);
                            pp.mostrarInformacion();
                        }
                    }

                }
                case 4 -> {
                    if (listaPERROS.isEmpty()) {
                        System.out.printf("no hay perritos");
                    } else {
                        for (Perro pi : listaPERROS) {
                            System.out.println(pi);
                        }
                    }

                }
                case 5 -> {
                    System.out.println("Ingrese el  documento:");
                    String ndocumento = teclado.next(); // Leer el documento de la persona
                    boolean personaencontrada = false; //  controlar si la persona fue encontrada
                    for (int i = 0; i < listapersonas.size(); i++) {
                        if (listapersonas.get(i).getDocumento().equalsIgnoreCase(ndocumento)) {
                            personaencontrada = true; // La persona fue encontrada
                            Persona personaActual = listapersonas.get(i); // Se obtiene la persona en la posición i y se guarda en la variable de persona actual
                            System.out.println("Digite el número de placa del perro que quiere adoptar:");
                            String nplaca = teclado.next(); //  placa del perro
                            boolean perroEncontrado = false; //  controlar si el perro fue encontrado
                            for (int e = 0; e < listaPERROS.size(); e++) {
                                if (listaPERROS.get(e).getPlaca().equalsIgnoreCase(nplaca)) {
                                    Perro perroBuscado = listaPERROS.get(e); // Se obtiene el perro en la posición e y se guarda en la variable
                                    personaActual.AdoptarPerritos(perroBuscado); // Se agrega el perro a la lista de la persona
                                    listaPERROS.remove(e); // El perro se remueve de la lista general de perros
                                    System.out.println("La adopción fue exitosa.");
                                    perroEncontrado = true; // El perro fue encontrado y adoptado
                                    break; // Salir del bucle de perros
                                }
                            }
                            if (!perroEncontrado) {
                                System.out.println("El perro no se encuentra registrado.");
                            }
                            break; // Salir del bucle de personas porque ya se procesó
                        }
                    }
                    if (!personaencontrada) {
                        System.out.println("La persona no se encuentra registrada.");
                    }
                }
                case 6 -> {
                    if (listapersonas.isEmpty()) {
                        System.out.println("no hay personas registradas");
                    } else {
                        for (Persona pp : listapersonas) {
                            pp.perroGrande();

                        }
                    }
                }
                case 7 -> {
                    System.out.println("salir ");
                    estado = false;
                }

            }
        } while (estado);

    }
}