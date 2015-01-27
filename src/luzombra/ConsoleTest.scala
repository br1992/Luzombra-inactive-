package luzombra

import luzombra.geometry.Mat4x4

/**
 * Created by STUDLER on 1/25/15.
 */
object ConsoleTest extends App{
  println(Mat4x4((1, 0, 0, 0), (0, 1, 0, 0), (0, 0, 1, 0), (0, 0, 0, 1)).getArray)
}
