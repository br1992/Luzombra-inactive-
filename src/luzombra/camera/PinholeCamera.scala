package luzombra.camera

import luzombra.geometry.linearAlgebra.Vec3D.Coor3
import luzombra.geometry.linearAlgebra.{Dir3D, Point3D, Vec3D, Ray}
import luzombra.Implicits._

/**
 * Created by STUDLER on 2/9/15.
 */
class PinholeCamera(zNear: Float = -.1F, zFar: Float = -100.0F,
                    fieldOfViewX: Float = math.Pi.toFloat / 2.0F)
  extends Camera(zNear, zFar, fieldOfViewX) {

  def eyeRay(x: Float, y: Float, width: Int, height: Int): Ray = {
    val aspect = height.toFloat / width
    val s: Float = -2.0F * math.tan(this.fieldOfViewX * .5).toFloat
    val vec: Coor3 = Vec3D.map((x / width - .5F) * s, -(y / height - .5F) * s * aspect, 1.0F)(_ * zNear)
    Ray(Point3D(vec._1, vec._2, vec._3), Dir3D(vec._1, vec._2, vec._3).unit)
  }

}
