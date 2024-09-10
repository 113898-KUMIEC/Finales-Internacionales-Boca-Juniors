# Proyecto de API sobre Finales Internacionales de Boca Juniors

## Descripción

Este proyecto es una API REST desarrollada en **Java** utilizando **Spring Boot**, que ofrece información sobre las finales internacionales disputadas por el club Boca Juniors. La API sigue una **arquitectura en capas** para separar las responsabilidades del código y mejorar su mantenibilidad. Además, consume datos de servicios REST externos mediante el uso de **RestTemplate**, los procesa y expone en nuevos endpoints. Esto permite obtener información sobre los equipos, jugadores, formaciones y resultados de las finales internacionales de Boca Juniors.

## Características principales

- **Java con Spring Boot**: Utilizamos Spring Boot para simplificar la configuración y acelerar el desarrollo de la aplicación.
- **Arquitectura en capas**: 
  - `Controller`: Gestiona las solicitudes HTTP y los endpoints.
  - `Service`: Contiene la lógica de negocio.
  - `Model`: Define las entidades y clases que representan los datos de las finales.
  - `DTO`: Objetos que transfieren los datos entre las capas y hacia/desde los clientes.
  - `Client`: Consume APIs externas para recolectar los datos.
- **Consumo de APIs externas**: La API se conecta a otros servicios REST para obtener datos sobre las finales, y los procesa para exponer la información de manera clara.

## Tecnologías utilizadas

- **Java 17** (o la versión que estés utilizando)
- **Spring Boot 2.x** (dependiendo de la versión que utilices)
- **Maven** para la gestión de dependencias
- **RestTemplate** para el consumo de APIs REST externas
- **Lombok** (si lo usas para reducir el código repetitivo)
- **JUnit** (si tienes pruebas unitarias implementadas)

## Instalación y configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/113898-KUMIEC/Finales-Internacionales-Boca-Juniors.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd Finales-Internacionales-Boca-Juniors
   ```

3. Compila el proyecto usando Maven:
   ```bash
   mvn clean install
   ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Uso

La API permite consultar información sobre las finales internacionales de Boca Juniors, incluyendo los equipos, formaciones, y resultados. Ejemplo de un endpoint que consume una API externa y devuelve datos procesados:

```bash
GET /finales/PartidosCompletos
```
