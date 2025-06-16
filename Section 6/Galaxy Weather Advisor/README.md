# Galaxy Weather Advisor: Interstellar Edition

Es un proyecto que simula a HAL 9000 como Galaxy Weather Advisor. Realiza calculaciones basadas en la temperatura planetaria  mediante una base de datos que permite a los usuarios añadir, actualizar y consultar información de forma interactiva y robusta. 

---

## 📌 Funcionalidades Originales del Ejercicio

El ejercicio base sentó las bases para este proyecto, requiriendo un programa Java que:

- Solicitara el nombre de un planeta (inicialmente Tierra, Marte, Venus, Júpiter).
- Solicitara la temperatura actual en grados Celsius para dicho planeta.
- Proporcionara consejos de vestimenta y precauciones específicas, basados en el planeta y el rango de temperatura.
- Manejara elegantemente entradas de planetas inválidas, solicitando al usuario un nombre válido.

---

## 🌟 Versión Personalizada y Mejorada

Esta edición transforma el concepto inicial en una aplicación completa de gestión de datos planetarios. Se ha diseñado con la extensibilidad y la interactividad en mente, implementando las siguientes características clave:

### Menú Interactivo y Extenso

Un robusto menú principal basado en un bucle do-while guía al usuario a través de diversas funcionalidades, permitiéndole no solo consultar, sino también administrar activamente la información climática planetaria:

- Consultar clima planetario: El corazón de la aplicación. El usuario ingresa un planeta (predefinido o añadido) y la temperatura. El sistema recupera y muestra el consejo de vestimenta y las precauciones pertinentes
- Añadir nuevo planeta: Esta opción es fundamental para la extensibilidad. Permite al usuario definir un planeta completamente nuevo, incluyendo su nombre y configurando múltiples umbrales de temperatura con sus respectivos consejos.
- Actualizar información de planeta: Permite modificar los datos climáticos de un planeta ya existente. Esto incluye añadir nuevos umbrales de temperatura/consejos o modificar los ya presentes, así como eliminar umbrales específicos que ya no sean relevantes.
- Eliminar planeta: Proporciona la capacidad de remover un planeta y toda su información asociada de la base de datos del programa.
- Mostrar todos los planetas: Ofrece una visión general completa de todos los planetas actualmente registrados en el sistema, mostrando su nombre y todos los rangos de temperatura y consejos definidos para cada uno.
- Salir del programa: Termina la ejecución de la aplicación.

### Gestión de Datos Planetarios con HashMap

En lugar de una serie de condicionales if-else para cada planeta, se emplea una estructura de datos HashMap<String, Planet>. Esta elección es crucial por varias razones:

- Eficiencia de Búsqueda: Permite un acceso directo y rápido a la información de un planeta utilizando su nombre como clave, lo cual es mucho más eficiente que iterar sobre una lista.
- Flexibilidad: Facilita la adición y eliminación dinámica de planetas en tiempo de ejecución, sin necesidad de modificar el código fuente cada vez que se quiere añadir un nuevo cuerpo celeste.
- Mapeo Consistente: La clave (String) se guarda en minúsculas y sin espacios (toLowerCase().trim()), asegurando que las búsquedas funcionen correctamente sin importar cómo el usuario escriba el nombre del planeta.

### Clase Planet

La introducción de la clase Planet es la piedra angular de esta versión avanzada. Encapsula toda la lógica y los datos relacionados con un planeta individual, adhiriéndose a los principios de Programación Orientada a Objetos:

    Atributos:
        name (String): El nombre del planeta (ej. "Tierra", "Marte").
        temperatureAdvice (TreeMap<Integer, String[]>): Esta es una estructura de datos anidada clave. Es un TreeMap porque automáticamente mantiene las temperaturas ordenadas, lo cual es ideal para determinar el rango correcto de consejos.
            La clave (Integer) representa un umbral de temperatura (ej. -10, $0$, $20$).
            El valor (String[]) es un arreglo de dos elementos: [consejoDeVestimenta, precauciones].
    Métodos Clave:
        Planet(String name): El constructor para crear una nueva instancia de planeta.
        getName(): Devuelve el nombre del planeta.
        agregarAvisoBasadoEnTemperatura(int temperatureThreshold, String[] advice): Un método versátil que añade un nuevo par umbral/consejo o actualiza uno existente. Si el umbral ya está presente, su consejo se sobrescribe; de lo contrario, se añade como un nuevo punto de referencia.
        removerAvisoBasadoEnTemperatura(int temperatureThreshold): Elimina un umbral de temperatura específico y su consejo asociado.
        obtenerAvisoBasadoEnTemperatura(double currentTemperature): Este es un método inteligente. Utiliza TreeMap.floorEntry(int key) para encontrar el umbral de temperatura más alto que sea menor o igual a la temperatura actual proporcionada. Esto asegura que se obtenga el consejo más apropiado para el rango de temperatura dado. Si no se encuentra un umbral adecuado, devuelve un consejo genérico de precaución.
        toString(): Sobreescrito para proporcionar una representación legible y formateada de todos los detalles de un planeta, incluyendo su nombre y todos sus rangos de temperatura y consejos definidos.

### Manejo Robusto de Errores y Validaciones

La aplicación incorpora una lógica sólida para manejar entradas de usuario y posibles problemas:

- Validación de Tipo de Entrada: Se utilizan bucles while (!scanner.hasNextInt()) o while (!scanner.hasNextDouble()) para asegurar que el usuario ingrese el tipo de dato correcto (números enteros para opciones de menú, números para temperaturas).
- Mensajes de Error Claros: En caso de entradas inválidas, planetas no encontrados o intentos de añadir planetas duplicados, se proporcionan mensajes descriptivos al usuario, guiándolo para corregir su entrada o entender el estado del sistema.
- Normalización de Nombres: El uso consistente de toLowerCase().trim() en los nombres de los planetas hace que el sistema sea tolerante a errores de escritura en mayúsculas/minúsculas o espacios adicionales, mejorando la experiencia del usuario.
