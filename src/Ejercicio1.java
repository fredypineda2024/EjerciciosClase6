/*
 * Ejercicio 1 - Análisis de Ventas de una Tienda
Eres un analista de datos en una tienda de comercio electrónico. 
La tienda tiene un registro de todas las ventas realizadas durante 
el último mes. Cada venta está representada por una cadena de texto
 que contiene el nombre del producto, la cantidad vendida y el precio
  unitario, separados por comas. Tu tarea es procesar estos datos para 
  obtener información útil.

Los datos de entrada son una lista de cadenas de texto, donde cada cadena
 representa una venta en el formato: "producto,cantidad,precio_unitario".
  Por ejemplo:

List<String> ventas = Arrays.asList(
    "camisa,2,20.00",
    "pantalon,1,35.50",
    "zapatos,3,50.00",
    "camisa,1,20.00",
    "pantalon,2,35.50"
);
Tareas
1. Calcular el Ingreso Total: Calcula el ingreso total generado por todas las ventas.
2. Contar Ventas por Producto: Cuenta cuántas veces se vendió cada producto.
3. Filtrar Ventas Mayores a un Monto Específico: Filtra y muestra las ventas 
  cuyo ingreso total (cantidad * precio_unitario) sea mayor a un monto específico.
4. Obtener el Producto Más Vendido: Determina cuál fue el producto más vendido en 
términos de cantidad total.
 * 
 */

 import java.util.*;

 public class Ejercicio1 {
 
     public static void main(String[] args) {
         // 1. Definir la lista de ventas
         List<String> ventas = Arrays.asList(
             "camisa,2,20.00",
             "pantalon,1,35.50",
             "zapatos,3,50.00",
             "camisa,1,20.00",
             "pantalon,2,35.50"
         );
 
         // 2. Llamar a los métodos y mostrar resultados
         double ingresoTotal = calcularIngresoTotal(ventas);
         System.out.println("Ingreso total: $" + ingresoTotal);
 
         Map<String, Integer> ventasPorProducto = contarVentasPorProducto(ventas);
         System.out.println("Ventas por producto: " + ventasPorProducto);
 
         List<String> ventasFiltradas = filtrarVentasMayores(ventas, 50.00);
         System.out.println("Ventas mayores a $50.00: " + ventasFiltradas);
 
         String productoMasVendido = obtenerProductoMasVendido(ventas);
         System.out.println("Producto más vendido: " + productoMasVendido);
     }
 
     // Método 1: Calcular el ingreso total
     public static double calcularIngresoTotal(List<String> ventas) {
         double ingresoTotal = 0.0;
         for (String venta : ventas) {
             String[] partes = venta.split(","); // Separar por comas
             double cantidad = Double.parseDouble(partes[1]);
             double precioUnitario = Double.parseDouble(partes[2]);
             ingresoTotal += cantidad * precioUnitario; // Sumar al ingreso total
         }
         return ingresoTotal;
     }
 
     // Método 2: Contar ventas por producto
     public static Map<String, Integer> contarVentasPorProducto(List<String> ventas) {
         Map<String, Integer> contador = new HashMap<>();
         for (String venta : ventas) {
             String[] partes = venta.split(",");
             String producto = partes[0];
             int cantidad = Integer.parseInt(partes[1]);
             contador.put(producto, contador.getOrDefault(producto, 0) + cantidad); // Sumar cantidad
         }
         return contador;
     }
 
     // Método 3: Filtrar ventas mayores a un monto
     public static List<String> filtrarVentasMayores(List<String> ventas, double montoEspecifico) {
         List<String> ventasFiltradas = new ArrayList<>();
         for (String venta : ventas) {
             String[] partes = venta.split(",");
             double cantidad = Double.parseDouble(partes[1]);
             double precioUnitario = Double.parseDouble(partes[2]);
             double ingreso = cantidad * precioUnitario;
             if (ingreso > montoEspecifico) {
                 ventasFiltradas.add(venta); // Agregar venta a la lista si cumple
             }
         }
         return ventasFiltradas;
     }
 
     // Método 4: Obtener el producto más vendido
     public static String obtenerProductoMasVendido(List<String> ventas) {
         Map<String, Integer> contador = contarVentasPorProducto(ventas); // Reusar el método 2
         String productoMasVendido = "";
         int maxCantidad = 0;
         for (Map.Entry<String, Integer> entry : contador.entrySet()) {
             if (entry.getValue() > maxCantidad) {
                 productoMasVendido = entry.getKey();
                 maxCantidad = entry.getValue();
             }
         }
         return productoMasVendido;
     }
 }
 