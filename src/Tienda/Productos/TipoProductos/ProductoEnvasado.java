package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class ProductoEnvasado extends Producto {
    private String tipoEnvase;
    private boolean importado;

    public ProductoEnvasado(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
            double porcentajeGanancia,
            boolean disponible,
            String tipoEnvase,
            boolean importado)
    {
        super(
                identificador,
                descripcion,
                stock,
                precioUnitario,
                porcentajeGanancia,
                disponible);

        this.identificador = "AB" + identificador;
    }
}
