import scala.io.StdIn.* //leer datos
import scala.compiletime.ops.double //op entre tipos
import scala.language.postfixOps
import Lectura._

object Infraestructura {

}

// Calcula la infratructura total llamando las demas funciones y sumando sus valores retornados
def calcularInfraestructuraTotal(): Double = {
  val costoInfraestructuraNube = calcularInfraestructuraNube()
  val costoHerramientas = calcularCostoHerramientas()
  val costoTotalInfraestructura = costoInfraestructuraNube + costoHerramientas
  costoTotalInfraestructura
}

// Calcula el costo de infraestructura de los servidores
def calcularInfraestructuraNube(): Double ={
  val costoMensualNube = solicitarDatoDouble("Ingrese el costo mensual de infraestructura en la nube (servidores): ")
  val meses = solicitarDatoInt("Ingrese el número de meses destinados al proyecto en  el que se utilizara la infraestructura: ")
  val costoInfraestructuraNube = costoMensualNube * meses
  costoInfraestructuraNube
}

// calcula el costo total de las herramientas
def calcularCostoHerramientas(): Double = {
  val costoHerramientas = solicitarDatoDouble("Ingrese el costo total de las herramientas utilizadas (Github, Swagger, Sonar.): ")
  costoHerramientas
}