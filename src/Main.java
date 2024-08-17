import Productos.Producto;
import Productos.TipoProductos.ProductoEnvasado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Ejemplo
        ProductoEnvasado leche = new ProductoEnvasado("123","es una leche", 20, 1000, 10, true, "descartable", false);
        System.out.print("EL identificador es: " + leche.getIdentificador());
    }
}