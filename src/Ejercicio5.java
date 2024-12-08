/* 
 * Ejercicio 5 - Control de Calidad en una Fábrica de Electrónica (Avanzado)
Eres el analista de calidad en una fábrica de productos electrónicos. 
La fábrica produce distintos tipos de dispositivos, y cada lote de producción
 pasa por varias inspecciones de calidad para asegurar que cumple con los estándares.
  La información sobre los dispositivos y los resultados de las inspecciones está 
  organizada en listas separadas, y tu tarea es realizar un análisis que ayude a 
  mejorar la eficiencia y a identificar problemas de calidad.

1. Datos de Entrada
Lista de Productos: Cada entrada en esta lista contiene el nombre del producto, 
el número de lote, y el nivel de complejidad en una escala del 1 al 10. El nivel
 de complejidad afecta la probabilidad de fallos en el producto final. Formato: 
 "nombre_producto,lote,complejidad".
List<String> productos = Arrays.asList(
    "TabletX,LoteA,8",
    "SmartphoneY,LoteB,7",
    "SmartwatchZ,LoteC,6",
    "LaptopW,LoteD,9",
    "TabletX,LoteE,8"
);
2. Lista de Inspecciones: Cada entrada en esta lista contiene el número de lote,
 el tipo de inspección realizada (por ejemplo, “funcionalidad” o “seguridad”), 
 y el porcentaje de muestras aprobadas en dicha inspección. Formato: "lote,tipo_inspección,
 porcentaje_aprobación".
List<String> inspecciones = Arrays.asList(
    "LoteA, funcionalidad, 85",
    "LoteB, seguridad, 92",
    "LoteC, funcionalidad, 75",
    "LoteD, seguridad, 60",
    "LoteA, seguridad, 88",
    "LoteC, seguridad, 82",
    "LoteB, funcionalidad, 80"
);
3. Lista de Fallos Detectados: Esta lista contiene el número de lote, 
el tipo de fallo detectado (por ejemplo, “sobrecalentamiento”, “falla de pantalla”)
 y el número de fallos encontrados en el lote. Formato: "lote,tipo_fallo,cantidad_fallos".
List<String> fallos = Arrays.asList(
    "LoteA, sobrecalentamiento, 3",
    "LoteB, pantalla, 5",
    "LoteC, batería, 2",
    "LoteD, sobrecalentamiento, 7",
    "LoteA, pantalla, 2"
);
Tareas
1. Calcular el Índice de Aprobación por Lote: Para cada lote, calcula el índice
 total de aprobación combinando los porcentajes de todas las inspecciones realizadas.
  Muestra los lotes que tienen un índice de aprobación inferior al 80%, ya que requieren 
  atención inmediata.
2. Identificar Lotes con Complejidad Alta y Baja Aprobación: Filtra y muestra los lotes
 que tienen un nivel de complejidad superior a 7 y un índice de aprobación inferior al 85%.
  Estos lotes presentan un mayor riesgo de fallos y deben ser priorizados en el control de 
  calidad.
3. Analizar los Tipos de Fallos Frecuentes: Cuenta la cantidad de cada tipo de fallo 
en todos los lotes y muestra los fallos más frecuentes (por ejemplo, los que aparecen en 
al menos 3 lotes). Esto ayuda a identificar problemas comunes en la cadena de producción.
4. Obtener el Lote con Mayor Incidencia de Fallos: Determina cuál es el lote que tiene
 la mayor cantidad total de fallos detectados. Muestra el nombre del producto y el tipo
  de fallo más frecuente en dicho lote.
5. Evaluar la Calidad Promedio por Tipo de Inspección: Calcula el promedio de aprobación
 de cada tipo de inspección (funcionalidad, seguridad, etc.). Identifica cuál tipo de 
 inspección tiene la aprobación promedio más baja y puede necesitar ajustes en los 
 criterios de prueba o procesos de inspección.
6. Identificar Lotes con Fallos Críticos en Inspecciones Clave: Supón que cualquier 
fallo en la inspección de "seguridad" con una aprobación inferior al 75% es crítico. 
Encuentra estos lotes y el tipo de fallo asociado para tomar medidas urgentes.
7. Simulación de Mejora de Procesos: Supón que la fábrica implementa una mejora
 que aumenta un 5% el índice de aprobación en todos los lotes de complejidad mayor a 7. 
 Realiza una simulación y muestra cómo cambiarían los resultados en los índices de
  aprobación después de esta mejora.
 */

public class Ejercicio5 {
    
}
