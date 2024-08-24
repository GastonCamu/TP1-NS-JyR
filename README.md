Uso de sistema:

Ejecutar el Main y saldrá un apartado de opciones.
En la opción 1 podrá crear la tienda manualmente ingresando todos los datos.
En la opción 2 se generará una tienda con datos precargados.
Y donde dice la opción salir, terminará el programa.
Una vez creada la tienda saldrán 5 opciones:
La opción 1, generar productos, genera productos con datos precargados que se encuentran en el archivo TestTienda.Java en la línea 114.
La opción 2 sirve para mostrar todos los productos
La opción 3 muestra un producto por identificador
La opción 4 permite agregar un nuevo producto a la venta
La opción 5 efectiviza la venta
La opción 6 cierra el sistema


Consideraciones:
1) Consideré que todos los productos vendidos tienen un descuento. No los asigné como atributos de los productos en sí sino que se calculan en la venta (falta ultimar detalles).
2) Consideré que dentro de los productos envasados pueden haber productos que no sean comestibles por lo que generé una clase hija ProductosEnvasadosComestibles
3) Creé dos enums, uno para los tipos de envases ya que pueden ser de diferentes materiales genéricos. El otro enum para tipo de aplicación para los productos de limpieza, ya que hay 4 en la narrativa y consideré que era más óptimo usar un enum (podría darle escalabilidad al programa).