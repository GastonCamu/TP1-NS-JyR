package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

import java.time.LocalDate;

public class Bebida extends Producto{
    private float gradoAlcohol;
    private boolean importado;
    private int calorias;
    private LocalDate fechaVencimiento;

    public Bebida(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
            double porcentajeGanancia,
            boolean disponible,
            float gradoAlcohol,
            boolean importado,
            int calorias,
            LocalDate fechaVencimiento)
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
