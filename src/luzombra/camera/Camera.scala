package luzombra.camera

import luzombra.geometry.linearAlgebra.Ray

/**
 * Created by STUDLER on 2/24/15.
 */
abstract class Camera(val zNear: Float = -.1F, val zFar: Float = -100.0F,
                      val fieldOfViewX: Float = math.Pi.toFloat / 2.0F) {

  def eyeRay(x: Float, y: Float, width: Int, height: Int): Ray

}
