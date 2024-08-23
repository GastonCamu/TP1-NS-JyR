package Tienda;

public abstract class Menu {
    public static void mostrarMenuTienda() {
        StringBuilder sb = new StringBuilder();
        sb.append("1: Crear tienda manualmente\n")
            .append("2: Crear tienda de ejemplo (datos precargados)\n")
            .append("3: Salir del programa");
        System.out.println(sb.toString());
    }
    public static void mostrarMenuPrincipal() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seleccione una de las siguientes opciones:\n")
            .append("1: Generar Productos (datos precargados)\n")
            .append("2: Realizar una venta\n")
            .append("3: Mostrar producto por identificador\n")
            .append("4: Mostrar todos los productos\n")
            .append("5: Poner un producto disponible para la venta (identificador)\n")
            .append("6: Salir del programa");
        System.out.println(sb.toString());
    }


    public static void mensajeSalida() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************************************\n")
            .append("Esta saliendo del programa\n")
            .append("******************************************");
        System.out.println(sb.toString());
    }
    public static void mensajeErrorOpcion() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************************************\n")
            .append("Opción no válida, intente nuevamente\n")
            .append("******************************************");
        System.out.println(sb.toString());
    }
    public static void mensajeVolverAtras() {
        StringBuilder sb = new StringBuilder();
        sb.append("******************************************\n")
            .append("Volviendo atras\n")
            .append("******************************************");
        System.out.println(sb.toString());
    }
}

//    public static void mostrarMenuAplicacionLimpieza() {
//        System.out.println("Ingrese el tipo de aplicacion del producto");
//        System.out.println("1: COCINA");
//        System.out.println("2: BAÑO");
//        System.out.println("3: ROPA");
//        System.out.println("4: MULTIUSO");
//    }
//
//    public static void mostrarMenuCargarProducto() {
//        System.out.println("1: Cargar producto manualmente");
//        System.out.println("2: Generar productos (datos precargados)");
//        System.out.println("3: Volver atras");
//    }
//
//    public static void mostrarMenuCatProductos() {
//        System.out.println("1: Cargar Bebida");
//        System.out.println("2: Cargar Producto de limpieza");
//        System.out.println("3: Cargar Producto Envasado");
//        System.out.println("4: Volver atras");
//
//    }