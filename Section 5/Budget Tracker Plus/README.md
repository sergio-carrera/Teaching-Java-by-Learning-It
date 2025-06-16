# Budget Tracker Plus

Este programa en Java, denominado Budget Tracker Plus, permite a los usuarios gestionar y rastrear sus gastos mensuales. Ha sido diseñado para un control detallado del presupuesto personal, permitiendo agregar, actualizar y consultar registros de ingresos y gastos para años y meses específicos.

---

## 📌 Funcionalidades Principales

El programa ofrece un menú interactivo con las siguientes opciones:

- Añadir una nueva entrada: Registra los ingresos y gastos mensuales (alquiler, alimentos, transporte, entretenimiento) para un año y mes específicos.
- Actualizar una entrada existente: Permite modificar cualquier categoría de gasto o el ingreso de un registro ya existente.
- Imprimir entradas por año: Muestra todos los registros de un año determinado, con opciones para visualización normal o invertida.
- Imprimir entradas por mes: Muestra todos los registros de un mes específico, con opciones para visualización normal o invertida.
- Imprimir una entrada por año y mes: Muestra el detalle de un registro específico para un año y mes dados.
- Imprimir todas las entradas: Presenta el historial completo de todos los registros organizados por año y mes, con opciones para visualización normal o invertida.
- Cerrar el programa.

---

## 🔧 Estructura y Funcionamiento Personalizado

El BudgetTracker Plus utiliza una estructura de datos bidimensional (una matriz) para almacenar los registros de presupuestos mensuales (MonthlyCalculation). Esta matriz está diseñada para un rango específico de años y meses, permitiendo un acceso y gestión eficientes de los datos.

- Almacenamiento de Datos: Se utiliza un arreglo bidimensional (MonthlyCalculation[][] dataBase) para guardar los cálculos de cada mes.
  - Las filas del arreglo representan los años (2020-2024).
  - Las columnas representan los meses (1-12).
- Mapeo de Años y Meses: Se emplean HashMaps (yearToIndexMap y monthToIndexMap) para convertir los años y meses (valores de entrada del usuario) en los índices correspondientes del arreglo, facilitando el acceso directo a los registros.
- Validación de Entradas: Se realizan validaciones para asegurar que los años y meses ingresados estén dentro del rango permitido (2020-2024 para años, y 1-12 para meses). Además, se valida que los valores numéricos ingresados sean válidos.
- Manejo de Duplicados: Si se intenta añadir una entrada para un año y mes donde ya existe un registro, el programa pregunta al usuario si desea reemplazarlo.
- Cálculo de Presupuesto: Cada entrada no solo almacena los valores brutos, sino que también calcula automáticamente el total de gastos, el presupuesto restante y el porcentaje que cada categoría de gasto representa sobre el ingreso.

---

## 🧩 Clase `MonthlyCalculation`

Esta clase probablemente encapsula la siguiente información para cada entrada mensual:

- year: Año del registro.
- month: Mes del registro.
- income: Ingresos mensuales.
- rent: Gasto en alquiler.
- groceries: Gasto en alimentos.
- transportation: Gasto en transporte.
- entertainment: Gasto en entretenimiento.
- totalExpenses: Cálculo del total de gastos.
- remainingBudget: Cálculo del presupuesto restante (income - totalExpenses).
- rentPercentage: Porcentaje del ingreso dedicado al alquiler.
- groceriesPercentage: Porcentaje del ingreso dedicado a alimentos.
- transportationPercentage: Porcentaje del ingreso dedicado a transporte.
- entertainmentPercentage: Porcentaje del ingreso dedicado a entretenimiento.

En esta también se sobrescribe el método toString() para permitir la impresión formateada de los detalles de un registro mensual.

```java
@Override
public String toString() {
    return "Monthly calculation of year: " + year + " and month: " + month + "\n" +
            "Income: " + income + "\n" +
            "Rent expense: " + rent + "\n" +
            "Groceries expense: " + groceries + "\n" +
            "Transportation expense: " + transportation + "\n" +
            "Entertainment expense: " + entertainment + "\n" +
            "Total expenses: " + totalExpenses + "\n" +
            "Remaining budget: " + remainingBudget + "\n" +
            "Rent percentage: " + rentPercentage + "\n" +
            "Groceries percentage: " + groceriesPercentage + "\n" +
            "Transportation percentage: " + transportationPercentage + "\n" +
            "Entertainment percentage: " + entertainmentPercentage + "\n" +
            "----------------------------";
}
```

