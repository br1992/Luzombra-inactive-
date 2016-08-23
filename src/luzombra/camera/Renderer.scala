package luzombra.camera

import luzombra.Implicits._
import luzombra.geometry.linearAlgebra.Ray
import luzombra.geometry.objects.{Scene, Triangle}
import luzombra.material.Color

/**
 * Created by STUDLER on 2/24/15.
 */
abstract class Renderer(val image: Image, val scene: Scene, val camera: Camera) {

  def raytrace(x: Int, y: Int): Unit = {

  }

  def forEachPixel(): Unit = {
    for(y <- 0 until image.height) {
      for (x <- 0 until image.width) {
        raytrace(x, y)
      }
    }
  }

  def sampleRayTriangle(ray: Ray, tri: Triangle): Option[(Float, Color)] = {
    val weight = new Array[Float](3)
    val d = intersect(ray, tri, weight)
    if(!d.isDefined) None
    else {
      val dist = d.get
      val intersection = ray.pos + ray.dir ** dist
      val normal = tri.norms._1 * weight(0) +
        tri.norms._2 * weight(1) + tri.norms._3 * weight(2)
      val w_o = ray.dir.map(-_)
      Some(dist, Color(weight(0), weight(1), weight(2)))
    }
  }

  def intersect(ray: Ray, tri: Triangle, weight: Array[Float]): Option[Float] = {
    val points = tri.points
    val e1 = points._2 - points._1
    val e2 = points._3 - points._1
    val q = ray.dir x e2
    val a = e1 o q
    val s = ray.pos - points._1
    val r = s x e1

    weight(1) = (s o q) / a
    weight(2) = (ray.dir o r) / a
    weight(0) = 1.0 - (weight(1) + weight(2))
    val dist: Float = (e2 o r) / a

    val epsilon = 1e-7f
    val epsilon2 = 1e-10

    if ((a <= epsilon) || (weight(0) < -epsilon2) || (weight(1) < -epsilon2) ||
    (weight(2) < -epsilon2) || (dist <= 0.0f)) {
      None
    } else Some(dist)
  }

}
