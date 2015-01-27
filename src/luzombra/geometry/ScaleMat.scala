package luzombra.geometry

/**
 * Created by STUDLER on 1/26/15.
 */
class ScaleMat(val x: Double, val y: Double, val z: Double) extends Mat4x4(
  (x, 0, 0, 0), (0, y, 0, 0), (0, 0, z, 0), (0, 0, 0, 1)) {

  override val inv: ScaleMat = ScaleMat(1/x, 1/y, 1/z)

}

object ScaleMat {

  def apply(x: Double, y: Double, z: Double): ScaleMat = new ScaleMat(x, y, z)

}
