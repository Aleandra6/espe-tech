# ESPE-Tech - Comparativa de Paradigmas de Programación

## Nombre:
* Alejandra Rosero

## Introducción

El proyecto implementa un módulo de gestión y análisis de inventario de hardware para laboratorios tecnológicos utilizando Spring Boot. La solución fue desarrollada siguiendo la arquitectura del proyecto base ESPE-Plus y tiene como objetivo procesar información de equipos tecnológicos para generar reportes analíticos de disponibilidad y valoración.

Como parte de la práctica, se implementó el mismo problema algorítmico utilizando dos paradigmas de programación diferentes: el paradigma imperativo y el paradigma funcional/declarativo mediante Java Streams API.

## Objetivos

* Implementar una arquitectura por capas basada en el proyecto ESPE-Plus.
* Agrupar equipos por categoría.
* Determinar el equipo más costoso de cada categoría.
* Comparar los paradigmas imperativo y funcional en términos de legibilidad, cantidad de código y mantenibilidad.

## Arquitectura del Proyecto

El proyecto se encuentra organizado utilizando una arquitectura por capas:

* Entity
* Repository
* Service
* Controller
* DTO
* AI Service

Esta estructura permite una mejor organización del código, separación de responsabilidades y facilidad de mantenimiento.

## Problema Algorítmico Implementado

El sistema realiza las siguientes operaciones:

1. Filtrar equipos comprados en los últimos cinco años y que se encuentren en estado ACTIVO.
2. Agrupar los equipos por categoría.
3. Identificar el equipo más costoso de cada categoría.
4. Generar un resumen dinámico del inventario.

## Resultados

### Endpoint Imperativo

<img width="729" height="555" alt="image" src="https://github.com/user-attachments/assets/d717c8fa-fac3-434f-a3cb-1cee3c3e62d2" />

### Endpoint Funcional

<img width="701" height="552" alt="image" src="https://github.com/user-attachments/assets/55d07746-08c5-461f-99b3-d46ab4cc2712" />


### Endpoint Resumen

<img width="947" height="234" alt="image" src="https://github.com/user-attachments/assets/1da53c92-72cb-4b67-bf38-a8cdcc919ac6" />


## Comparación de Paradigmas

| Aspecto                      | Paradigma Imperativo          | Paradigma Funcional |
| ---------------------------- | ----------------------------- | ------------------- |
| Líneas de código             | Mayor cantidad                | Menor cantidad      |
| Legibilidad                  | Media                         | Alta                |
| Mantenimiento                | Más complejo                  | Más sencillo        |
| Procesamiento de colecciones | Manual                        | Mediante Streams    |
| Agrupaciones                 | Uso de estructuras auxiliares | groupingBy()        |
| Cálculos estadísticos        | Acumuladores manuales         | summarizingDouble() |
| Búsqueda de máximos          | Condicionales                 | max() y Optional    |

### Análisis Comparativo

El paradigma imperativo ofrece un control detallado sobre el flujo de ejecución mediante estructuras tradicionales como ciclos for y sentencias if. Este enfoque resulta útil para comprender paso a paso el comportamiento del algoritmo.

Por otro lado el paradigma funcional permite expresar la lógica de negocio de forma más concisa y legible mediante Streams API. Operaciones como filtrado, agrupación, cálculo de estadísticas y búsqueda de máximos pueden realizarse utilizando funciones especializadas que reducen la cantidad de código y mejoran su mantenibilidad.

## Conclusiones

* La arquitectura basada en capas facilita la organización y escalabilidad del proyecto.
* Ambos paradigmas permiten resolver correctamente el problema planteado.
* El paradigma imperativo proporciona mayor control sobre la ejecución del algoritmo.
* El paradigma funcional reduce la cantidad de código y mejora la legibilidad.
* Java Streams API simplifica significativamente las operaciones de procesamiento de colecciones.
* Para aplicaciones empresariales modernas desarrolladas con Spring Boot, el enfoque funcional representa una alternativa más mantenible y expresiva.
