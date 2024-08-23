package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class ProductoLimpieza extends Producto {
    private TipoAplicacionLimpieza tipoDeAplicacion;

    public ProductoLimpieza(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
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
        this.porcentajeGanancia = aplicarPorcentajeGanancia(porcentajeGanancia);

    }

    private float aplicarPorcentajeGanancia(float porcentajeGanancia) {
        StringBuilder sb = new StringBuilder();
        if (porcentajeGanancia > 25) {
            sb.append("Producto:").append(getIdentificador()).append("Error: el porcentaje de ganancia excede el maximo permitido (25%)");
            System.out.println(sb.toString());
            System.out.println(("Se establecera el porcentaje de ganancia en 0%"));
            return 0;
        }
        else if (porcentajeGanancia < 10) {
            if (this.tipoDeAplicacion.name().equals("COCINA") || this.tipoDeAplicacion.name().equals("MULTIUSO")) {
                return porcentajeGanancia;
            }
            else {
                sb.append("Producto:").append(getIdentificador()).append(" Error: el porcentaje de ganacia excede el minimo permitido (10%)");
                System.out.println(sb.toString());
                System.out.println(("Se establecera el porcentaje de ganancia en 0%"));
                return 0;
            }
        }
        return porcentajeGanancia;
    }
    @Override
    public double aplicarDescuento(float porcentajeDescuento) {
        StringBuilder sb = new StringBuilder();
        if (porcentajeDescuento <= 20) {
            return super.aplicarDescuento(porcentajeDescuento);
        }
        else {
            sb.append("Producto:").append(getIdentificador()).append(" Error: el porcentaje de descuento no puede ser mayor al 20%");
            System.out.println(sb.toString());
            System.out.println("Se establecera sin descuento");
            return super.aplicarDescuento(0);

        }

    }
}
