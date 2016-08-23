package luzombra.camera

import luzombra.geometry.objects.Scene
import luzombra.material.Color
import luzombra.Implicits._

/**
 * Created by STUDLER on 2/9/15.
 */
class TempCamRender(image: Image, scene: Scene, camera: PinholeCamera)
  extends Renderer(image, scene, camera) {
  override def raytrace(x: Int, y: Int): Unit = {
    val ray = camera.eyeRay(x + .5F, y + .5F, image.width, image.height)
    val col = ray.dir.map(x => math.pow((x + 1) / 2, 1 / 2.2F)).get
    image.setPixel(x, y, Color(col._1, col._2, col._3))
  }
}
