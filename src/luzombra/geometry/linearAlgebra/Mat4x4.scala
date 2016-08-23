package luzombra.geometry.linearAlgebra

import luzombra.geometry.linearAlgebra.Vec4._

/** Matrix of size 4 by 4 for geometric transformations
  *
  * @param col0 first column of matrix
  * @param col1 second column of matrix
  * @param col2 third column of matrix
  * @param col3 fourth column of matrix
  */
class Mat4x4(col0: Vec4, col1: Vec4, col2: Vec4, col3: Vec4) extends Immutable {

  private val arr = Array(col0._1, col0._2, col0._3, col0._4,
                          col1._1, col1._2, col1._3, col1._4,
                          col2._1, col2._2, col2._3, col2._4,
                          col3._1, col3._2, col3._3, col3._4)

  /** Returns the float at given row and col indices */
  def at(row: Int, col: Int): Float = {
    arr(row + col * 4)
  }

  /** Returns the float at given index */
  def at(index: Int): Float = {
    arr(index)
  }

  /** Returns a copy of arr with Floats */
  def getArray: Array[Float] = arr.clone()

  /** Returns the vector at row r */
  def row(r: Int): Vec4 = (at(r, 0), at(r, 1), at(r, 2), at(r, 3))

  /** Returns the vector at col c */
  def col(c: Int): Vec4 = (at(0, c), at(1, c), at(2, c), at(3, c))

  /** Returns a new mat4x4 created from the multiplication of this mat4x4 and mat */
  def *(mat: Mat4x4): Mat4x4 = {
    Mat4x4((dot(this.row(0), mat.col(0)), dot(this.row(1), mat.col(0)),
      dot(this.row(2), mat.col(0)), dot(this.row(3), mat.col(0))),
      (dot(this.row(0), mat.col(1)), dot(this.row(1), mat.col(1)),
        dot(this.row(2), mat.col(1)), dot(this.row(3), mat.col(1))),
      (dot(this.row(0), mat.col(2)), dot(this.row(1), mat.col(2)),
        dot(this.row(2), mat.col(2)), dot(this.row(3), mat.col(2))),
      (dot(this.row(0), mat.col(3)), dot(this.row(1), mat.col(3)),
        dot(this.row(2), mat.col(3)), dot(this.row(3), mat.col(3))))
  }

  def *(vec: Point3D): Point3D = {
    val a = vec.get
    val vec4 = (a._1, a._2, a._3, 1.0F)
    val unnormVec4 = (dot(this.row(0), vec4), dot(this.row(1), vec4),
      dot(this.row(2), vec4), dot(this.row(3), vec4))
    val normVec4 = map(unnormVec4)(a => a / unnormVec4._4)
    Point3D(normVec4._1.toFloat, normVec4._2.toFloat, normVec4._3.toFloat)
  }

  /** Returns the inverse of this mat4x4 */
  def inv : Mat4x4 = {
    Mat4x4.fromArray(Mat4x4.inv(this.getArray))
  }

  /** Returns the determinant of this mat4x4 */
  def det: Float = Mat4x4.det(this.getArray)

  /** Returns true if all elements of this mat4x4 and mat are equal */
  def ==(mat: Mat4x4): Boolean = {
    (for(i <- 0 to 15) yield this.at(i) == mat.at(i)).forall(a => a)
  }

}

object Mat4x4 {

  def apply(col0: Vec4, col1: Vec4, col2: Vec4, col3: Vec4) = new Mat4x4(col0, col1, col2, col3)

  /** Returns a new mat4x4 containing the identity matrix */
  def I: Mat4x4 = Mat4x4((1, 0, 0, 0), (0, 1, 0, 0), (0, 0, 1, 0), (0, 0, 0, 1))

  /** Returns the determinant of mat using Laplace's expansion */
  def det(mat: Array[Float]): Float = {

    def d(mat: Array[Float]): Float = {
      val n = math.sqrt(mat.length).toInt
      if(n == 2) mat(0) * mat(3) - mat(1) * mat(2)
      else {
        var d = 0.0F
        for(i <- 0 until n) {
          d += det(c(mat, i, 0, n)) * mat(i) * (if(i % 2 == 0) 1 else -1)
        }
        d
      }
    }

    if(math.sqrt(mat.length) % 1.0 != 0) throw new IllegalArgumentException
    else d(mat)

  }

  /** Returns an array containing a square matrix made up by the cofactors of the
    * element at the given row and col indices
    */
  private def c(mat: Array[Float], row: Int, col: Int, n: Int): Array[Float] = {
    val m = for(i <- 0 until mat.length if(!(i / n == col || i % n == row))) yield mat(i)
    m.toArray
  }

  /** Returns an array containing the inverse of mat using the determinant and cofactor matrices */
  def inv(mat: Array[Float]): Array[Float] = {
    val n = math.sqrt(mat.length).toInt
    val newMat = for(i <- 0 until mat.length) yield det(c(mat, i / n, i % n, n)) * (if((i / n + i % n) % 2 == 0) 1 else -1)
    val d = det(mat)
    newMat.toArray.map(_ / d)
  }

  /** Returns a new mat4x4 made from an array */
  private def fromArray(mat: Array[Float]): Mat4x4 = {
    Mat4x4((mat(0), mat(1), mat(2), mat(3)), (mat(4), mat(5), mat(6), mat(7)),
      (mat(8), mat(9), mat(10), mat(11)), (mat(12), mat(13), mat(14), mat(15)))
  }

}
