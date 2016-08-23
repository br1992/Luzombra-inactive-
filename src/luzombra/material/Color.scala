package luzombra.material

import luzombra.Implicits._

/**
 * Created by STUDLER on 2/9/15.
 */
class Color(val rgb: (Float, Float, Float)) {

  def *(color: Color): Color = {
    val a = (this.rgb._1.toDouble, this.rgb._1.toDouble, this.rgb._1.toDouble)
    val b = (color.rgb._1.toDouble, color.rgb._1.toDouble, color.rgb._1.toDouble)
    Color(a._1 * b._1, a._2 * b._2, a._3 * b._3)
  }

}

object Color {

  def apply(a: Float, b: Float, c: Float): Color = new Color(a, b, c)

}