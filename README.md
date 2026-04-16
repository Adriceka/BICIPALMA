# BICIPALMA

# ÍNDICE
<ul>
<li><a href='#introduccion'>Introducción</a></li>
<li><a href='#manual'>Manual</a></li>
<li><a href='#metodologia'>Metodología</a></li>
<li><a href='#diseno'>Diseño</a></li>
</ul>

## <div id='introduccion'>Introducción</div>

Adrián González González    - <a href= 'https://github.com/Adriceka'>@Adriceka</a>

Este proyecto consiste en desarrollar un sistema de gestión para una estación de alquiler de bicicletas en Palma. El sistema permite anclar/desanclar bicicletas en anclajes disponibles, consultar la capacidad de la estación, validar usuarios mediante tarjetas autenticadas y gestionar el almacenamiento de bicicletas.

## <div id='manual'>Manual</div>

#### Instalación

Para ejecutar este proyecto, asegúrate primero de tener **Java** y **Maven** instalados en tu sistema.  
A continuación, descarga el proyecto desde GitHub y accede a la carpeta del repositorio:

```bash
git clone https://github.com/Adriceka/BICIPALMA.git
cd BICIPALMA
```

#### Construcción del Proyecto

Este proyecto utiliza **Maven** como gestor de dependencias y herramienta de construcción. Asegúrate de tener Maven instalado en tu sistema ejecutando:

```bash
mvn --version
```

Para compilar el proyecto, ejecuta:

```bash
mvn clean compile
```

#### Ejecutar las Pruebas

Para ejecutar todos los casos de prueba unitarios:

```bash
mvn test
```

Para generar un informe de las pruebas:

```bash
mvn surefire-report:report
```

## <div id='metodologia'>Metodología</div>

Para llevar a cabo el Kata de BICIPALMA decidimos comenzar definiendo claramente los requisitos del sistema: la gestión integral de bicicletas, anclajes y usuarios.

La metodología empleada tiene un enfoque inspirado en 
<a href='https://es.wikipedia.org/wiki/Desarrollo_guiado_por_pruebas'>TDD</a> 
y consta de tres pasos:

<ol>
<li>
Definimos los requisitos que debía cumplir cada módulo, como:
<ul>
<li>Creación e identificación de bicicletas mediante ID único.</li>
<li>Gestión de anclajes y estaciones (disponibilidad, capacidad, ubicación).</li>
<li>Anclar y desanclar bicicletas en anclajes disponibles.</li>
<li>Consultar anclajes libres en una estación.</li>
<li>Autenticación y validación de tarjetas de usuario.</li>
</ul>
</li>
<br/>

<li>
Se desarrolló la funcionalidad principal de cada componente, mientras paralelamente se implementaban casos de prueba para verificar:
<ul>
<li>Anclaje correcto de bicicletas en anclajes disponibles.</li>
<li>Consulta de anclajes libres y capacidad de la estación.</li>
<li>Retirada de bicicletas con validación de tarjeta de usuario.</li>
<li>Comportamiento correcto cuando la estación está llena.</li>
<li>Validación de usuarios autenticados.</li>
</ul>
</li>
<br/>

<li>
Finalmente, se ejecutaron los casos test para comprobar que cada módulo cumplía los requisitos definidos previamente.
</li>
<br/>
</ol>

---

## <div id='diseno'>Diseño y Principios SOLID</div>

En el desarrollo del Kata de BICIPALMA se aplicaron principios SOLID para estructurar el código de manera clara y mantenible:

<ul>

<li>
<strong>SRP (Single Responsibility Principle)</strong>:  
Se separó la lógica en responsabilidades concretas, por ejemplo:
<ul>
<li>La clase <code>Bicicleta</code> gestiona únicamente la identificación de una bicicleta.</li>
<li>La clase <code>Anclaje</code> controla si está disponible o contiene una bicicleta.</li>
<li>La clase <code>Anclajes</code> gestiona la colección de anclajes con una capacidad definida.</li>
<li>La clase <code>Estacion</code> coordina anclajes, consultas y operaciones de usuarios.</li>
<li>La clase <code>TarjetaUsuario</code> maneja la validación y estado de autenticación del usuario.</li>
</ul>
De esta forma, cada clase tiene un único motivo para cambiar.
</li>
<br/>

<li>
<strong>OCP (Open/Closed Principle)</strong>:  
La implementación mediante interfaces como <code>Movil</code> y <code>Autenticacion</code> permite extender funcionalidades (por ejemplo, nuevos tipos de elementos móviles o métodos de autenticación) sin modificar el código principal ya implementado.
</li>
<br/>

<li>
<strong>LSP (Liskov Substitution Principle)</strong>:  
La clase <code>Bicicleta</code> implementa la interfaz <code>Movil</code>, permitiendo que cualquier objeto que implemente esta interfaz pueda usarse de manera intercambiable en el sistema.
</li>
<br/>

<li>
<strong>ISP (Interface Segregation Principle)</strong>:  
Se definen interfaces específicas para cada responsabilidad, evitando que las clases dependan de métodos que no utilizan.
</li>
<br/>

<li>
<strong>DIP (Dependency Inversion Principle)</strong>:  
Las clases dependen de abstracciones (interfaces) en lugar de implementaciones concretas, favoreciendo la flexibilidad y testabilidad del código.
</li>
<br/>

</ul>

---

## Estructura del Proyecto

```
src/
├── main/java/edu/teamrocket/bicipalma/
│   ├── appalma/          # Aplicación principal
│   ├── bicicleta/        # Gestión de bicicletas
│   ├── estacion/         # Gestión de estaciones y anclajes
│   └── tarjetaUsuario/   # Autenticación y validación de usuarios
└── test/java/edu/teamrocket/bicipalma/
    ├── bicicleta/        # Tests unitarios de bicicleta
    └── estacion/         # Tests unitarios de estación y anclajes
```
