package luzombra.geometry.linearAlgebra

import breeze.linalg.{cross, DenseVector}
import breeze.numerics.sqrt

/** 3D direction vector with common operations
  *
  * @param x x-coordinate
  * @param y y-coordinate
  * @param z z-coordinate
  */
class Dir3D( val dir3D: DenseVector[Float]) extends Vec3D[Dir3D](x, y, z) {

  assert(dir3D.length == 3)

  /** Returns a new dir3D whose direction is equivalent to this dir3D's,
    * but with a length of 1
    */
  val unit: Dir3D = {
    Dir3D(dir3D / sqrt(dir3D.t * dir3D))
  }

  /** Returns a new dir3D that results from the cross-product of this vector and vec */
  def x(vec: Dir3D): Dir3D = {
    Dir3D(cross(dir3D, vec.dir3D))
  }

  /** Returns a new point3D formed by scaling this dir3D with scalar */
  def **(scalar: Float): Point3D = {
    val temp = Vec3D.map(this.get)(_ * scalar)
    Point3D(temp._1, temp._2, temp._3)
  }

  /** Returns a Float that results from the dot-product of this vector and vec */
  def o(vec: Dir3D): Float = map2(vec)(_ * _).reduce(_ + _)

  /** Returns a new dir3D from a provided coor3 */
  def fromCoor3(vec: Coor3): Dir3D = new Dir3D(vec._1, vec._2, vec._3)
}

object Dir3D {

  /** Returns a new dir3D from using the provided coordinates */
  def apply(x: Float, y: Float, z: Float): Dir3D = new Dir3D(DenseVector(x, y, z))

  def apply(dir3D: DenseVector[Float]): Dir3D = new Dir3D(dir3D)

}
