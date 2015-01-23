package luzombra.geometry

/**
 * Created by STUDLER on 1/21/15.
 */

import luzombra.geometry.Mat4x4.Vec4F

class Mat4x4(col0: Vec4F, col1: Vec4F, col2: Vec4F, col3: Vec4F) extends Immutable {

  private val arr = Array(col0._1, col0._2, col0._3, col0._4,
                          col1._1, col1._2, col1._3, col1._4,
                          col2._1, col2._2, col2._3, col2._4,
                          col3._1, col3._2, col3._3, col3._4)

  def at(row: Int, col: Int): Float = {
    arr(row + col * 4)
  }

  def *(mat: Mat4x4): Mat4x4 = ???

}

object Mat4x4 {

  type Vec4F = (Float, Float, Float, Float)

  def apply(col0: Vec4F, col1: Vec4F, col2: Vec4F, col3: Vec4F) = new Mat4x4(col0, col1, col2, col3)

}
