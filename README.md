# Prueba de código para perfiles QA Automation

El siguiente proyecto consta de una prueba automatizada para probar los escenario de Registro y Log In de la Web
ParaBank.
Para ello, se ha desarrollado un framework de automatización en Java 17, Selenium, Cucumber y TestNG.

## Tabla de Contenidos

- [Características](#caracteristicas)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Pre Requisitos](#pre-requisitos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Ejecución de los Tests](#ejecución-de-los-tests)

## Caracteristicas

- **Lenguaje**: Java
- **Runner de pruebas**: TestNG
- **Herramienta de pruebas**: Selenium
- **Framework de BDD**: Cucumber
- **Gestión de Dependencias**: Maven
- **Reportes**: Allure
- **Patrón de Diseño**: Page Object Model (POM)

## Estructura del proyecto

        .
        └── src/
            └── main/
                ├── java/
                │   ├── org/example/
                │   │   ├── config/
                │   │   ├── constants/
                │   │   ├── driver/
                │   │   ├── models/
                │   │   ├── pages/
                │   │   └── utils/
                │   └── resources/
                └── test/
                    ├── java/
                    │   ├── runner/
                    │   └── steps/
                    └── resources/
                        └── features/

#### `src/main/java/org/example/`

- **config/**: Clases de configuración.
- **constants/**: Clases que definen constantes utilizadas en todo el proyecto.
- **driver/**: Clases para la configuración de los drivers de Selenium.
- **models/**: Contiene la representación de los datos y entidades.
- **pages/**: Clases que representan cada página web utilizada en el proyecto (Patrón de diseño POM).
- **utils/**: Utilitarios.

#### `src/main/resources/`

- **resources/**: Contiene el `project.properties` para definir propiedades y variables del proyecto.

#### `src/test/java/`

- **runner/**: Contiene el TestRunner para configurar la ejecución de los Tests.
- **steps/**: Contiene los Step Definitions.

#### `src/test/resources/`

- **features/**: Archivos `.feature`para describir los escenarios de prueba.

## Pre Requisitos

Para este proyecto se necesitará:

- Java JDK 17
- Allure
  > Para instalar Allure ir al punto: [Instalar Allure](#instalar-allure)

## Configuración del Proyecto

### Clonar el repositorio

```bash
git clone https://github.com/Loa33/prueba-qa-auto.git
```

### Instalar Allure

Desde PowerShell ejecutar los siguientes comandos:

- Instalar Scoop

```shell
  Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

```shell
  Invoke-RestMethod -Uri https://get.scoop.sh | Invoke-Expression
```

- Instalar Allure

```shell
  scoop install allure
```

## Ejecución de los Tests

Ejecutar los siguientes comando desde la terminal

- Ejecutar los tests:

```bash
  mvn clean test
```

> También se pueden ejecutar los test desde el archivo `testng.xml`

- Generar los reportes de allure con:

```bash
  mvn allure:report
```

- Visualizar los reportes con:

```bash
  allure open
```
