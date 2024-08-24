package Tienda;

import Tienda.Productos.Producto;
import Tienda.Productos.TipoProductos.*;

import java.time.LocalDate;
import java.util.Scanner;

public class TestTienda {
    private Scanner scanner = new Scanner(System.in);
    private boolean salir = false;
    private boolean tiendaCreada = false;
    Venta venta = new Venta();
    Tienda tienda;


    public void iniciarMenu() {
        while (!salir) {
            if(!tiendaCreada) {
                Menu.mostrarMenuTienda();
                procesarMenuTienda(obtenerOpcionUsuario());
            } else {
                Menu.mostrarMenuPrincipal();
                procesarMenuPrincipal(obtenerOpcionUsuario());
            }
        }

        }
        private int obtenerOpcionUsuario() {
            System.out.println("Ingrese su opción: ");
            return scanner.nextInt();
        }
        private void procesarMenuTienda(int opcion) {
            switch (opcion) {
                case 1:
                    tienda = crearTienda();
                    tienda.mostrarDatosTienda();
                    tiendaCreada = true;
                    break;
                case 2:
                    tienda = generarTienda();
                    tienda.mostrarDatosTienda();
                    tiendaCreada = true;
                    break;
                case 3:
                    Menu.mensajeSalida();
                    this.salir = true;
                    break;
                default:
                    Menu.mensajeErrorOpcion();
            }
        }
        private void procesarMenuPrincipal(int opcion) {
            switch (opcion) {
                case 1:
                    generarProductos();
                    break;
                case 2:
                    tienda.mostrarDatosProductos();
                    break;
                case 3:
                    scanner.nextLine(); // Limpia el buffer
                    System.out.println("Ingrese el identificador del producto:");
                    tienda.mostrarDatosProducto(scanner.nextLine());
                    break;
                case 4:
                    scanner.nextLine(); // Limpia el buffer
                    System.out.println("Ingrese el identificador del producto a vender");
                    Producto producto = tienda.obtenerProducto(scanner.nextLine());
                    int cantidadAVender = scanner.nextInt();
                    if (cantidadAVender <= 12 && cantidadAVender > 0) {
                        venta.ventaProducto(producto, cantidadAVender);
                    }
                    else {
                        System.out.println("Tiene que ingresar en un rango entre 1 y 12");
                    }
                    break;
                case 5:
                    venta.finalizarVenta();
                    tienda.actualizarSaldoCajaPostVenta(venta.totalVenta);
                    tienda.actualizarStockPostVenta(venta.listaIdentificadoresDiferentes, venta.listaCantidadProductos);
                    tienda.verificarDisponibilidadProducto();
                    venta = new Venta();
                    break;
                case 6:
                    Menu.mensajeSalida();
                    this.salir = true;
                    break;
                default:
                    Menu.mensajeErrorOpcion();
                    break;
            }
        }

    private Tienda crearTienda() {
        System.out.println("Ingrese el nombre de la tienda");
        scanner.nextLine(); // Limpia el buffer
        String nombre = scanner.nextLine();

        int cantidadMaximaStock = obtenerValorIntPositivo("Ingrese la cantidad máxima de stock");

        float saldoCaja = obtenerValorFloatPositivo("Ingrese el saldo de caja (para los decimales utilice la ,)");

        return new Tienda(nombre, cantidadMaximaStock, saldoCaja);
    }
    private Tienda generarTienda() {
        String nombre = "KWIK-E-MART";
        int cantidadMaximaStock = 1000;
        float saldoCaja = 2000000f;

        return new Tienda(nombre, cantidadMaximaStock, saldoCaja);
    }

