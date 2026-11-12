package arreglos.tienda.utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String dato;
        do{
            System.out.println(mensaje+" : ");
            dato = sc.nextLine();
        }while(dato == null || dato.trim().isEmpty());
        return dato;
    }

    public static int Leerint(String mensaje){
        int num;
        do {
            System.out.println(mensaje+" : ");
            num = Integer.parseInt(sc.nextLine());
        }while (num < 0);
        return num;
    }
    public static double LeerDouble(String mensaje){
        double num;
        do {
            System.out.println(mensaje+" : ");
            num = Double.parseDouble(sc.nextLine());
        }while (num < 0);
        return num;
    }
}
