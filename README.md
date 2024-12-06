# Guía para Ejecutar un Proyecto con Spring Boot, MySQL y Gradle

## 1. Requisitos Previos

Asegúrate de tener los siguientes requisitos instalados:

- **Java Development Kit (JDK 8 o superior):**
  Verifica la instalación con el siguiente comando:
  ```bash
  java -version
MySQL: Verifica la instalación con:

bash
mysql --version
Gradle: Verifica que Gradle esté instalado con:

bash
gradle -v
IDE (como IntelliJ IDEA, Eclipse o VSCode).

2. Clonar el Repositorio (si es necesario)
Si tu proyecto está en un repositorio remoto, clónalo usando Git:

bash
Copiar código
git clone <URL_DEL_REPOSITORIO>
cd <NOMBRE_DEL_REPOSITORIO>

3. Configurar la Base de Datos MySQL
Si no has creado aún la base de datos y las tablas, sigue estos pasos:

Inicia sesión en MySQL:

bash
mysql -u root -p
Crear la base de datos:

sql
CREATE DATABASE <NOMBRE_DE_LA_BASE_DE_DATOS>;
USE <NOMBRE_DE_LA_BASE_DE_DATOS>;
Crear las tablas necesarias para el proyecto. Aquí hay un ejemplo genérico de cómo puedes hacerlo:

sql
CREATE TABLE <NOMBRE_DE_LA_TABLA> (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_columna_1 VARCHAR(100) NOT NULL,
    nombre_columna_2 INT NOT NULL
);

4. Configurar el archivo application.yml (o application.properties)
Configura el archivo de propiedades de la aplicación con los detalles de conexión a la base de datos. A continuación se muestra un ejemplo utilizando application.yml:

yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/<NOMBRE_DE_LA_BASE_DE_DATOS>
    username: root
    password: <TU_CONTRASEÑA>
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    open-in-view: false
server:
  port: 8080
  
Conexión a la base de datos: Se conecta a MySQL en localhost usando la base de datos configurada.
JPA: Se configura Hibernate para actualizar automáticamente el esquema de la base de datos.
Puerto: La aplicación se ejecutará en el puerto 8080.

5. Configurar las Dependencias de Gradle
El archivo build.gradle debe tener las dependencias necesarias para tu proyecto. Aquí hay un ejemplo común de las dependencias que podrías necesitar:

gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    runtimeOnly 'com.mysql:mysql-connector-j'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

Estas dependencias incluyen soporte para Spring Data JPA, Spring Web y el conector MySQL.

6. Instalar Dependencias de Gradle
Ejecuta el siguiente comando para instalar todas las dependencias del proyecto:

bash
gradle build
Este comando descargará todas las dependencias necesarias para el proyecto.

7. Ejecutar el Proyecto
Una vez que las dependencias estén instaladas, puedes ejecutar la aplicación de Spring Boot.

Si estás usando Gradle, ejecuta el siguiente comando:

bash
gradle bootRun
Si usas un IDE como IntelliJ IDEA, puedes ejecutar el proyecto directamente desde el IDE.

8. Verificar la Ejecución
Abre tu navegador y verifica si la aplicación está funcionando correctamente. Por defecto, la aplicación se ejecuta en el puerto 8080, por lo que puedes acceder a:

bash
http://localhost:8080
Si todo está configurado correctamente, deberías ver la respuesta de tu aplicación.
