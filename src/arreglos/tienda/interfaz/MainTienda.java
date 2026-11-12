package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;
import arreglos.tienda.utilitario.Validacion;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class MainTienda {
    private static AppStore tienda = new AppStore();
    private static Scanner sc = new Scanner(System.in);

    static void main() {
        int opc;
       tienda.cargarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    ingresarJuegos();
                }break;
                case 2:{
                    imprimirInformacion();
                }break;
                case 3:{
                    buscarJuego();

                }break;
                case 4:{
                    comprar();

                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    masVendido();

                }break;
                case 7:{
                    salida();


                }break;
                default:
                    System.out.println("No es una opción válida");
            }

       }while(opc != 7);
    }

    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuegos(){
        System.out.println("*******Ingreso de datos********");

        String nombre = Validacion.leerString("Ingrese el nombre / no se aceptan nulos ni espacios en blanco");
        String categoria = Validacion.leerString("Ingrese la categoria / no se aceptan nulos ni espacios en blanco");
        int tamanio = Validacion.Leerint("ingrese el tamanio del juego / no se aceptan valores negativos");
        double precio = Validacion.LeerDouble("ingrese el precio del juego / no se aceptan valores negativos");
        int licenciasDisponibles = Validacion.Leerint("Ingrese el stock inicial");
        if(tienda.adicionarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"El juego se ha agregado con éxito");
        }
        else{
            JOptionPane.showMessageDialog(null,"No fue posible agregar el juego");
        }
    }

    public static void imprimirInformacion(){
       java.util.List<Juego> juegos = tienda.getJuegos();
        if(tienda.getJuegos().isEmpty()){
            System.out.println("No existen juegos aún");
        }else{
            for(int i = 0; i < juegos.size(); i++){
                System.out.println(juegos.get(i));
            }
        }

    }
    public static void comprar(){
        String nombre;
        int cantidad;
        nombre = Validacion.leerString("Ingrese el nombre del juego (No nulo ni en blanco)");
        cantidad = Validacion.Leerint("Ingrese la cantidad de licencias que va a adquirir");
        boolean compra = tienda.comprar(nombre,cantidad);
        if(compra == true){
            JOptionPane.showMessageDialog(null,"compra realizada");
        }else{
            JOptionPane.showMessageDialog(null,"No fue posible realizar esta compra");
        }

    }

    public static void vender(){
        String nombre;
        int cantidad;
        nombre = Validacion.leerString("Ingrese el nombre del juego (No nulo ni en blanco)");
        cantidad = Validacion.Leerint("Ingrese la cantidad");
        double valorPago = tienda.vender(nombre,cantidad);
        if(valorPago != 0){
            JOptionPane.showMessageDialog(null,"Juego: "+nombre+"\nCantidad: "+cantidad+
                    "Valor a cancelar: "+valorPago);
        }else{
            JOptionPane.showMessageDialog(null,"No fue posible vender el juego "+nombre);
        }

    }

    public static void buscarJuego(){
        String nombre = Validacion.leerString("ingrese el nombre del juego");
        Juego j = tienda.buscarJuego(nombre);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("juego no existe");
        }

    }
    public static void masVendido(){
        String mayor = tienda.masVendido();
        System.out.println("goty: "+ mayor);

    }
    public static void salida(){
        System.out.println("vuelva pronto");
        System.exit(0);


    }




}
