package Tienda;

public abstract class Menu {
    public static void mostrarMenuPrincipal() {
        System.out.println("Bienvenido a la KWIK-E-MART");
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1: Cargar o generar producto");
        System.out.println("2: Salir del programa");
    }

    public static void mostrarMenuCargarProducto() {
        System.out.println("1: Cargar producto manualmente");
        System.out.println("2: Generar productos aleatorios");
        System.out.println("3: Volver atras");
    }


    public static void mensajeSalida() {
        System.out.println("******************************************");
        System.out.println("Esta saliendo del programa");
        System.out.println("******************************************");
    }
    public static void mensajeErrorOpcion() {
        System.out.println("******************************************");
        System.out.println("Opción no válida, intente nuevamente");
        System.out.println("******************************************");
    }
}
