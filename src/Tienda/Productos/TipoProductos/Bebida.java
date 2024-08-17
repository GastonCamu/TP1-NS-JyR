package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class Bebida extends Producto{
    private float gradoAlcohol;
    private boolean importado;

    public Bebida(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
            boolean disponible,
            float gradoAlcohol,
            boolean importado)
    {
        super(
                identificador,
                descripcion,
                stock,
                precioUnitario,
                porcentajeGanancia,
                disponible);

        this.identificador = "AC" + identificador;
    }
}