    private void generarProductos () {
        Bebida bebida1 = new Bebida("001", "coca-cola", 10, 1000.99f, 10, 0, false, 401, LocalDate.of(2024,10,20));
        Bebida bebida2 = new Bebida("002", "agua", 8, 699.99f, 15, 0, false, 0, LocalDate.of(2024,9,5));
        Bebida bebida3 = new Bebida("003", "vodka", 120, 1999.99f, 20, 13.5f, true, 200, LocalDate.of(2024,9,12));

        ProductoLimpieza productoLimpieza1 = new ProductoLimpieza("001", "escoba", 50, 1500.23f, 13, TipoAplicacionLimpieza.COCINA);
        ProductoLimpieza productoLimpieza2 = new ProductoLimpieza("002", "suavizante", 70, 1800.23f, 25, TipoAplicacionLimpieza.ROPA);
        ProductoLimpieza productoLimpieza3 = new ProductoLimpieza("003", "Detergente para baños", 20, 800.5f, 11, TipoAplicacionLimpieza.BANIO);

        ProductoEnvasado productoEnvasado1 = new ProductoEnvasado("001", "Shampoo", 60, 900.3f, 13.5f, TipoEnvase.PLASTICO, false);
        ProductoEnvasado productoEnvasado2 = new ProductoEnvasado("002", "Desodorante", 40, 852.6f, 14f, TipoEnvase.ALUMINIO, true);
        ProductoEnvasadoComestible productoEnvasadoComestible1 = new ProductoEnvasadoComestible("003", "Lata de arvejas", 80, 999f, 15f, TipoEnvase.CARTON, false, 321, LocalDate.of(2024,11,23));
        ProductoEnvasadoComestible productoEnvasadoComestible2 = new ProductoEnvasadoComestible("004", "Pure de tomate", 35, 360f, 8f, TipoEnvase.CARTON, false, 421, LocalDate.of(2024,11,26));

        tienda.AgregarProducto(bebida1, bebida2, bebida3,
                productoLimpieza1, productoLimpieza2, productoLimpieza3,
                productoEnvasado1, productoEnvasado2,
                productoEnvasadoComestible1, productoEnvasadoComestible2);
    }

    private int obtenerValorIntPositivo(String mensaje) {
        int valor;
        do {
            System.out.println(mensaje);
            valor = scanner.nextInt();
            if (valor <= 0) {
                System.out.println("El valor debe ser mayor a 0. Intente nuevamente");
            }
        } while (valor <= 0);
        return valor;
    }

