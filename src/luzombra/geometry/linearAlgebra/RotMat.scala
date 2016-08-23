package luzombra.geometry.linearAlgebra

import scala.math.{cos, sin}
import luzombra.geometry.linearAlgebra.RotMat.{Axis, Z_Axis, X_Axis, Y_Axis}
import luzombra.Implicits.double2Float
/** Mat4x4 that rotates vectors
  *
  * @param axis axis of rotation (class Axis provided in companion object)
  * @param rads amount of rotation in radians
  */
class RotMat(val axis: Axis, val rads: Double) extends Mat4x4(
  axis match {
    case X_Axis => (1.0F, 0.0F, 0.0F, 0.0F)
    case Y_Axis => (cos(rads), 0.0F, -sin(rads), 0.0F)
    case Z_Axis => (cos(rads), sin(rads), 0F, 0F)
  },
  axis match {
    case X_Axis => (0.0F, cos(rads), sin(rads), 0.0F)
    case Y_Axis => (0.0F, 1.0F, 0.0F, 0.0F)
    case Z_Axis => (-sin(rads), cos(rads), 0.0F, 0.0F)
  },
  axis match {
    case X_Axis => (0.0F, -sin(rads), cos(rads), 0.0F)
    case Y_Axis => (sin(rads), 0.0F, cos(rads), 0.0F)
    case Z_Axis => (0.0F, 0.0F, 1.0F, 0.0F)
  },
  (0.0F, 0.0F, 0.0F, 1.0F)) {

  /** Returns a rotMat that reverses the rotation by this rotMat */
  override def inv: RotMat = RotMat(axis, -rads)

}

object RotMat {

  /** Enumeration of possible axes for rotation */
  sealed abstract class Axis
  object X_Axis extends Axis
  object Y_Axis extends Axis
  object Z_Axis extends Axis

  /** Returns a new rotMat */
  def apply(axis: Axis, rads: Double): RotMat = new RotMat(axis, rads)

}
