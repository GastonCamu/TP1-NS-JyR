package Tienda;

import Tienda.Productos.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Venta {
    List<Producto> listaProductosVenta = new ArrayList<>();
    List<String> listaIdentificadoresDiferentes = new ArrayList<>();
    List<Integer> listaCantidadProductos = new ArrayList<>();
    float totalVenta;

    public void ventaProducto(Producto producto, int cantidad) {
        StringBuilder sb = new StringBuilder();
        if (producto.getDisponible()) {
            int cantidadProductoDisponible = validarStockDisponible(producto, cantidad);
            if(cantidad <= cantidadProductoDisponible) {
                if (validar3ProductosDiferentes(producto)) {
                    listaIdentificadoresDiferentes.add(producto.getIdentificador());
                    listaProductosVenta.add(producto);
                    listaCantidadProductos.add(cantidad);
                    System.out.println("Se agrego correctamente el producto");

                } else {
                    System.out.println("No puede ingresar el mismo producto ni excederse de 3 productos diferentes");
                }
            }
            else {
                System.out.println("No hay stock suficiente");
            }

        } else {
            sb.append("Producto:").append(producto.getIdentificador())
                    .append(" ").append(producto.getDescripcion())
                    .append(" no se encuentra disponible");
            System.out.println(sb.toString());
        }

    }
    public void finalizarVenta() {
        for (int i = 0; i < listaCantidadProductos.size(); i++) {
            System.out.println(listaIdentificadoresDiferentes.get(i)+ "-" +
                    obtenerDescripcionProducto(listaIdentificadoresDiferentes.get(i)) + " "+ listaCantidadProductos.get(i)+ " X " + obtenerPrecioUnitario(listaIdentificadoresDiferentes.get(i)));
        }
        calcularTotalVenta();
        System.out.println("Precio total: $"+ totalVenta);
    }
    public void calcularTotalVenta() {
        for (int i = 0; i < listaCantidadProductos.size(); i++) {
            totalVenta += listaCantidadProductos.get(i) *obtenerPrecioUnitario(listaIdentificadoresDiferentes.get(i));
        }
    }
    public float obtenerPrecioUnitario(String identificador) {
        for (Producto producto : listaProductosVenta) {
            if (producto.getIdentificador().equalsIgnoreCase(identificador)) {
                return producto.getPrecioUnitario();
            }
        }
        return 0;
    }
    public String obtenerDescripcionProducto(String identificador) {
        for (Producto producto : listaProductosVenta) {
            if (producto.getIdentificador().equalsIgnoreCase(identificador)) {
                return producto.getDescripcion();
            }
        }
        return null;
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
        return !listaIdentificadoresDiferentes.contains(producto.getIdentificador()) && listaIdentificadoresDiferentes.size() < 3;
    }

}
