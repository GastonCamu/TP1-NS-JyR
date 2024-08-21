package Tienda.Productos;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    Producto[] listaVentaProductos = new Producto[36];
    List<String> identificadoresDiferentes = new ArrayList<>();
    int cantidadVendida = 0;
    float totalVenta;

    public void VentaProductos(Producto producto, int cantidad) {
        if (cantidad <= 12 && validarStockProducto(producto, cantidad)) {

            if (identificadoresDiferentes.size() < 3 && !identificadoresDiferentes.contains(producto.identificador)) {
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
    }

    public boolean validarStockProducto(Producto producto, int cantidadAVender) {
        return cantidadAVender <= producto.getStock();
    }

}
