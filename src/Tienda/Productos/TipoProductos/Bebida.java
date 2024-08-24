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
                porcentajeGanancia);

        if (identificador.length() == 3) {
            this.identificador = "AC" + identificador;
        }
        else {
            System.out.println("El identificador solo admite 3 numeros");
        }
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
            StringBuilder sb = new StringBuilder();
            sb.append("Producto:").append(getIdentificador()).append(" Error: el grado de alcohol no puede ser negativo");
            System.out.println(sb.toString());
            return 0;
        }
    }

    @Override
    public double aplicarDescuento(float porcentajeDescuento) {
        if (porcentajeDescuento <= 10) {
            return super.aplicarDescuento(porcentajeDescuento);
        }
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("Producto:").append(getIdentificador()).append(" Error: el porcentaje de descuento no puede ser mayor al 10%");
            System.out.println(sb.toString());
            System.out.println("Se establecera sin descuento");
            return super.aplicarDescuento(0);

        }

    }

}
