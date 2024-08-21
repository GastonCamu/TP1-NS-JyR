package Tienda.Productos;

public abstract class Producto {

    protected String identificador;
    private String descripcion;
    private int stock;
    private double precioUnitario;
    private double porcentajeGanancia;
    private boolean disponible;

    public String getIdentificador() {
        return this.identificador;
    }
    public String getDescripcion() {
        return  this.descripcion;
    }
    public int getStock() {
        return this.stock;
    }
    public double getPrecioUnitario() {
        return this.precioUnitario;
    }
    public double getPorcentajeGanancia() {
        return this.porcentajeGanancia;
    }
    public boolean getDisponible() {
        return this.disponible;
    }

    public Producto(
            String identificador,
            String descripcion,
            int stock,
            double precioUnitario,
            double porcentajeGanancia,
            boolean disponible
            )
    {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precioUnitario = precioUnitario;
        this.porcentajeGanancia = porcentajeGanancia;
        this.disponible = disponible;
    }

    public double aplicarDescuento(float porcentajeDescuento) {
        double precioFinal = this.precioUnitario - (this.precioUnitario * porcentajeDescuento);
        return precioFinal;
    }
    public void disponibleParaLaVenta() {
        this.disponible = true;
    }

    public void mostrarDatosProducto() {
        System.out.println("Identificador: "+ getIdentificador());
        System.out.println("Descripcion: "+ getDescripcion());
        System.out.println("Stock: "+ getStock());
        System.out.println("Precio Unitario: "+ getPrecioUnitario());
        System.out.println("Porcentaje ganancial: "+ getPorcentajeGanancia());
        if (this.disponible) {
            System.out.println("El producto esta disponible para la venta");
        } else {
            System.out.println("El producto no esta disponible para la venta");
        }
    }
}