---

🧐 Métodos Implementados en clase `BudgetTracker`

- public BudgetTracker(): Constructor que inicializa los mapas de años y meses a índices, y el arreglo dataBase para almacenar 5 años y 12 meses.
- public void calculate(...): Recibe los datos de una nueva entrada, valida su formato, calcula los valores derivados (gastos totales, presupuesto restante, porcentajes) y llama al método add para insertar el registro.
- public void add(MonthlyCalculation registro): Inserta un objeto MonthlyCalculation en la dataBase (matriz) en la posición correspondiente al año y mes. Si la posición ya está ocupada, pregunta al usuario si desea sobrescribir el registro.
- private boolean revisarPorEspacio(MonthlyCalculation registro): Verifica si ya existe un registro en la posición especificada por el año y mes de la entrada.
- private boolean revisarPorFormato(...): Valida que los datos de entrada (año, mes, ingresos, gastos) estén en el formato correcto y dentro de los rangos válidos.
- private boolean isValidDouble(double value): Comprueba si un valor double es un número válido (no NaN ni infinito).
- public void updateMenu(int year, int month): Muestra un submenú para permitir al usuario seleccionar qué parte de un registro existente desea actualizar.
- private void update(MonthlyCalculation datoToUpdate, int opc): Dirige la actualización a los métodos específicos de actualización según la opción seleccionada por el usuario. Se utiliza la nueva sintaxis switch de Java (introducida en Java 14+).
- private void updateIncome(MonthlyCalculation datoToUpdate): Actualiza el ingreso y recalcula todos los valores dependientes (gastos totales, presupuesto restante, porcentajes).
- private void updateRent(MonthlyCalculation datoToUpdate): Actualiza el gasto en alquiler y recalcula los valores dependientes.
- private void updateGroceries(MonthlyCalculation datoToUpdate): Actualiza el gasto en alimentos y recalcula los valores dependientes.
- private void updateTransportation(MonthlyCalculation datoToUpdate): Actualiza el gasto en transporte y recalcula los valores dependientes.
- private void updateEntertainment(MonthlyCalculation datoToUpdate): Actualiza el gasto en entretenimiento y recalcula los valores dependientes.
- private double[] calculateNewValues(double[] values): Un método auxiliar que recalcula los gastos totales, presupuesto restante y porcentajes de gasto basado en los nuevos valores de ingreso y/o gastos.
- public void printByYear(int year, int opc): Imprime todas las entradas para un año dado, en formato normal o invertido.
- public void printByMonth(int month, int opc): Imprime todas las entradas para un mes dado, en formato normal o invertido.
- public void printByYearAndMonth(int year, int month): Imprime una entrada específica por año y mes.
- public void printAll(int opc): Imprime todas las entradas en la base de datos, en formato normal o invertido.
- private void printNormal(MonthlyCalculation[][] dataBase, int opc): Un método auxiliar para imprimir los registros en orden normal.
- private void printInverted(MonthlyCalculation[][] dataBase, int opc): Un método auxiliar para imprimir los registros en orden invertido.
- private void printSpecificYear(MonthlyCalculation[][] dataBase, int year, int opc): Un método auxiliar para imprimir los registros de un año específico en el formato deseado.
- private void printSpecificMonth(MonthlyCalculation[][] dataBase, int month, int opc): Un método auxiliar para imprimir los registros de un mes específico en el formato deseado.

---

A manera de resumen, la versión personalizada Budget Tracker Plus es una aplicación robusta para la gestión de presupuestos, que demuestra el uso eficaz de arreglos bidimensionales y HashMaps para la organización de datos temporales, junto con una interfaz de usuario interactiva para la manipulación y consulta de registros financieros.
El reto en este ejercicio fue utilizar una matriz bidimensional como base de datos y HashMaps que me ayudasen a traducir las posiciones del `mes` y `año` en la matriz.
El código es un más amplio que los demás ejercicios, por eso mejor dejo este `README.md` con menos explicación paso a paso.
