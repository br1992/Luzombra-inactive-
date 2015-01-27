package luzombra.geometry

import luzombra.Implicits.double2Float

/** 3D point with common operations
  *
  * @param x x-coordinate
  * @param y y-coordinate
  * @param z z-coordinate
  */
class Point3D(x: Float, y: Float, z: Float) extends Vec3D[Point3D](x, y, z) {

  /** Returns a new dir3D from a provided coor3 */
  def fromCoor3(vec: Coor3): Point3D = Point3D(vec._1, vec._2, vec._3)

}

object Point3D {

  /** Returns a new point3D from using the provided coordinates */
  def apply(x: Float, y: Float, z: Float): Point3D = new Point3D(x, y, z)
}

