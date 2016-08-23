package luzombra.geometry.linearAlgebra

/**
 * Provides Vecs of size four for use in Mat4x4
 */

object Vec4 {

  type Vec4 = (Float, Float, Float, Float)

  /** Returns the dot product of two vec4s */
  def dot(a: Vec4, b: Vec4): Float = reduce(map2(a, b)(_ * _))(_ + _)

  /** Returns a new vec4 made by applying a function to the elements of two vec4s */
  def map2(a: Vec4, b: Vec4)(f: (Float, Float) => Float): Vec4 = {
    (f(a._1, b._1), f(a._2, b._2), f(a._3, b._3), f(a._4, b._4))
  }

  /** Returns a new vec4 made by applying a function to the elements of a vec4 */
  def map(vec: Vec4)(f: Float => Float): Vec4 = {
    (f(vec._1), f(vec._2), f(vec._3), f(vec._4))
  }

  /** Returns a Float made by repeatedly applying a function to pairs of elements of a vec4 */
  def reduce(vec: Vec4)(f: (Float, Float) => Float): Float = {
    f(f(vec._1, vec._2), f(vec._3, vec._4))
  }

}
