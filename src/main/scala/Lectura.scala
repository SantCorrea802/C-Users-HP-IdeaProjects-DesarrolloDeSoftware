import scala.io.StdIn.{readDouble, readInt}

object  Lectura {

}
  def solicitarDatoDouble(mensaje: String): Double = {
    try {
      println(mensaje)
      readDouble()
    } catch {
      case _: NumberFormatException =>
        solicitarDatoDouble("Entrada no válida, ingrese un número")
    }
  }

  def solicitarDatoInt(mensaje: String): Int = {
    try {
      println(mensaje)
      readInt()
    } catch {
      case _: NumberFormatException =>
        solicitarDatoInt("Entrada no válida, ingrese un número")
    }
  }