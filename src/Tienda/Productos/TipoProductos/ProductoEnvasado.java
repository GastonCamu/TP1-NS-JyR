package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

public class ProductoEnvasado extends Producto {
    private String tipoEnvase;
    protected boolean importado;

    public ProductoEnvasado(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
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
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

    @Override
    public boolean isImportado() {
        return importado;
    }

    @Override
    public double aplicarDescuento(float porcentajeDescuento) {
        if (porcentajeDescuento <= 15) {
            return super.aplicarDescuento(porcentajeDescuento);
        }
        else {
            System.out.print("Error: el porcentaje de descuento no puede ser mayor al 15%");
            System.out.print("Se establecera sin descuento");
            return super.aplicarDescuento(0);

        }

    }
}
