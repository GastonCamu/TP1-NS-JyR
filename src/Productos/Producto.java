package Productos;

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
}
