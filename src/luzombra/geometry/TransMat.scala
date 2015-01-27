package luzombra.geometry

/**
 * Created by STUDLER on 1/26/15.
 */
class TransMat(val x: Double, val y: Double, val z: Double) extends Mat4x4(
  (1, 0, 0, 0), (0, 1, 0, 0), (0, 0, 1, 0), (x, y, z, 1)) {

  override val inv: TransMat = TransMat(-x, -y, -z)

}

object TransMat {

  def apply(x: Double, y: Double, z: Double): TransMat = new TransMat(x, y, z)

}
