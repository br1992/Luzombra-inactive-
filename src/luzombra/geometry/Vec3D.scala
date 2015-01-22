package luzombra.geometry

/**
 * Created by STUDLER on 1/21/15.
 */
abstract class Vec3D(x: Float, y: Float, z: Float) {
  type A <: Vec3D

  def +(vec: A): A = this.map2(vec)(_ + _)

  def -(vec: A): A = this.map2(vec)(_ - _)

  def *[N](scalar: N)(implicit ev1: N => Double): A = this.map(_ * scalar)

  def map(f: Double => Double): A = Vec3D.fromVec(Vec3D.map(this.get)(f))

  def map2(vec: A)(f: (Double, Double) => Double): A = Vec3D.fromVec[A]{
    Vec3D.map2(this.get, vec.get)(f)
  }

  def reduce(f: (Double, Double) => Double): Double = f(this.x, f(this.y, this.z))

  val get: (Double, Double, Double) = (this.x.toDouble, this.y.toDouble, this.z.toDouble)

}

object Vec3D {
  type Vec = (Double, Double, Double)

  def apply[A <: Vec3D](x: Float, y: Float, z: Float) = new A(x, y, z)

  def map2(a: Vec, b: Vec)(f: (Double, Double) => Double): Vec = {
    (f(a._1, b._1), f(a._2, b._2), f(a._3, b._3))
  }

  def map(vec: Vec)(f: Double => Double): Vec = (f(vec._1), f(vec._2), f(vec._3))

  def fromVec[A <: Vec3D](vec: Vec): A = apply[A](vec._1.toFloat, vec._2.toFloat, vec._3.toFloat)

}

