package Tienda.Productos;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    Producto[] listaVentaProductos = new Producto[36];
    List<String> identificadoresDiferentes = new ArrayList<>();


    public void VentaProductos(Producto producto, int cantidad, List<Producto> productos) {

        int cantidadVendida = 0;
        if (cantidad <= 12 && validarExistenciaProducto(producto, productos) && validarStockProducto(cantidad, productos)) {
            if (identificadoresDiferentes.contains(producto.identificador)) {
                System.out.print("Solo se pueden agregar 3 productos diferentes.");
            }
            else {
                identificadoresDiferentes.add(producto.identificador);
                for (int i = 0; i < cantidad; i++) {
                    listaVentaProductos[cantidadVendida] = producto;
                    cantidadVendida++;
                }
            }
        }
    }
    public validarStockYExistencia(int cantidadAComprar, List<Producto> productos) {
       for (Producto producto : productos) {
           if (validarStockProducto(cantidadAComprar,producto.getStock()) && validarExistenciaProducto(producto)) {

           }
       }
    }
    public boolean validarStockProducto(int cantidadAComprar, int stockProducto) {
            if (cantidadAComprar <= stockProducto) {
                return true;
            }
            else {
            return false;
        }
    }
    public boolean validarExistenciaProducto(Producto productoAVender) {
            if (producto.getIdentificador().equals(productoAVender.getIdentificador())) {
                return true;
            }
            else {
                return false;
        }

    }
}
