import scala.io.StdIn.*
import Lectura._

object Riesgos {

  // Ya que necesitamos saber el valor de ganancia o gasto para calcular el software mas adelante
  // Creamos una variable de objeto inmutable para almacenar el valor de este
  // Y poder usarlo cuando lo necesitamos
  val contingenciaPersonal = calcularContingenciaPersonal()
}

// Calculamos un riesgoParcial para usar mas adelante
def calcularRiesgoParcial(totalCostoDesarrollo: Double): Double = {
  // por medio de la variable de objeto, llamamos la funcion calcularContigenciaPersonal()
  val costoRiesgoParcial: Double = Riesgos.contingenciaPersonal
  println(s"\nEl valor de riesgo parcial es $$$costoRiesgoParcial")
  limite(costoRiesgoParcial, totalCostoDesarrollo)
}

// Calculamos el limite de costo de riesgos que podemos asignar al desarrollo del software
def limite(costoRiesgoParcial: Double, totalCostoDesarrollo: Double): Double = {
  if (costoRiesgoParcial > totalCostoDesarrollo * 0.5){
    println("El valor calculado supera el 50% del total, por lo tanto lo maximo que se pude permitir como valor de riesgo es el 50% del mismo")
    val limiteriesgo: Double = totalCostoDesarrollo * 0.5
    println(s"Es decir $$$limiteriesgo")
    limiteriesgo
  }else{
    println("El valor del riesgo es su total anteriormente calculado")
    val limiteriesgo: Double = costoRiesgoParcial
    limiteriesgo
  }
}

// Calcula la contingencia dependiendo se si el reisgo ha sido o no materializado
def calcularContingenciaPersonal(): Double = {
  val materializado = solicitarDatoInt("Ingrese si el riesgo fue materializado\n1) si\n2) no")
  materializado match{
    case 1 => val gastos = solicitarDatoDouble("Ingrese los gastos de este riesgo: ")
      gastos * tiempoPerdido() // como el reisgo se ha materializado, debemos multiplicarlo por el tiempo perdido
    case 2 => val gastos = solicitarDatoDouble("Ingrese la ganancia: ")
      gastos
    case _ => println("Ingrese una entrada válida")
      calcularContingenciaPersonal()
  }
}

// Calculamos el tiempo perdido para multiplicar por el gasto
def tiempoPerdido(): Double = {
  val tiempo = solicitarDatoDouble("Ingrese la cantidad de tiempo perdido en horas: ")
  val costoHora: Double = 5531 // costo de hora en colombia
  tiempo * costoHora
}