import Lectura._

import scala.io.StdIn.*
import scala.language.postfixOps

object Esfuerzo {

}

// Suma de los costos de esfuerzo de cada trabajador
def calcularEsfuerzo(): Double = {
  val esfuerzoVector: Vector[Double] = inputEsfuerzoValor(Vector.empty[Double])
  esfuerzoVector.sum // suma de todos los elementos del vector
}

// Funcion para calcular cada esfuerzo
def inputEsfuerzoValor(acc: Vector[Double]): Vector[Double] = {
  val horasTrabajadas = solicitarDatoDouble("Ingresar las horas trabajadas del trabajador (o escribe '-1' para terminar): ")

  if (horasTrabajadas == -1) {
    acc
  } else {
    val horaValor = solicitarDatoDouble("Ingresar el valor por hora: ")
    println("\n\t\tIngrese la información de las horas del siguiente empleado:\n")
    inputEsfuerzoValor(acc :+ horaValor * horasTrabajadas) // pasamos como parametro el vector con la multiplicacion horavalor * horasTrabajadas al final
  }
}