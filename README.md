# Eureka (RibbonApi and LoadBalancedRestTemplate)

_La finalidad del presente proyecto es poner en practica los temas aprendidos durante el curso de Microservicios.
El proyecto se encuentra conformado por cuatro servicio en los que se ha implementado Spring CLoud Netflix Ribbon._

## Comenzando 🚀
_1.- Clonar el repositorio de GitHub para tener acceso a los proyectos involucrados: https://github.com/humedina/Eureka-RibbonApi-and-LoadBalancedRestTemplate-.git_

_2.- Importar proyectos (23-Age-Microservice, 23-Eureka-Server, 23-Random-Microservice y 23-User-Micriservice)._

_2.1.- Abrir su IDE de preferencia (Se recomienda STS3)._

_2.2.- Dar click en File > Import > Maven > Existing Maven Projects > Next > Browse > {directorio_desacarga}/Eureka-RibbonApi-and-LoadBalancedRestTemplate- > Select All > Finish._


### Pre-requisitos 📋

_Antes de iniciar, necesitas:_

```
* Tener instalado Java 8
* Tener instalado Maven
```

### Instalación 🔧

_Para la ejecución o instalación de los proyectos, será necesario seguir el siguiente listado de instrucciones:_


_El primer paso consiste en actualizar las dependencias Maven en cada uno de los proyectos._

_El tercer paso es compilar el primer proyecto y para esto es necesario ejecutar el siguiente comando en la ubicación en la que se encuentra el fichero **pom.xml**_

```
mvn clean package
```
_El segundo paso es ejectar como proyecto Spring Boot App cada uno de los proyectos comenzando por **23-Eureke-Server**, ya que es en donde se registrarán el resto de los Microservicios_


_Una vez que los Microservicios se hayan ejecutado verificar con la ayuda de un Navegador la URL  **http://localhost:9099/my-eureka-server/**_

_En el apartado **Instances currently registered with Eureka** no deberá listarse ninguna aplicación; hasta que una por una se vaya ejecutando el resto de los Microservicios (Sí se inciaron todos los Microservicios, deberían de listarse de forma correcta)._

_**Nota:** Pude levantar tantas instancias como le sea posible de cada Microservicio para verificar su funcinoamiento._

## Ejecutando las pruebas ⚙️

_Para ejecutar pruebas bastará con accder a ldando **click** a los paths o recursos que se visualizarán dentro de la columna **status** de la tabla, dinamicamente cambiarán los puertos por lo que los recursos se visualizarán de la forma a la izquierda y se podrán probar como lo muestra de lado derecho:_

```
http://{ip}:{puerto}/age-service/actuator/info -> http://{ip}:{puerto}/age-service/age

http://{ip}:{puerto}/uppercase-service/actuator/info -> http://{ip}:{puerto}/uppercase-service/toUppercase/Humbert

http://{ip}:{puerto}/users-service/actuator/info -> http://{ip}:{puerto}/users-service/{user}

http://{ip}:{puerto}/random-service/actuator/info -> http://{ip}:{puerto}/random-service//next
```

## Autores ✒️

* **Humberto Medina Hernández** - *Desarrollo* - [humedina](https://github.com/humedina)




---
😊
