package Tienda;

import Tienda.Productos.Producto;
import Tienda.Productos.TipoProductos.Bebida;

import java.util.Scanner;

public class TestTienda {
    private Scanner scanner = new Scanner(System.in);
    boolean salir = false;

    public void iniciarMenu() {
        while (!salir) {
            Menu.mostrarMenuPrincipal();
            procesarMenuPrincipal(obtenerOpcionUsuario());
        }

        }

        private int obtenerOpcionUsuario() {
            System.out.println("Ingrese su opción: ");
            return scanner.nextInt();
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
                    break;
                default:
                    Menu.mensajeErrorOpcion();
            }
    }
    private Producto cargarDatosProducto() {
        System.out.println("Ingrese el identificador (solo numeros y 3 como maximo)");
        String identificador = scanner.nextLine();
        String descripcion = scanner.nextLine();
        int stock = scanner.nextInt();
        float precioUnitario = scanner.nextFloat();
        float porcentajeGanancia = scanner.nextFloat();
        boolean disponible = false;
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            disponible = true;
            return new Producto(identificador, descripcion, stock, precioUnitario, porcentajeGanancia, disponible);
        }
    }
    private Bebida crearBebida() {
        Producto producto = cargarDatosProducto();
        System.out.println("Ingrese tal cosa de bebida"); // me quede aqui
    })
}