    private float obtenerValorFloatPositivo(String mensaje) {
        float valor;
        do {
            System.out.println(mensaje);
            valor = scanner.nextFloat();
            if (valor <= 0) {
                System.out.println("El valor debe ser mayor a 0. Intente nuevamente");
            }
        } while (valor <= 0);
        return valor;
    }




//    private Producto cargarDatosProducto() {
//        System.out.println("Ingrese el identificador (solo numeros y 3 como maximo)");
//        scanner.nextLine(); // Limpia el buffer
//        String identificador = scanner.nextLine();
//        System.out.println("Ingrese la descripcion");
//        String descripcion = scanner.nextLine();
//
//        System.out.println("Ingrese el stock");
//        int stock = scanner.nextInt();
//
//        System.out.println("Ingrese el precio unitario");
//        float precioUnitario = scanner.nextFloat();
//
//        System.out.println("Ingrese el porcentaje de ganancia");
//        float porcentajeGanancia = scanner.nextFloat();
//
//        // Falta un manejo de error en caso de cualquier otra letra
//        System.out.println("¿El producto se encuentra disponible para la venta? Y/N");
//        scanner.nextLine(); // Limpia el buffer
//        boolean disponible = false;
//        if (scanner.nextLine().equalsIgnoreCase("Y")) {
//            disponible = true;
//        }
//        return new Producto(identificador, descripcion, stock, precioUnitario, porcentajeGanancia, disponible);
//    }
//    private Bebida crearBebida() {
//        Producto producto = cargarDatosProducto();
//        boolean importado = false;
//        LocalDate fechaVencimiento = null;
//        boolean fechaValida = false;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        System.out.println("Ingrese el grado de alcohol");
//        float gradoAlcohol = scanner.nextFloat();
//
//        scanner.nextLine(); // Limpia el buffer
//        if(scanner.nextLine().equalsIgnoreCase("Y")) {
//            importado = true;
//        }
//
//        System.out.println("Ingrese las calorias");
//        float calorias = scanner.nextFloat();
//
//        while (!fechaValida) {
//            try {
//                System.out.println("Ingrese la fecha de vencimiento en formato dd/MM/yyyy: ");
//                scanner.nextLine(); // Limpia el buffer
//                String inputFecha = scanner.nextLine();
//
//                fechaVencimiento = LocalDate.parse(inputFecha, formatter);
//                fechaValida = true;
//            } catch (DateTimeParseException e) {
//                System.out.println("Fecha no válida. Asegúrese de usar el formato dd/MM/yyyy.");
//            }
//        }
//        return new Bebida(
//                producto.getIdentificador(), producto.getDescripcion(), producto.getStock(),
//                producto.getPrecioUnitario(), producto.getPorcentajeGanancia(), producto.getDisponible(),
//                gradoAlcohol, importado, calorias, fechaVencimiento);
//    }
//
//    private ProductoLimpieza crearProductoLimpieza() {
//        TipoAplicacionLimpieza tipo = TipoAplicacionLimpieza.NINGUNO;
//        Producto producto = cargarDatosProducto();
//        Menu.mostrarMenuAplicacionLimpieza();
//        // no funciona, revisar
//        switch (scanner.nextInt()) {
//            case 1:
//                tipo = TipoAplicacionLimpieza.COCINA;
//                break;
//            case 2:
//                tipo = TipoAplicacionLimpieza.BANIO;
//                break;
//            case 3:
//                tipo = TipoAplicacionLimpieza.ROPA;
//                break;
//            case 4:
//                tipo = TipoAplicacionLimpieza.MULTIUSO;
//                break;
//            default:
//                Menu.mensajeErrorOpcion();
//        }
//        return new ProductoLimpieza(
//                producto.getIdentificador(), producto.getDescripcion(), producto.getStock(),
//                producto.getPrecioUnitario(), producto.getPorcentajeGanancia(), producto.getDisponible(),
//                tipo
//                );
//    }
//    private String obtenerValorYoN(String mensaje) {
//        String valor;
//        boolean continuar = true;
//        do {
//            System.out.println(mensaje);
//            valor = scanner.nextLine();
//            if (!valor.equalsIgnoreCase("Y") && !valor.equalsIgnoreCase("N")) {
//                System.out.println("Formato invalido ingrese Y para si y N para no");
//            } else { continuar = false; }
//        } while (continuar);
//
//        return valor;
//    }
}

//        private void procesarMenuCargarProducto(int opcion) {
//            switch (opcion) {
//                case 1:
//                    Menu.mostrarMenuCatProductos();
//                    procesarMenuCatProductos(scanner.nextInt());
//                    break;
//                case 2:
//                    generarProductos();
//                    break;
//                case 3:
//                    Menu.mensajeVolverAtras();
//                    break;
//                default:
//                    Menu.mensajeErrorOpcion();
//            }
//        }
//        private void procesarMenuCatProductos(int opcion) {
//            switch (opcion) {
//                case 1:
//                    Bebida bebida = crearBebida();
//                    this.tienda.AgregarProducto(bebida);
//                    System.out.println("Productos en la tienda: "+tienda.getCantidadProductos());
//                    break;
//                case 2:
//                    ProductoLimpieza productoLimpieza = crearProductoLimpieza();
//                    this.tienda.AgregarProducto(productoLimpieza);
//                    System.out.println("Productos en la tienda: "+tienda.getCantidadProductos());
//                    break;
//                case 3:
////                    ProductoEnvasado productoEnvasado = crearProductoEnvasado();
////                    this.tienda.AgregarProducto(productoEnvasado);
//                    System.out.println("Productos en la tienda: "+tienda.getCantidadProductos());
//                    break;
//                default:
//                    Menu.mensajeErrorOpcion();
//            }
//    }