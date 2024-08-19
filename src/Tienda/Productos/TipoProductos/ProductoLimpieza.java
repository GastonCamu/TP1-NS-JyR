package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class ProductoLimpieza extends Producto {
    private TipoAplicacionLimpieza tipoDeAplicacion;

    public ProductoLimpieza(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
            double porcentajeGanancia,
            boolean disponible,
            TipoAplicacionLimpieza tipoDeAplicacion)
    {
        super(
                identificador,
                descripcion,
                stock,
                precioUnitario,
                porcentajeGanancia,
                disponible);

        this.identificador = "AZ" + identificador;
        this. tipoDeAplicacion = tipoDeAplicacion;

    }
}
