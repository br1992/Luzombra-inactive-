package luzombra.geometry

/**
 * Created by STUDLER on 1/21/15.
 */
class Dir3D(x: Float, y: Float, z: Float) extends Vec3D(x, y, z) {
  type A = this.type

  def unit: A = {
    val len = math.sqrt(this.map(math.pow(_, 2)).reduce(_ + _))
    if(len != 0) this.map(_ / len)
    else this
  }

//  def cross(vec: Dir3D): Dir3D = ???

//  def dot(vec: Dir3D): Double =
}

object Dir3D {
  def apply(x: Float, y: Float, z: Float): Dir3D = new Dir3D(x, y, z)
}
