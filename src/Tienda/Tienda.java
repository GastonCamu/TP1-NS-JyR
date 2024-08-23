package Tienda;

import Tienda.Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private int cantMaximaStock;
    private int stockActual = 0;
    private float saldoCaja;
    private List<Producto> productos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public int getCantMaximaStock() {
        return cantMaximaStock;
    }

    public int getStockActual() {
        return stockActual;
    }

    public float getSaldoCaja() {
        return saldoCaja;
    }

    public int getCantidadProductos() {
        return productos.size();
    }

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
    // Funcion en evaluacion, sirve para traer todos los productos con una suposicion del descuento que se les puede aplicar.
    public String obtenerComestiblesConMenorDescuentoYNoImportados(float porcentajeDescuento) {
        return productos.stream()
                .filter(producto -> producto.isComestible() && !producto.isImportado())
                .filter(producto -> !producto.isImportado())
                .filter(producto -> producto.aplicarDescuento(porcentajeDescuento) < producto.getPrecioUnitario())
                .sorted((p1, p2) -> Double.compare(p1.getPrecioUnitario(), p2.getPrecioUnitario()))
                .map(producto -> producto.getDescripcion().toUpperCase())
                .toList().toString();
    }

    public void mostrarDatosTienda() {
        System.out.println("-------------------------------------------");
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Cantidad maxima de stock: "+ getCantMaximaStock());
        System.out.println("Stock Actual: "+ getStockActual());
        System.out.println("Saldo de la caja: "+ getSaldoCaja());
        System.out.println("cantidad de productos en la tienda: "+ getCantidadProductos());
        System.out.println("-------------------------------------------");
    }
}
