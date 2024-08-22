package Tienda.Productos;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    Producto[] listaVentaProductos = new Producto[36];
    List<String> identificadoresDiferentes = new ArrayList<>();
    int cantidadVendida = 0;
    float totalVenta;

    // validar que la cantidad ingresada sea menor a 12 desde el menu
    public void VentaProductos(Producto producto, int cantidad) {
        if (producto.getDisponible()) {
            int cantidadProductoDisponible = validarStockDisponible(producto, cantidad);
                if (validar3ProductosDiferentes(producto)) {
                    identificadoresDiferentes.add(producto.identificador);
                    for (int i = 0; i < cantidad; i++) {
                        if (cantidadVendida < listaVentaProductos.length) {
                            listaVentaProductos[cantidadVendida] = producto;
                            cantidadVendida++;
                        } else {
                            System.out.print("Se alcanzó el límite maximo de productos");
                        }
                    }
                } else {
                    System.out.print("Solo puede comprar hasta 3 productos diferentes");
                }
        }
        else {
            System.out.print("El producto: " + producto.identificador + " " + producto.getDescripcion() + " no se encuentra disponible");
        }

    }

    public int validarStockDisponible(Producto producto, int cantidad) {
        if((producto.getStock() - cantidad) < 0) {
            System.out.print("Hay productos con stock disponible menor al solicitado");
            return producto.getStock();
        }
        else {
            return cantidad;
        }
    }
    public boolean validar3ProductosDiferentes(Producto producto) {
        return identificadoresDiferentes.size() < 3 && !identificadoresDiferentes.contains(producto.identificador);
    }

}
