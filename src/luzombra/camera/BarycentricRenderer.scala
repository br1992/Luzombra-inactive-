package luzombra.camera

import luzombra.geometry.objects.Scene

/**
 * Created by STUDLER on 2/24/15.
 */
class BarycentricRenderer(image: Image, scene: Scene, camera: Camera)
  extends Renderer(image, scene, camera) {

  override def raytrace(x: Int, y: Int): Unit = {
    val ray = camera.eyeRay(x, y, image.width, image.height)
    var distance = Float.PositiveInfinity
    for(triangle <- scene.triangles) {
      val intersect = sampleRayTriangle(ray, triangle)
      if(intersect.isDefined) {
        distance = intersect.get._1
        val radiance = intersect.get._2
        image.setPixel(x, y, radiance)
      }
    }
  }

}
