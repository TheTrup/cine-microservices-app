# 🎬 Arquitectura de Microservicios Distribuidos para Complejo de Cines

Este proyecto implementa un ecosistema de software elástico y altamente desacoplado para la gestión integral de un complejo de cines. La arquitectura se basa en patrones modernos de sistemas distribuidos utilizando **Spring Cloud**, **Spring Boot 4.1.0**, **Java 17** y **Docker**.

##  Integrantes
*   Juan Jorquera
*   Martín Briceño

---

##  Arquitectura del Sistema

La solución está dividida en microservicios independientes que aíslan sus responsabilidades de negocio y capas de datos de forma estricta:

### Componentes de Infraestructura
*   **`msvc-eureka` (Puerto 8761):** Servidor de descubrimiento (Netflix Eureka Server) que actúa como catálogo central dinámico para la localización de servicios.
*   **`msvc-gateway` (Puerto 8080):** Spring Cloud Gateway reactivo. Es el punto único de entrada de la aplicación que resuelve el enrutamiento y balanceo de carga elástico mediante el protocolo `lb://`.

### Microservicios de Negocio (Persistencia Aislada)
*   **`msvc-peliculas` (Puerto 8001):** Gobierno del catálogo fílmico, clasificaciones y directores (`cine_peliculas_db`).
*   **`msvc-salas` (Puerto 8002):** Administración de la infraestructura física de las salas de exhibición (`cine_salas_db`).
*   **`msvc-funciones` (Puerto 8083):** Orquestación de horarios, asignación de películas a salas y tarifas base (`cine_funciones_db`).
*   **`msvc-asientos` (Puerto 8084):** Gestión del mapa de butacas y estados de ocupación en tiempo real (`cine_asientos_db`).
*   **`msvc-usuarios` (Puerto 8085):** Administración de cuentas de clientes con restricciones de unicidad (`cine_usuarios_db`).
*   **`msvc-sucursales` (Puerto 8086):** Control geográfico de los complejos de cines (`cine_sucursales_db`).
*   **`msvc-reservas` (Puerto 8087):** Núcleo transaccional que consolida compras agregando datos distribuidos (`cine_reservas_db`).
*   **`msvc-promociones` (Puerto 8089):** Validación y aplicación de cupones de descuento lógicos (`cine_promociones_db`).
*   **`msvc-historial` (Puerto 8090) / `msvc-comentarios` (Puerto 8088):** Auditoría histórica de transacciones y opiniones de usuarios.

---

##  Tecnologías Utilizadas
*   **Backend:** Java 17, Spring Boot 4.1.0, Spring Data JPA.
*   **Ecosistema Cloud:** Spring Cloud (Netflix Eureka, Cloud Gateway, OpenFeign).
*   **Calidad y Testeo:** JUnit 5, Mockito (Estructura BDD *Given-When-Then*), Swagger UI (OpenAPI 3).
*   **Persistencia:** MySQL 8.4 (Esquemas segregados por contexto).
*   **Virtualización:** Docker, Docker Compose (Multi-stage builds optimizados).

---

##  Instrucciones de Despliegue Local

Gracias a la contenedorización del proyecto, todo el ecosistema distribuido (Bases de datos individuales, orquestadores, pasarela y servicios de negocio) puede inicializarse de forma automática con un único comando.

### Requisitos Previos
*   Tener instalado **Docker Desktop** y que el demonio de Docker esté corriendo.
*   Clonar este repositorio en tu máquina local.

### Levantar el Entorno Completo
Abre una terminal en la raíz del proyecto (donde se encuentra el archivo `docker-compose.yml`) y ejecuta:

```bash
docker compose up --build -d