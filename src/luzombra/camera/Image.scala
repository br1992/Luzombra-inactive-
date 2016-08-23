package luzombra.camera

import java.awt.image.{RenderedImage, BufferedImage}
import java.io.File
import javax.imageio.ImageIO

import luzombra.material.Color

/**
 * Created by STUDLER on 2/10/15.
 */
class Image(val width: Int, val height: Int) {

  val array = new Array[Color](width * height)

  def setPixel(x: Int, y: Int, color: Color) {
    array(x + y * width) = color
  }

  def getPixel(x: Int, y: Int): Color = array(x + y * width)

  def setPixels(color: Color) {
    for(x <- 0 until width; y <- 0 until height) array(x + y * width) = color
  }

  def save(fileName: String) {
    ImageIO.write(getImage, "png", new File(fileName))
  }

  def getImage(): RenderedImage = {
    val image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    for(y <- 0 until this.height) {
      for(x <- 0 until this.width) {
        val colors = this.getPixel(x, y).rgb
        image.setRGB(x, y, ((colors._1 * 255).toInt << 16) + ((colors._2 * 255).toInt << 8) +
          (colors._3 * 255).toInt)
      }
    }
    image
  }


}
