package test.geo

import luzombra.geometry.linearAlgebra.RotMat.{Z_Axis, Y_Axis, X_Axis}
import luzombra.geometry.linearAlgebra.{RotMat, Point3D, Mat4x4}
import org.scalatest.FunSuite

/**
 * Unit Tests for Mat4x4
 */
class Mat4x4Suite extends FunSuite {

  test("Multiplying two matrices together; verified with other implementation") {
    val a = new Mat4x4((0, 1, 2, 3), (4, 5, 6, 7), (8, 9, 10, 11), (12, 13,14, 15))
    val b = new Mat4x4((0, 1, 2, 3), (4, 5, 6, 7), (8, 9, 10, 11), (12, 13,14, 15))
    assert(a * b == new Mat4x4((56, 62, 68, 74), (152, 174, 196, 218),
                        (248, 286, 324, 362), (344, 398, 452, 506)))
  }

  test("Determinant of 4x4 Matrices; verified with other implementations") {
    val a = new Mat4x4((1, 0, 0, 0), (0, 1, 0, 0), (0, 0, 1, 0), (0, 0, 0, 1))
    val b = new Mat4x4((1, 1, 2, -1), (2, 2, 7, 4), (2, 4, 5, -6), (1, 2, 2, 3))
    assert(Mat4x4.det(a.getArray).toInt === 1)
    assert(Mat4x4.det(b.getArray).toInt === -42)
  }

  test("Inverse of Mat4x4") {
    val a = new Mat4x4((1, 0, 0, 0), (0, 1, 0, 0), (0, 0, 1, 0), (0, 0, 0, 1))
    val b = new Mat4x4((1, 1, 2, -1), (2, 2, 7, 4), (2, 4, 5, -6), (1, 2, 2, 3))
    assert(a.inv.getArray.map(_.toInt) === a.getArray.map(_.toInt))
    assert(b.inv.inv.getArray.map(_.round.toInt) === b.getArray.map(_.toInt))
  }

  test("Rotation of Point3D, X_Axis") {
    val a = new Point3D(1, 1, 1)
    val b = RotMat(RotMat.X_Axis, scala.math.Pi / 2)
    val c = b * a
    val d = c.get
    val e = (b.inv * c).get
    val f = (b.inv * b * a).get
    assert((d._1.toInt, d._2.toInt, d._3.toInt) == (1, -1, 1))
    assert((e._1.toInt, e._2.toInt, e._3.toInt) == (1, 1, 1))
    assert((f._1.toInt, f._2.toInt, f._3.toInt) == (1, 1, 1))
  }

  test("Rotation of Point3D, Y_Axis") {
    val a = new Point3D(1, 1, 1)
    val b = RotMat(RotMat.Y_Axis, scala.math.Pi / 2)
    val c = b * a
    val d = c.get
    val e = (b.inv * c).get
    val f = (b.inv * b * a).get
    assert((d._1.toInt, d._2.toInt, d._3.toInt) == (1, 1, -1))
    assert((e._1.toInt, e._2.toInt, e._3.toInt) == (1, 1, 1))
    assert((f._1.toInt, f._2.toInt, f._3.toInt) == (1, 1, 1))
  }

  test("Rotation of Point3D, Z_Axis") {
    val a = new Point3D(1, 1, 1)
    val b = RotMat(RotMat.Z_Axis, scala.math.Pi / 2)
    val c = b * a
    val d = c.get
    val e = (b.inv * c).get
    val f = (b.inv * b * a).get
    assert((d._1.toInt, d._2.toInt, d._3.toInt) == (-1, 1, 1))
    assert((e._1.toInt, e._2.toInt, e._3.toInt) == (1, 1, 1))
    assert((f._1.toInt, f._2.toInt, f._3.toInt) == (1, 1, 1))
  }

  test("Rotation of Point3D, All Axes") {
    val x = new RotMat(X_Axis, scala.math.Pi / 2)
    val y = new RotMat(Y_Axis, scala.math.Pi / 2)
    val z = new RotMat(Z_Axis, scala.math.Pi / 2)
    val p3 = new Point3D(1, 1, 1)
    val a = (x * y * z * p3).get
    assert((a._1.toInt, a._2.toInt, a._3.toInt) == (1, -1, 1))
  }

}
