package luzombra.geometry.linearAlgebra

import scala.math.{cos, sin}
import RotMat._

/** Mat4x4 that rotates vectors
  *
  * @param axis axis of rotation (class Axis provided in companion object)
  * @param rads amount of rotation in radians
  */
class RotMat(val axis: Axis, val rads: Double) extends Mat4x4(
  axis match {
    case X_Axis => (1.0, 0.0, 0.0, 0.0)
    case Y_Axis => (cos(rads), 0.0, -sin(rads), 0.0)
    case Z_Axis => (cos(rads), sin(rads), 0, 0)
  },
  axis match {
    case X_Axis => (0.0, cos(rads), sin(rads), 0.0)
    case Y_Axis => (0.0, 1.0, 0.0, 0.0)
    case Z_Axis => (-sin(rads), cos(rads), 0.0, 0.0)
  },
  axis match {
    case X_Axis => (0.0, -sin(rads), cos(rads), 0.0)
    case Y_Axis => (sin(rads), 0.0, cos(rads), 0.0)
    case Z_Axis => (0.0, 0.0, 1.0, 0.0)
  },
  (0.0, 0.0, 0.0, 1.0)) {

  /** Returns a rotMat that reverses the rotation by this rotMat */
  override val inv: RotMat = RotMat(axis, -rads)

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
