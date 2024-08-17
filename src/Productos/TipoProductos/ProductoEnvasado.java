package Productos.TipoProductos;

import Productos.Producto;

public class ProductoEnvasado extends Producto {

    public ProductoEnvasado(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
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
