package Tienda.Productos;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int cantMaximaStock;
    private int stockActual = 0;
    private double saldoCaja;
    private List<Producto> productos = new ArrayList<>();

    public Tienda(String nombre, int cantMaximaStock, float saldoCaja) {
        this.nombre = nombre;
        this.cantMaximaStock = cantMaximaStock;
        this.saldoCaja = saldoCaja;
    }

    public void AgregarProducto(Producto producto) {
        int stockDisponible = this.cantMaximaStock - this.stockActual;
        if (producto.getStock() <= stockDisponible) {
            this.productos.add(producto);
            this.stockActual += producto.getStock();
            actualizarSaldoCaja(producto);
            producto.disponibleParaLaVenta();
        } else {
            System.out.print("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock");
            System.out.print("Stock disponible: " + stockDisponible);
        }
    }

    public void actualizarSaldoCaja(Producto producto) {
        double costoTotalProducto = producto.getPrecioUnitario() * producto.getStock();

        if (costoTotalProducto > this.saldoCaja) {
            System.out.print("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja");
        } else {
            this.saldoCaja -= costoTotalProducto;
        }
    }

    public void VentaProductos(Producto producto, int cantidad) {
        Producto[] listaVentaProductos = new Producto[36];
        int cantidadVendida = 0;
        if (validarExistenciaProducto(producto) && validarStockProducto(cantidad)) {
            for (int i = 0; i < cantidad; i++) {
                listaVentaProductos[cantidadVendida] = producto;
                cantidadVendida++;
            }
        }
    }

    public boolean validarStockProducto(int cantidad) {
        for (Producto producto : productos) {
            if (cantidad <= producto.getStock()) {
                return true;
            }
        }
        return false;
    }
    public boolean validarExistenciaProducto(Producto productoAVender) {
        for (Producto producto : productos) {
            if (producto.getIdentificador().equals(productoAVender.getIdentificador())) {
                return true;
            }
        }
        return false;
    }
}
