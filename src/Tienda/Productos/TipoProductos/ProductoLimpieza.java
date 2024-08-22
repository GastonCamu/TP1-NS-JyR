package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class ProductoLimpieza extends Producto {
    private TipoAplicacionLimpieza tipoDeAplicacion;

    public ProductoLimpieza(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
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
//    private float pruebaAplicarPorcentaje(float porcentaje) {
//        if ((this.tipoDeAplicacion.name() == "COCINA" || this.tipoDeAplicacion.name() == "MULTIUSO") && porcentaje > 25) {
//            System.out.print("Error: el porcentaje de ganancia excede el permitido para este tipo de producto");
//        } else if (porcentaje < 10 || porcentaje >25) {
//            System.out.print("Error: el porcentaje de ganancia no es el adecuado para este tipo de producto");
//        }
//        return porcentaje;
//    }

    private float aplicarPorcentajeGanancia(float porcentajeGanancia) {
        if (porcentajeGanancia > 25) {
            System.out.print(("Error: El porcentaje de ganancia excede el maximo permitido (25%)"));
            System.out.print(("Se establecera el porcentaje de ganancia en 0%"));
            return 0;
        }
        else if (porcentajeGanancia < 10) {
            if (this.tipoDeAplicacion.name().equals("COCINA") || this.tipoDeAplicacion.name().equals("MULTIUSO")) {
                return porcentajeGanancia;
            }
            else {
                System.out.print(("Error: El porcentaje de ganancia excede el minimo permitido (10%)"));
                System.out.print(("Se establecera el porcentaje de ganancia en 0%"));
                return 0;
            }
        }
        return porcentajeGanancia;
    }
    @Override
    public double aplicarDescuento(float porcentajeDescuento) {
        if (porcentajeDescuento <= 20) {
            return super.aplicarDescuento(porcentajeDescuento);
        }
        else {
            System.out.print("Error: el porcentaje de descuento no puede ser mayor al 20%");
            System.out.print("Se establecera sin descuento");
            return super.aplicarDescuento(0);

        }

    }
}
