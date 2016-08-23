package luzombra.geometry.linearAlgebra

/** Mat4x4 that scales vectors
  *
  * @param x scaling long x-axis
  * @param y scaling long y-axis
  * @param z scaling long z-axis
  */
class ScaleMat(val x: Float, val y: Float, val z: Float) extends Mat4x4(
  (x, 0, 0, 0), (0, y, 0, 0), (0, 0, z, 0), (0, 0, 0, 1)) {

  /** Returns a scaleMat that reverses the scaling by this scaleMat */
  override val inv: ScaleMat = ScaleMat(1/x, 1/y, 1/z)

}

object ScaleMat {

  /** Returns new scaleMat */
  def apply(x: Float, y: Float, z: Float): ScaleMat = new ScaleMat(x, y, z)

}
