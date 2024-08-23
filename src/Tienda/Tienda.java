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

    public String getNombre() { return nombre; }
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

    public void AgregarProducto(Producto... productos) {
        StringBuilder sb = new StringBuilder();
        for (Producto producto: productos) {
            int stockDisponible = this.cantMaximaStock - this.stockActual;
            if (producto.getStock() <= stockDisponible) {
                this.productos.add(producto);
                this.stockActual += producto.getStock();
                actualizarSaldoCaja(producto);
                producto.disponibleParaLaVenta();
            } else {
                sb.append("Producto:").append(producto.getIdentificador())
                    .append(" Error: no se pudo agregar a la tienda ya que se alcanzó el máximo de stock");
                System.out.println(sb.toString());
                System.out.println("Stock disponible: " + stockDisponible);
            }
        }
    }

    public void actualizarSaldoCaja(Producto producto) {
        float costoTotalProducto = producto.getPrecioUnitario() * producto.getStock();

        if (costoTotalProducto > this.saldoCaja) {
            StringBuilder sb = new StringBuilder();
            sb.append("Producto:").append(producto.getIdentificador())
                .append(" Error: el producto no podrá ser agregado a la tienda por saldo insuficiente en la caja");
            System.out.println(sb.toString());
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
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------\n")
            .append("Nombre: ").append(getNombre()).append("\n")
            .append("Cantidad maxima de stock: ").append(getCantMaximaStock()).append("\n")
            .append("Stock Actual: ").append(getStockActual()).append("\n")
            .append("Saldo de la caja: ").append(getSaldoCaja()).append("\n")
            .append("Cantidad de productos en la tienda: ").append(getCantidadProductos()).append("\n")
            .append("-------------------------------------------");
        System.out.println(sb.toString());
    }
}
