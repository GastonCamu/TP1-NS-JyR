package Tienda.Productos.TipoProductos;

import java.time.LocalDate;

public class ProductoEnvasadoComestible extends ProductoEnvasado{
    private int calorias;
    private LocalDate fechaVencimiento;

    public ProductoEnvasadoComestible(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
            double porcentajeGanancia,
            boolean disponible,
            String tipoEnvase,
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
                disponible,
                tipoEnvase,
                importado);

    }

}

