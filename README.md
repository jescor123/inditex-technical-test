# inditex-technical-test
Prueba tecnica para la empresa Inditex


Arquitectura del proyecto : 
  * Arquitectura de microservicio


Descripción del Proyecto :
  * Microservicio para descargar una lista de albums y fotos desde una API 
  * Almacenamiento de lista de albums y fotos en una base de datos H2
  * Respuesta de peticiones GET de los albums y fotos desde base de datos H2
  * Respuesta de peticiones GET de los albums y fotos desde de la API fuente de datos


Estado del proyecto :
  * Finalizado y operativo en ramas de GIT development y master


Funcionamiento de la aplicacion y endpoints para hacer peticiones : 
  * La aplicacion desplega 1 endpoint para recuperar lista de album y fotos desde H2 DB :
       http://localhost:8080/v2/albums-from-h2
  * La aplicacion desplega 1 endpoint para almacenar lista de album y fotos en H2 DB :
       http://localhost:8080/v2/save-albums-in-database
  * La aplicacion desplega 1 endpoint para recuperar lista de album y fotos desde API :
       http://localhost:8080/v2/albums-from-api


Tecnologías utilizadas :
  * Apache Maven 3.8.2 : Usado para descargas las dependencias,
                         compilar y ejecutar la aplicacion, correr tests
    
  * Java version "21.0.3" 2024-04-16 LTS : La version de Java usada

  * Spring Boot WebFlux : Usado por su cualidad de la programacion reactiva 
                          y compatibilidad con WebClient, el cual es usado 
                          para la conexion y lectura a la API

  * Lombok 1.18.32 : Usado para eliminar Boiler plate code en Model y DTO

  * Swagger 2.5.0 : Usado para documentar la API :
        http://localhost:8080/swagger-ui-custom.html

  * Jacoco 0.8.12 : Usado para reportar el porcentaje de cobertura de los tests :
        http://localhost:63342/inditex-technical-test/target/site/jacoco/index.html?_ijt=ltr6bflv5i79h8537kpuhgmds3&_ij_reload=RELOAD_ON_SAVE

  * JUnit : Usado para los tests unitarios de la aplicacion

  * Mockito : Usado para los tests unitarios y de integracion

  * H2 : Base de datos en memoria usada para este proyecto.


Diseño del proyecto :
  * Modelo : Album y Photo. Son las entidades del proyecto
  * Controlador : AlbumDataController es quien expone los 3 endpoints
                  HandleExceptionController para usar las propias excepciones
                  creadas en este pryecto
  * Service : Las interfaces DataCollectionService, AlbumService y PhotoService con sus comportamientos
  * ServiceImpl : Las implementaciones de los comportamientos de AlbumService
                  y PhotoService, los cuales son la base para el funcionamiento de
                  DataCollectionService
  * Mapper : con los converters de DTO a Model y de Model a DTO
  * Repository : La capa que contiene las consultas a la H2 BD
  * Excepcion : creacion propias de excepciones en este proyecto
  * Config : configuracion del Bean para establecer el WebClient a la API fuente
  * Dto : las clases DTO usadas para transportar los datos de los modelos desde H2 hacia la salida
          de los endpoints
  * Aspect : se ha agregado una programacion orientada a aspecto AOP para hacer logging de los
             eventos ocurridos en el controlador AlbumDataController, como ejemplo al ejecutarse
             un metodo que guarde en H2 BD


Patron de diseño usado :
  * DTO : Usado para convertir los datos de los albums y fotos
          a datos comprensibles por los modelos Album y Photo

Estructuras de datos utilizadas :
* LinkedHashSet :  Se ha seleccionado esta estructura de datos ya que ha
  permitido asegurar la no duplicidad de un album o una
  foto cuando se descargue de la API fuente y sean
  insertadas en la base de datos H2, ademas de que mantiene
  el orden de los elementos tal como vienen.
* ArrayList : Se ha usado esta estructura de datos por su capacidad para
  mantener el orden de los elementos album y fotos recuperados
  desde la base de datos H2.

Pruebas unitarias (Ejemplos) :
  * Prueba de integracion - enpoint de consulta a H2 DB
    http://localhost:8080/v2/albums-from-h2

      MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /v2/albums-from-h2
      Parameters = {}
      Headers = [Accept:"application/json;charset=UTF-8"]
      Body = <no character encoding set>
      Session Attrs = {}

      Handler:
      Type = com.inditex.inditex_technical_test.controller.AlbumDataController
      Method = com.inditex.inditex_technical_test.controller.AlbumDataController#getAlbumsFromDatabase()

      Async:
      Async started = true
      Async result = [AlbumDTO(id=1, userId=1, title=XXX, photoList=[]), AlbumDTO(id=2, userId=1, title=XXX, photoList=[]), AlbumDTO(id=3, userId=1, title=XXX, photoList=[])]

      Resolved Exception:
      Type = null

      ModelAndView:
      View name = null
      View = null
      Model = null

      FlashMap:
      Attributes = null

      MockHttpServletResponse:
      Status = 200
      Error message = null
      Headers = []
      Content type = null
      Body =
      Forwarded URL = null
      Redirected URL = null
      Cookies = []


Personas Desarrolladoras del Proyecto :
  * Jescor Manuel Alvarado Zerpa

Licencia :
  * V2