package luzombra.geometry

/**
 * Created by STUDLER on 1/21/15.
 */
abstract class Matrix {
  def *[A <: Matrix](mat: A): A
}
