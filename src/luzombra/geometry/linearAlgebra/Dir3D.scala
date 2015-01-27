package luzombra.geometry.linearAlgebra

import luzombra.Implicits.double2Float

/** 3D direction vector with common operations
  *
  * @param x x-coordinate
  * @param y y-coordinate
  * @param z z-coordinate
  */
class Dir3D(x: Float, y: Float, z: Float) extends Vec3D[Dir3D](x, y, z) {

  /** Returns a new dir3D whose direction is equivalent to this dir3D's,
    * but with a length of 1
    */
  def unit: Dir3D = {
    val len = math.sqrt(this.map(math.pow(_, 2)).reduce(_ + _))
    if(len != 0) this.map(_ / len)
    else this
  }

  /** Returns a new dir3D that results from the cross-product of this vector and vec */
  def cross(vec: Dir3D): Dir3D = {
    val a = this.get; val b = vec.get
    val x = a._2 * b._3 - a._3 * b._2
    val y = a._3 * b._1 - a._1 * b._3
    val z = a._1 * b._2 - a._2 * b._1
    Dir3D(x, y, z)
  }

  /** Returns a double that results from the dot-product of this vector and vec */
  def dot(vec: Dir3D): Double = map2(vec)(_ * _).reduce(_ + _)

  /** Returns a new dir3D from a provided coor3 */
  def fromCoor3(vec: Coor3): Dir3D = new Dir3D(vec._1, vec._2, vec._3)
}

object Dir3D {

  /** Returns a new dir3D from using the provided coordinates */
  def apply(x: Float, y: Float, z: Float): Dir3D = new Dir3D(x, y, z)

}
