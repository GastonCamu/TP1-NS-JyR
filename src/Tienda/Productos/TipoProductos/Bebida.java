package Tienda.Productos.TipoProductos;

import Tienda.Productos.Producto;

import java.time.LocalDate;

public class Bebida extends Producto{
    private float gradoAlcohol;
    private boolean importado;
    private float calorias;
    private LocalDate fechaVencimiento;

    public Bebida(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
            boolean disponible,
            float gradoAlcohol,
            boolean importado,
            float calorias,
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
        this.gradoAlcohol = gradoAlcohol;
        this.importado = importado;
        this.calorias = calcularCalorias(calorias);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public boolean isComestible() {
        return true;
    }

    @Override
    public boolean isImportado() {
        return importado;
    }

    private float calcularCalorias(float calorias) {
        if (this.gradoAlcohol >= 0 && this.gradoAlcohol <= 2) {
            return calorias;
        }
        else if (this.gradoAlcohol > 2 && this.gradoAlcohol <= 4.5) {
            return calorias * 1.25f;
        }
        else if (this.gradoAlcohol > 4.5) {
            return  calorias * 1.5f;
        }
        else {
            System.out.print("Error: El grado de alcohol no puede ser negativo");
            return 0;
        }
    }

    @Override
    public double aplicarDescuento(float porcentajeDescuento) {
        if (porcentajeDescuento <= 10) {
            return super.aplicarDescuento(porcentajeDescuento);
        }
        else {
            System.out.print("Error: el porcentaje de descuento no puede ser mayor al 10%");
            System.out.print("Se establecera sin descuento");
            return super.aplicarDescuento(0);

        }

    }

}
