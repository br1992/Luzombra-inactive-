package luzombra.geometry

import luzombra.geometry.RotMat._
import scala.math.{cos, sin}

/**
 * Created by STUDLER on 1/26/15.
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
  axis match {
    case X_Axis => (0.0, 0.0, 0.0, 1.0)
    case Y_Axis => (0.0, 0.0, 0.0, 1.0)
    case Z_Axis => (0.0, 0.0, 0.0, 1.0)
  }) {

  override val inv: RotMat = RotMat(axis, -rads)

}

object RotMat {

  sealed abstract class Axis
  object X_Axis extends Axis
  object Y_Axis extends Axis
  object Z_Axis extends Axis

  def apply(axis: Axis, rads: Double): RotMat = new RotMat(axis, rads)

}
