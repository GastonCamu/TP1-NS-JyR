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
            float porcentajeGanancia,
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

        this.porcentajeGanancia = aplicarPorcentajeGanancia(porcentajeGanancia);
    }

    @Override
    public boolean isComestible() {
        return super.isComestible();
    }

    @Override
    public boolean isImportado() {
        return importado;
    }

    private float aplicarPorcentajeGanancia(float porcentajeGanancia) {
        if (porcentajeGanancia > 20) {
            System.out.print("Error: el porcentaje de ganancia excede del 20%");
            System.out.print("El porcentaje de ganancia se establecera en 20%");
            return 20;
        }
        else {
            return porcentajeGanancia;
        }
    }
}

