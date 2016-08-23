package luzombra

import luzombra.camera.{BarycentricRenderer, Image, PinholeCamera}
import luzombra.geometry.linearAlgebra.{Dir3D, Point3D}
import luzombra.geometry.objects.{Triangle, Scene}
import luzombra.material.Color

/**
 * Created by STUDLER on 1/25/15.
 */
object ConsoleTest extends App{
  val image = new Image(800, 500)
  image.setPixels(Color(0, 0, 0))
  var tri = new Triangle((Point3D(-1.75f, -1, -2), Point3D(1.75f, -1, -2), Point3D(0, 1, -2)),
    (Dir3D(0, 0, 0), Dir3D(0, 0, 0), Dir3D(0, 0, 0)), Color(0, 0, 0))
  new BarycentricRenderer(image, new Scene(Array(tri), Array.empty),
    new PinholeCamera()).forEachPixel()
  image.save("/Users/STUDLER/Desktop/aa.png")
}
