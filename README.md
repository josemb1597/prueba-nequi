# Guía para Ejecutar el Proyecto con Spring Boot, MySQL y Gradle

## 1. Requisitos Previos

Asegúrate de tener lo siguiente instalado:

- **Java Development Kit (JDK 8 o superior):**
  Verifica la instalación con el siguiente comando:
  ```bash
  java -version
MySQL: Verifica la instalación con:

bash
Copiar código
mysql --version
Gradle: Verifica que Gradle esté instalado con:

bash
Copiar código
gradle -v
IDE (como IntelliJ IDEA, Eclipse o VSCode).

2. Clonar el Repositorio (si es necesario)
Si tu proyecto está en un repositorio remoto, clónalo usando Git:

bash
Copiar código
git clone https://github.com/josemb1597/prueba-nequi.git
cd prueba-nequi
3. Configurar la Base de Datos MySQL
Si no has creado aún la base de datos y las tablas, sigue estos pasos:

Inicia sesión en MySQL:

bash
Copiar código
mysql -u root -p
Crear la base de datos:

sql
Copiar código
CREATE DATABASE franchise_management;
USE franchise_management;
Crear las tablas:

sql
Copiar código
CREATE TABLE franchises (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_franchise VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE branches (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_branch VARCHAR(100) NOT NULL,
    franchise_id BIGINT NOT NULL,
    CONSTRAINT fk_branches_franchises FOREIGN KEY (franchise_id) REFERENCES franchises(id) ON DELETE CASCADE
);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_product VARCHAR(100) NOT NULL,
    stock INT UNSIGNED NOT NULL DEFAULT 0,
    branch_id BIGINT NOT NULL,
    CONSTRAINT fk_products_branches FOREIGN KEY (branch_id) REFERENCES branches(id) ON DELETE CASCADE
);
4. Configurar el archivo application.yml
Ya tienes un archivo application.yml configurado con la conexión a MySQL. Aquí te dejo el ejemplo:

yaml
Copiar código
spring:
  application:
    name: franchise-management-api
  datasource:
    url: jdbc:mysql://localhost:3306/franchise_management
    username: root
    password: admin
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    open-in-view: false
server:
  port: 8080
Conexión a la base de datos: Se conecta a MySQL en localhost usando la base de datos franchise_management.
JPA: Se configura Hibernate para actualizar el esquema de la base de datos automáticamente y mostrar las consultas SQL en la consola.
Puerto: La aplicación se ejecutará en el puerto 8080.
5. Configurar las Dependencias de Gradle
Tu archivo build.gradle ya tiene las dependencias necesarias. Aquí te explico qué hace cada una:

gradle
Copiar código
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.mapstruct:mapstruct:1.6.3'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.projectlombok:lombok'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.6.3'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
6. Instalar Dependencias de Gradle
Ejecuta el siguiente comando para instalar las dependencias del proyecto:

bash
Copiar código
gradle build
Este comando descargará todas las dependencias necesarias.

7. Ejecutar el Proyecto
Una vez que las dependencias estén instaladas, puedes ejecutar la aplicación de Spring Boot.

Si estás usando Gradle, ejecuta:

bash
Copiar código
gradle bootRun
Si usas un IDE como IntelliJ IDEA, puedes ejecutar el proyecto directamente desde el IDE.

8. Verificar la Ejecución
Abre tu navegador y verifica si la aplicación está funcionando correctamente. Por defecto, la aplicación se ejecuta en el puerto 8080, por lo que puedes acceder a:

bash
Copiar código
http://localhost:8080
Si todo está configurado correctamente, deberías ver la respuesta de tu aplicación Spring Boot (dependiendo de las rutas que hayas definido).

9. Probar Operaciones CRUD
Si has implementado controladores para gestionar franquicias, sucursales y productos, puedes realizar peticiones HTTP para probar la funcionalidad de tu aplicación:

GET /franchises: Obtener la lista de franquicias.
POST /franchises: Crear una nueva franquicia.
GET /branches: Obtener la lista de sucursales.
POST /branches: Crear una nueva sucursal.
GET /products: Obtener la lista de productos.
POST /products: Crear un nuevo producto.
Puedes usar herramientas como Postman o cURL para realizar estas peticiones.
