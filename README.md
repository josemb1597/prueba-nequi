# Mi Proyecto 

**Descripción:**
Este es un proyecto es creado con Spring Boot.

## Cómo usarlo:

1. **Clona el repositorio:**
    ```bash
    git clone https://github.com/josemb1597/prueba-nequi.git
    ```
2. **Configura la base de datos:**

   Antes de ejecutar la aplicación, es necesario configurar la base de datos y las tablas. Para hacerlo, sigue estos pasos:

   - Abre tu cliente gráfico de MySQL (por ejemplo, MySQL Workbench) y conéctate a tu servidor MySQL.
   - Abre el archivo `.sql` que contiene el script de creación de la base de datos y las tablas. Este archivo se encuentra en el repositorio.
   - En MySQL Workbench, selecciona **File > Open SQL Script** y elige el archivo correspondiente.
   - Ejecuta el script para crear la base de datos y las tablas necesarias.

3. **Instala las dependencias:**
    ```bash
    gradle build
    ```

4. **Ejecuta la aplicación:**
    ```bash
    gradle bootRun
    ```

## Estructura del proyecto:

| Carpeta               | Descripción              |
|---------------------- |--------------------------|
| `src/main/java`       | Código fuente principal  |
| `src/test/java`       | Pruebas unitarias        |

## 1. Requisitos Previos
Asegúrate de tener los siguientes requisitos instalados:

- **Java Development Kit (JDK 17 o superior):**
    - Verifica la instalación con el siguiente comando:
        ```bash
        java -version
        ```

- **MySQL:**
    - Verifica la instalación con:
        ```bash
        mysql --version
        ```


- **IDE (como IntelliJ IDEA, Eclipse o VSCode).**

# Configuración de la Base de Datos MySQL y Proyecto


Antes de continuar con la configuración de la aplicación, debes crear la base de datos y las tablas en MySQL. El script para hacerlo ya se encuentra en el repositorio.

Sigue estos pasos:

1. **Abrir tu Cliente de MySQL (por ejemplo, MySQL Workbench):**

   Abre MySQL Workbench o cualquier otro cliente gráfico de tu elección y conéctate a tu servidor MySQL.

2. **Ejecutar el script:**

   - Abre el archivo `.sql` que contiene el script de creación de la base de datos y las tablas. Este archivo se encuentra en el repositorio.
   - En MySQL Workbench, puedes hacerlo desde el menú **File > Open SQL Script** y seleccionar el archivo del script.
   - Una vez abierto el script, ejecuta el código en el cliente gráfico.

   Esto creará la base de datos y las tablas necesarias para tu aplicación.

Este paso configurará automáticamente tu base de datos y las tablas necesarias para que la aplicación funcione correctamente.
