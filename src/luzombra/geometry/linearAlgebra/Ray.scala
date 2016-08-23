package luzombra.geometry.linearAlgebra

/**
 * Created by STUDLER on 2/10/15.
 */
class Ray(val pos: Point3D, val dir: Dir3D) {

}

object Ray {

  def apply(pos: Point3D, dir: Dir3D): Ray = new Ray(pos, dir)

}
