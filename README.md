# Gestión de Tiempo de Estudio 📚⏰

## Descripción del Proyecto

Esta aplicación de consola ayuda a los estudiantes a optimizar su tiempo de estudio mediante una planificación personalizada basada en el semestre actual, materias seleccionadas y fechas de exámenes.

## Características Principales

- Selección de materias por semestre
- Cálculo de horas de estudio recomendadas por materia
- Métodos de estudio personalizados
- Herramientas de estudio sugeridas
- Distribución proporcional del tiempo de estudio según los créditos de cada materia

## Requisitos Previos

- Java Development Kit (JDK) 8 o superior
- Conexión a base de datos MySQL
- Driver JDBC MySQL

## Configuración de la Base de Datos

La aplicación utiliza una base de datos MySQL alojada en Clever Cloud. Los parámetros de conexión se encuentran en la clase `Datos.java`:

- **URL:** jdbc:mysql://bfazsrsylgrnbv9oyjti-mysql.services.clever-cloud.com:3306/bfazsrsylgrnbv9oyjti
- **Usuario:** uyvfun0cm0izhv2s
- **Contraseña:** 5AV6ltD2rAZ9vqnZALg3

**Nota:** Reemplaza estas credenciales con tus propios datos de conexión si es necesario.

## Estructura del Proyecto

- `Datos.java`: Clase que maneja la conexión a la base de datos y representa los datos de las materias
- `Main.java`: Clase principal que contiene la lógica de la aplicación y la interacción con el usuario

## Uso de la Aplicación

1. Ejecuta la aplicación
2. Ingresa el semestre actual (actualmente solo soporta semestres 1 y 2)
3. Selecciona el día actual
4. Elige las materias para las que deseas planificar tu tiempo de estudio
5. Indica 
