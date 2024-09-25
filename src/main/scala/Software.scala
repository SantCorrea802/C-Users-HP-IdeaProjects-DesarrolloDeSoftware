import Lectura._
import  Costos._

object Software {
  // Funcion main
  def main(args: Array[String]): Unit ={
    calcularDesarrolloSoftware() // Ejecutamos el programa
  }
}

// calculamos el costo total del desarrollo del software
def calcularDesarrolloSoftware(): Unit ={
  val totalCostos = calcularTotalCostos()
  val totalGastos = calcularTotalGastos()
  val totalRiesgos = calcularRiesgoParcial(totalCostos + totalGastos)
  val totalImpuestos = calcularImpuestos(totalCostos,totalGastos, totalRiesgos, Riesgos.contingenciaPersonal)
  val totalCostoSoftware = totalCostos + totalGastos + totalRiesgos + totalImpuestos
  println(s"\n\n\t\t\tEl costo de desarrollo del software es de $$$totalCostoSoftware")
}