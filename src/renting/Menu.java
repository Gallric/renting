package renting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    static BufferedReader stdin = new BufferedReader (new InputStreamReader(System.in)); 
    public static int menu() throws IOException {
        int op;
        
        System.out.println("  Tria la opcio         ");
        System.out.println("------------------------");
        System.out.println("1.-Cargar datos         ");
        System.out.println("2.-Añadir vehiculo      ");
        System.out.println("3.-Precio alquiler   ");       
        System.out.println("4.-Salir                ");
        System.out.println("------------------------");
        String input=stdin.readLine();
        op=Integer.parseInt(input);
        return op;
    }
    
    public static void exit() throws IOException{
        System.out.print("Un plaer!");
        stdin.close();
        System.exit(0);
    }    
}
