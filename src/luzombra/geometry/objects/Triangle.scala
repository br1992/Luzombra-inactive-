package luzombra.geometry.objects

import luzombra.geometry.linearAlgebra.{Dir3D, Point3D}
import luzombra.material.Color

/**
 * Created by STUDLER on 2/9/15.
 */
class Triangle(val points: (Point3D, Point3D, Point3D), val norms: (Dir3D, Dir3D, Dir3D),
                val color: Color) {

  val normal: Dir3D = {
    val n = (points._2 - points._1) x (points._3 - points._1)
    n.unit
  }

}
