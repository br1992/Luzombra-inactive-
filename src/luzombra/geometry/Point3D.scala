package luzombra.geometry

/**
 * Created by STUDLER on 1/21/15.
 */

class Point3D(x: Float, y: Float, z: Float) extends Vec3D(x, y, z) {
  type A = this.type

}

object Point3D {
  def apply(x: Float, y: Float, z: Float) = new Point3D(x, y, z)
}
