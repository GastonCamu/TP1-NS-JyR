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

    public void AgregarProducto(Producto... productosAIngresar) {
        StringBuilder sb = new StringBuilder();
        for (Producto productoAIngresar: productosAIngresar) {
            int stockDisponible = this.cantMaximaStock - this.stockActual;
                if (productoAIngresar.getStock() <= stockDisponible ) {
                    boolean productoExiste = false;

                    for (Producto productoEnTienda : this.productos) {
                        if (productoEnTienda.getIdentificador().equals(productoAIngresar.getIdentificador())) {
                            sb.append("Producto:").append(productoAIngresar.getIdentificador())
                                    .append(" Error: ya existe un producto con el mismo identificador\n");
                            productoExiste = true;
                        }
                    }
                    if (!productoExiste) {
                        this.productos.add(productoAIngresar);
                        this.stockActual += productoAIngresar.getStock();
                        actualizarSaldoCajaPostCompra(productoAIngresar);
                        productoAIngresar.disponibleParaLaVenta();
                    }
                } else {
                    sb.append("Producto:").append(productoAIngresar.getIdentificador())
                            .append(" Error: no se pudo agregar a la tienda ya que se alcanzó el máximo de stock\n");
                }
        }
        System.out.println(sb.toString());
    }

    public void actualizarSaldoCajaPostCompra(Producto producto) {
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
    public void actualizarSaldoCajaPostVenta(float totalVenta) {
        this.saldoCaja += totalVenta;
    }
    public void actualizarStockPostVenta(List<String>identificadoresProductos, List<Integer> cantidadProductos) {
        for (int i = 0; i < cantidadProductos.size(); i++) {
            for (Producto producto : productos) {
                if (producto.getIdentificador().equalsIgnoreCase(identificadoresProductos.get(i))) {
                    producto.setStock(producto.getStock() - cantidadProductos.get(i));
                }
            }
            this.stockActual -= cantidadProductos.get(i);
        }
    }
    public void verificarDisponibilidadProducto() {
        for (Producto producto : productos) {
            if (producto.getStock() == 0) {
                producto.noDisponibleParaLaVenta();
            }
        }
    }

//    public List<String> obtenerComestiblesConMenorDescuento(float porcentajeDescuento) {
//        return productos.stream()
//                .filter(producto -> producto.isComestible() && !producto.isImportado())
//                .filter(producto -> producto.getDescuento() < porcentajeDescuento)
//                .sorted((p1, p2) -> Float.compare(p1.getPrecioUnitario(), p2.getPrecioUnitario()))
//                .map(producto -> producto.getDescripcion().toUpperCase())
//                .collect(Collectors.toList());
//    }

    public void mostrarDatosProductos() {
        for (Producto producto : productos) {
            producto.mostrarDatosProducto();
        }
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

    public Producto obtenerProducto(String identificador) {
        boolean productoEncontrado = false;
        for (Producto producto : this.productos) {
            if (producto.getIdentificador().equalsIgnoreCase(identificador)) {
                productoEncontrado = true;
                return producto;
            }
        }
        System.out.println("No se encontro ningun producto con ese identificador");
        return null;
    }
    public void mostrarDatosProducto(String identificador) {
        Producto producto = obtenerProducto(identificador);
        producto.mostrarDatosProducto();
    }
}
