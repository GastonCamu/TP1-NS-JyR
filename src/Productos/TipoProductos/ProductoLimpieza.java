package Productos.TipoProductos;

import Productos.Producto;

public class ProductoLimpieza extends Producto {
    public ProductoLimpieza(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
            boolean disponible)
    {
        super(
                identificador,
                descripcion,
                stock,
                precioUnitario,
                porcentajeGanancia,
                disponible);

        this.identificador = "AZ" + identificador;
    }
}
