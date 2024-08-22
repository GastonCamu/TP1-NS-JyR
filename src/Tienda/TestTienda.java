package Tienda;

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
                    break;
            }
        }
        private void procesarMenuCargarProducto(int opcion) {
        switch (opcion) {
            case 1:

        }
        }
    }