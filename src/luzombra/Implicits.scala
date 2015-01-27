package luzombra

/**
 * Implicit conversions to simplify code.
 */
object Implicits {
  implicit def int2Float(x: Int): Float = x.toFloat
  implicit def int2Double(x: Int): Float = x.toDouble
  implicit def float2Double(x: Float): Double = x.toDouble
  implicit def double2Float(x: Double): Float = x.toFloat
}
