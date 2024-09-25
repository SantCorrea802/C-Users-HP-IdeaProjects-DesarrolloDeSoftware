import Lectura._

object Impuestos {

}

// calculamos los impuestos
def calcularImpuestos(costos: Double, gastos: Double, riesgo: Double, ganancias: Double): Double = {
  val baseImpuestos1 = costos + gastos + riesgo + ganancias
  val retencionFuente = baseImpuestos1 * 0.11
  val baseImpuestos2 = costos + gastos + riesgo
  val reteica = retencionFuente*0.01
  val iva = (baseImpuestos2 + retencionFuente) * 0.19
  val totalImpuestos = reteica + retencionFuente + iva
  totalImpuestos
}