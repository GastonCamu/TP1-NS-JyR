package Tienda;

import Tienda.Productos.Producto;
import Tienda.Productos.TipoProductos.Bebida;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TestTienda {
    private Scanner scanner = new Scanner(System.in);
    private boolean salir = false;
    private boolean tiendaCreada = false;


    // Cambiar el sistema de menu actual por un submenu y agregar la opcion de instanciar la tienda con x valores

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
                    Tienda tienda = crearTienda();
                    tienda.mostrarDatosTienda();
                    tiendaCreada = true;
                    break;
                case 2:
//                    Tienda tienda = generarTienda();
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
                    Menu.mostrarMenuCargarProducto();
                    procesarMenuCargarProducto(obtenerOpcionUsuario());
                    break;
                case 2:
                    Menu.mensajeSalida();
                    this.salir = true;
                    break;
                default:
                    Menu.mensajeErrorOpcion();
            }
        }
        private void procesarMenuCargarProducto(int opcion) {
            switch (opcion) {
                case 1:
                    Menu.mostrarMenuCatProductos();
                    procesarMenuCatProductos(scanner.nextInt());
                    break;
                case 2:
                    break;
                case 3:
                    Menu.mensajeVolverAtras();
                    break;
                default:
                    Menu.mensajeErrorOpcion();
            }
        }
        private void procesarMenuCatProductos(int opcion) {
            switch (opcion) {
                case 1:
                    Bebida bebida = crearBebida();
                    bebida.mostrarDatosProducto();
                    break;
                default:
                    Menu.mensajeErrorOpcion();
            }
    }
    private Tienda crearTienda() {
        System.out.println("Ingrese el nombre de la tienda");
        scanner.nextLine(); // Limpia el buffer
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la cantidad maxima de stock");
        int cantidadMaximaStock = scanner.nextInt();

        // Se podria hacer un manejo de excepcion por si el usuario ingresa un . en vez de ,
        System.out.println("Ingrese la cantidad de saldo en la caja");
        float saldoCaja = scanner.nextFloat();

        return new Tienda(nombre, cantidadMaximaStock, saldoCaja);
    }
    private Producto cargarDatosProducto() {
        System.out.println("Ingrese el identificador (solo numeros y 3 como maximo)");
        String identificador = scanner.nextLine();

        System.out.println("Ingrese la descripcion");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el stock");
        int stock = scanner.nextInt();

        System.out.println("Ingrese el precio unitario");
        float precioUnitario = scanner.nextFloat();

        System.out.println("Ingrese el porcentaje de ganancia");
        float porcentajeGanancia = scanner.nextFloat();

        // Falta un manejo de error en caso de cualquier otra letra
        System.out.println("¿El producto se encuentra disponible para la venta? Y/N");
        boolean disponible = false;
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            disponible = true;
        }
        return new Producto(identificador, descripcion, stock, precioUnitario, porcentajeGanancia, disponible);
    }
    private Bebida crearBebida() {
        Producto producto = cargarDatosProducto();
        System.out.println("Ingrese el grado de alcohol");
        boolean importado = false;
        float gradoAlcohol = scanner.nextFloat();
        System.out.println("¿La bebida es importada? Y/N");
        if(scanner.nextLine().equalsIgnoreCase("Y")) {
            importado = true;
        }
        System.out.println("Ingrese las calorias");
        float calorias = scanner.nextFloat();

        LocalDate fechaVencimiento = null;
        boolean fechaValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!fechaValida) {
            try {
                System.out.println("Ingrese la fecha de vencimiento en formato dd/MM/yyyy: ");
                String inputFecha = scanner.nextLine();
                fechaVencimiento = LocalDate.parse(inputFecha, formatter);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Asegúrese de usar el formato dd/MM/yyyy.");
            }
        }
        return new Bebida(
                producto.getIdentificador(), producto.getDescripcion(), producto.getStock(),
                producto.getPrecioUnitario(), producto.getPorcentajeGanancia(), producto.getDisponible(),
                gradoAlcohol, importado, calorias, fechaVencimiento);
    }
}
