import Tienda.Productos.TipoProductos.ProductoEnvasado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ejemplo
        ProductoEnvasado leche = new ProductoEnvasado("123","es una leche", 20, 1000, 10, false, "reciclable", false);
        ProductoEnvasado dentifrico = new ProductoEnvasado("342","es una pasta dental", 30, 2000, 15, false, "descartable", false);
        ProductoEnvasado galletasDulces = new ProductoEnvasado("435","es una galleta con chispas", 15, 999.99, 20, true, "reciclable", false);

        leche.mostrarDatosProducto();
        dentifrico.mostrarDatosProducto();
        galletasDulces.mostrarDatosProducto();
    }
}