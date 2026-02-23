# 🏭 Patrón de Diseño Factory Method -- Ejemplo en Java

![Java](https://img.shields.io/badge/Java-POO-orange) ![Design
Pattern](https://img.shields.io/badge/Pattern-Factory%20Method-blue)
![Paradigm](https://img.shields.io/badge/Paradigm-Object%20Oriented-green)

------------------------------------------------------------------------

## 📌 Descripción

Este proyecto implementa el **Patrón de Diseño Factory Method**
utilizando Java, aplicándolo a la generación de distintos tipos de
facturas con diferentes porcentajes de IVA.

El objetivo es demostrar cómo el patrón permite:

-   Delegar la creación de objetos a una clase especializada.
-   Desacoplar el cliente de las implementaciones concretas.
-   Facilitar la extensión del sistema sin modificar el código cliente.
-   Aplicar principios SOLID (Open/Closed Principle).

------------------------------------------------------------------------

## 🧠 ¿Qué es el Factory Method?

El **Factory Method** es un patrón de diseño creacional que define una
interfaz para crear un objeto, pero permite que las subclases o una
clase concreta decidan qué instancia crear.

Permite encapsular la lógica de creación de objetos.

------------------------------------------------------------------------

## 🧾 Caso de Estudio: Sistema de Facturación

El sistema genera facturas con diferentes tipos de IVA:

-   IVA 0%
-   IVA 8%
-   IVA 16%

Cada tipo de factura implementa la interfaz:

``` java
interface Factura {
    float generarImporte(float importe);
}
```

------------------------------------------------------------------------

## 🏗 Implementación

### 🔹 Interface Producto

``` java
interface Factura {
    float generarImporte(float importe);
}
```

### 🔹 Productos Concretos

-   facturaSinIVA
-   facturaCon8DeIVA
-   facturaCon16DeIVA

Cada clase implementa su propia lógica de cálculo.

Ejemplo:

``` java
return (importe * (16f / 100)) + importe;
```

------------------------------------------------------------------------

### 🔹 Factory (Creador)

``` java
class GeneradorDeFacturas {
    public Factura generarFactura(TipoFactura tipoFactura)
}
```

La clase `GeneradorDeFacturas` decide qué implementación concreta
instanciar según el `TipoFactura`.

------------------------------------------------------------------------

### 🔹 Enum de Tipos

``` java
enum TipoFactura {
    IVA_0, IVA_8, IVA_16
}
```

------------------------------------------------------------------------

## 🚀 Ejemplo de Uso

``` java
GeneradorDeFacturas generador = new GeneradorDeFacturas();

Factura factura = generador.generarFactura(TipoFactura.IVA_16);
float total = factura.generarImporte(100);
```

Salida esperada:

-   IVA 0% → 100
-   IVA 8% → 108
-   IVA 16% → 116

------------------------------------------------------------------------

## 🧩 Flujo de Ejecución

Cliente → GeneradorDeFacturas (Factory) → Factura Concreta → Cálculo del
importe

El cliente nunca instancia directamente las clases concretas.

------------------------------------------------------------------------

## 📂 Estructura del Proyecto

    patronesdeDiseño/
     ├── FactoryMethod.java

Contiene:

-   Interface `Factura`
-   Implementaciones concretas
-   Clase Factory `GeneradorDeFacturas`
-   Enum `TipoFactura`
-   Método `main` para pruebas

------------------------------------------------------------------------

## 🎯 Objetivos Académicos

Este proyecto demuestra:

-   Implementación práctica del patrón Factory Method
-   Desacoplamiento entre cliente y productos concretos
-   Uso de polimorfismo
-   Principio Open/Closed
-   Buenas prácticas en diseño orientado a objetos

------------------------------------------------------------------------

## 📄 Conclusión

El patrón Factory Method permite centralizar la creación de objetos y
facilita la extensión del sistema. Para agregar un nuevo tipo de
factura, basta con crear una nueva implementación de `Factura` y
actualizar la lógica del Factory.

Este ejemplo muestra cómo aplicar correctamente un patrón creacional en
Java con una estructura simple y clara.
