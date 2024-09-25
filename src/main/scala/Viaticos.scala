import scala.compiletime.ops.double
import scala.io.StdIn.*
import scala.language.postfixOps
import Lectura._

object Viaticos {

}

def calcularViaticos(): Double = {
  println("\n\tTOTAL VIATICOS")
  val viaticosEmpleados = preguntarEmpleados(Vector.empty[Double])
  val sumaTotalViaticos = viaticosEmpleados.sum
  sumaTotalViaticos
}

def calcularTransporte(): Double = {
  println("\n\tTRANSPORTE")
  val opcionTransporte = solicitarDatoInt("Ingresa el medio de transporte que usará el empleado" +
    "\n1) Bus\n2) Avion\n3) Vehiculo personal\n4) Salir")

  opcionTransporte match{
    case 1 => val costoTransporte = 50000.0
      costoTransporte
    case 2 => val costoTransporte = 350000.0
      costoTransporte
    case 3 => val costoTransporte = 35000.0
      costoTransporte
    case 4 => 0.0
    case _ => println("Entrada no válida")
      calcularTransporte()
  }
}

def calcularCostoAlojamiento(): Double = {
  println("\n\tALOJAMIENTO")
  val alojamiento = solicitarDatoInt("Ingrese la cantidad de dias de alojamiento")
  val costoDias = alojamiento * 90000.0
  costoDias
}

// Esta funcion calcula el plan de alimentacion de cada empleado
// pasa como parametro el costoAlojamiento para luego encontrar los dias, ya que los necesitamos
def calcularCostoAlimentacion(costoAlojamiento: Double): Double = {
  println("\n\tALIMENTACIÓN")
  val diasAlojamiento = costoAlojamiento/90000.0 // encontramos los dias de alojamiento para poder usarlos
  val opcionAlimentacion = solicitarDatoInt("Ingresa el plan de alimentacion del empleado\n1) Basico\n2) Completo\n3) Salir")
  opcionAlimentacion match{
    case 1 => val costoAlimentacion = diasAlojamiento * 30000.0
      costoAlimentacion
    case 2 => val costoAlimentacion = diasAlojamiento * 60000.0
      costoAlimentacion
    case 3 => 0.0
    case _ => println("Entrada no válida")
      calcularCostoAlimentacion(costoAlojamiento)
  }
}

// Este metodo se encarga de almacenar la informacion de los viaticos de cuantos empleados quiera el usuario
def preguntarEmpleados(acc: Vector[Double]): Vector[Double] = {
  val costoTransporte = calcularTransporte()
  val costoAlojamiento = calcularCostoAlojamiento()
  val costoAlimentacion = calcularCostoAlimentacion(costoAlojamiento)
  val viaticosPorEmpleado = costoTransporte + costoAlojamiento + costoAlimentacion
  val acumulador = acc :+ viaticosPorEmpleado // agregamos al vector acumulador lo que habia en acc y al final agregamos el valor viaticosPorEmpleado
  val opcion = solicitarDatoInt("\nIngresa (1) para ingresar los viaticos de otro empleado " +
    "o ingrese cualquier otro numero para finalizar")

  if (opcion == 1) { // Si el usuario desea ingresar nuevamente la informacion de un empleado, volverá a preguntar por los viaticos
    preguntarEmpleados(acumulador)
  } else {
    acumulador
  }
}