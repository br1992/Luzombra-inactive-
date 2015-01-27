package luzombra.geometry.linearAlgebra

/**
 * Provides Vecs of size four for use in Mat4x4
 */

object Vec4 {

  type Vec4 = (Double, Double, Double, Double)

  /** Returns the dot product of two vec4s */
  def dot(a: Vec4, b: Vec4): Double = reduce(map2(a, b)(_ * _))(_ + _)

  /** Returns a new vec4 made by applying a function to the elements of two vec4s */
  def map2(a: Vec4, b: Vec4)(f: (Double, Double) => Double): Vec4 = {
    (f(a._1, b._1), f(a._2, b._2), f(a._3, b._3), f(a._4, b._4))
  }

  /** Returns a new vec4 made by applying a funtion to the elements of a vec4 */
  def map(vec: Vec4)(f: Double => Double): Vec4 = {
    (f(vec._1), f(vec._2), f(vec._3), f(vec._4))
  }

  /** Returns a double made by repeatedly applying a function to pairs of elements of a vec4 */
  def reduce(vec: Vec4)(f: (Double, Double) => Double): Double = {
    f(f(vec._1, vec._2), f(vec._3, vec._4))
  }

}
