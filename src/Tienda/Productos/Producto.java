package Tienda.Productos;

public class Producto {

    protected String identificador;
    private String descripcion;
    private int stock;
    private float precioUnitario;
    protected float porcentajeGanancia;
    private boolean disponible = false;

    public String getIdentificador() {
        return this.identificador;
    }
    public String getDescripcion() {
        return  this.descripcion;
    }
    public int getStock() {
        return this.stock;
    }
    public float getPrecioUnitario() {
        return this.precioUnitario;
    }
    public float getPorcentajeGanancia() {
        return this.porcentajeGanancia;
    }
    public boolean getDisponible() {
        return this.disponible;
    }

    public void setStock(int stock) { this.stock = stock; }

    public Producto(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia
            )
    {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public boolean isComestible() {
        return false;
    }

    public boolean isImportado() {
        return false;
    }

    public double aplicarDescuento(float porcentajeDescuento) {
        double precioFinal = this.precioUnitario - (this.precioUnitario * (porcentajeDescuento / 100));
        return precioFinal;
    }

    // (puede ser tambien un override)
    public double aplicarImpuesto(boolean importado) {
        if (importado) {
            double precioFinal = this.precioUnitario + (this.precioUnitario * (12f / 100));
            return precioFinal;
        }
        return precioUnitario;
    }

    public void disponibleParaLaVenta() {
        this.disponible = true;
    }
    public void noDisponibleParaLaVenta() {this.disponible = false;}

    public void mostrarDatosProducto() {
        StringBuilder sb = new StringBuilder();
            sb.append("-------------------------------------------\n")
            .append("Identificador: ").append(getIdentificador()).append("\n")
            .append("Descripcion: ").append(getDescripcion()).append("\n")
            .append("Stock: ").append(getStock()).append("\n")
            .append("Precio unitario: ").append(getPrecioUnitario()).append("\n")
            .append("Porcentaje ganancial: ").append(getPorcentajeGanancia()).append("\n");
        if (getDisponible()) {
            sb.append("Disponible para la venta\n");
        } else {
            sb.append("No esta disponible para la venta\n");
        }
            sb.append("-------------------------------------------");
        System.out.println(sb.toString());
    }
}
