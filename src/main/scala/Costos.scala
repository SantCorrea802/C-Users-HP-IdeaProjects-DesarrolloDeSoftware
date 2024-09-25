import Infraestructura._
import Viaticos._
import Esfuerzo._

import scala.language.postfixOps


object Costos {
  
}

// Funcion que ejecuta los metodos de Esfuerzo, Infraestructura y Viaticos
// Para calcular los Costos
def calcularTotalCostos(): Double = {
  val esfuerzo = calcularEsfuerzo()
  val infraestructura = calcularInfraestructuraTotal()
  val viaticos = calcularViaticos()
  val totalCostos = infraestructura + viaticos + esfuerzo
  totalCostos
}