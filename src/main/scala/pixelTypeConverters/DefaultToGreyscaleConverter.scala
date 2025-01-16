package pixelTypeConverters

import arrayImages.Image
import arrayImages.pixels.RgbPixel

import scala.collection.mutable.ArrayBuffer

/**
 * Converts RGB image to greyscale using fancy formula
 */
class DefaultToGreyscaleConverter extends PixelTypeConverter[RgbPixel, Int] {

    override def convert(img: Image[RgbPixel]): Image[Int] = {

        val arr = new ArrayBuffer[Int]()
        for (y <- 0 until img.height) {
            for (x <- 0 until img.width) {
                val p: RgbPixel = img.getPixel(x, y)
                val avg: Int = (0.3 * p.r + 0.59 * p.g + 0.11 * p.b).round.toInt
                arr += avg
            }
        }

        new Image[Int](arr.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq)

    }
}
