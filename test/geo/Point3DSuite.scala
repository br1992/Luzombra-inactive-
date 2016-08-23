package test.geo

/**
 * Unit Tests for Point3D
 */

import luzombra.geometry.linearAlgebra.Point3D
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.util.Random.nextFloat

class Point3DSuite extends FunSuite with BeforeAndAfter {

  var a: Point3D = _
  var b: Point3D = _

  def f = nextFloat

  before {
    a = Point3D(f, f, f)
    b = Point3D(f, f, f)
  }

  test("Two point3Ds added together") {
    val c = a + b
    val aa = a.get
    val bb = b.get
    val cc = c.fromCoor3(aa._1 + bb._1, aa._2 + bb._2, aa._3 + bb._3)
    assert(c.get === cc.get)
    assert(c.==(cc))
  }

  test("Two point3Ds subtracted together") {
    val c = a - b
    val aa = a.get
    val bb = b.get
    val cc = (aa._1 - bb._1, aa._2 - bb._2, aa._3 - bb._3)
    assert(c.get === c.fromCoor3(cc).get)
  }

  test("Reduce a vector using addition") {
    val sum = a.reduce(_ + _)
    val aa = a.get
    val sum2 = aa._1 + aa._2 + aa._3
    assert(sum === sum2)
  }

}
