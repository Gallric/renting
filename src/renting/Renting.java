package renting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Renting {

    static ArrayList<Vehicles> vehicles;
    static String archivo = "vehiculos.txt";
    static int op;
    static boolean validacion = false;
    static BufferedReader stdin2 = new BufferedReader(new InputStreamReader(System.in));

    //Metodo para validar que el fichero ha sido leido
    public static void validacion() throws IOException {
        if (validacion == false) {
            System.out.print("No se ha cargado previamente");
            procesoPrincipal();
        }
    }

    public static void leer() {
        try {
            FileReader read = new FileReader(archivo);
            BufferedReader leer = new BufferedReader(read);
            vehicles = new ArrayList();
            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] array = linea.split(";");
                //Ponemos cada tipo de objecto en un array de la clase padre
                if (array[1].equals("T")) {
                    vehicles.add(new Turismo(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt((array[3]))));
                } else if (array[1].equals("C")) {
                    vehicles.add(new Camion(array[0], array[1], Integer.parseInt(array[2])));
                } else if (array[1].equals("MB")) {
                    vehicles.add(new MiniBus(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt((array[3]))));
                } else if (array[1].equals("VC")) {
                    vehicles.add(new Carga(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt((array[3]))));
                }
            }
            //validamos que ha sido leido
            validacion = true;
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void escribir(String matricula, String tipo, String extra) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("vehiculos.txt", true);
            pw = new PrintWriter(fichero);
            pw.println();
            pw.print(matricula + ";" + tipo + ";" + "0;" + extra + ";");
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para obetern precio final
    public static void obtenerPrecio() throws IOException {
        System.out.print("Introduce la matricula: ");
        String matr = stdin2.readLine();
        System.out.print("Introduce dias que lo alquilas: ");
        String input = stdin2.readLine();
        int dias = Integer.parseInt(input);

        for (Vehicles r : vehicles) {
            if (r.getMatricula().equals(matr)) {
                r.setDiesLloguer(dias);
                System.out.print("El preu es de: " + r.precioFinal() + "€\n\n");

            }
        }
        procesoPrincipal();

    }

    /*Metodo donde realizaremos todas las operaciones, sera llamado una y otra vez para hacer un bucle
     de ejecucuion*/
    public static void procesoPrincipal() throws IOException {
        op = Menu.menu();
        switch (op) {
            case 1:
                //Hacemos la carga del fichero
                leer();
                System.out.print("Datos cargados!\n\n");
                procesoPrincipal();
                break;
            case 2:
                //Recoje los datos en Strings y los pasa a un metodo para escribirlos en el fichero
                System.out.print("Matricula: ");
                String matricula = stdin2.readLine();
                if (matricula.length() != 6) {
                    System.out.print("Format invalid, son 6 digits");
                    matricula = "";
                    procesoPrincipal();
                } else {
                    //Aqui pondriamos más condicionales para comprovar que un coche solo dispone como max de 5 plazas...etc
                    System.out.print("Tipo de vehiculo: ");
                    String tipo = stdin2.readLine();
                    System.out.print("Nº de plazas o PMA: ");
                    String extra = stdin2.readLine();
                    int plazas = Integer.parseInt(extra);
                    if (tipo.equals("C") && plazas > 5) {
                        System.out.print("No puede haber mas de 5 plazas: ");
                        extra = "";
                        procesoPrincipal();
                    } else {
                        escribir(matricula, tipo, extra);
                        procesoPrincipal();
                    }
                }

                break;
            case 3:
                //Calculo del precio final
                validacion();
                obtenerPrecio();
                break;
            case 4:
                //cerramos todos los bufferer y el programa
                Menu.exit();
                stdin2.close();
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        procesoPrincipal();
    }

}
