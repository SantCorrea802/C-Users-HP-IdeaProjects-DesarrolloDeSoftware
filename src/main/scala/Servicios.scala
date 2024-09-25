import scala.io.StdIn.*
import scala.language.postfixOps
import Lectura._

object Servicios {

}

// Funcion para calcular los servicios del software
def calcularServicios(): Double = {
  val costoServicios = solicitarDatoDouble("Ingrese el costo total de los servicios publicos y otros (internet, energía, papelería): ")
  val meses = solicitarDatoInt("Ingrese la cantidad de meses a pagar por los servicios: ")
  meses * costoServicios
}