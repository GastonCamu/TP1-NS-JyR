package Tienda.Productos;

public class Producto {

    protected String identificador;
    private String descripcion;
    private int stock;
    private float precioUnitario;
    private float porcentajeGanancia;
    private boolean disponible;

    public String getIdentificador() {
        return identificador;
    }
    public float getPrecioUnitario() {
        return precioUnitario;
    }
    public int getStock() {
        return stock;
    }

    public Producto(
            String identificador,
            String descripcion,
            int stock,
            float precioUnitario,
            float porcentajeGanancia,
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

    public float aplicarDescuento(float porcentajeDescuento) {
        float precioFinal = this.precioUnitario - (this.precioUnitario * porcentajeDescuento);
        return precioFinal;
    }
    public void disponibleParaLaVenta() {
        this.disponible = true;
    }
}
