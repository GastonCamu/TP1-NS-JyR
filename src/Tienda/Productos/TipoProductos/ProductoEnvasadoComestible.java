package Tienda.Productos.TipoProductos;

import java.time.LocalDate;

public class ProductoEnvasadoComestible extends ProductoEnvasado{
    private int calorias;
    private LocalDate fechaVencimiento;

    public ProductoEnvasadoComestible(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
            TipoEnvase tipoEnvase,
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
        StringBuilder sb = new StringBuilder();
        if (porcentajeGanancia > 20) {
            sb.append("Producto:").append(getIdentificador()).append(" Error: el procentaje de ganancia excede del 20%");
            System.out.println(sb.toString());
            System.out.println("El porcentaje de ganancia se establecera en 20%");
            return 20;
        }
        else {
            return porcentajeGanancia;
        }
    }
}

