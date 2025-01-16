package filters

import arrayImages.Image

import scala.collection.mutable.ArrayBuffer

/**
 * Brightens the image for given amount
 * @param amount
 */
class BrightnessFilter(amount: Int) extends Filter {
    override def apply(img: Image[Int]): Image[Int] = {
        val tmp = new ArrayBuffer[Int]()
        for (y <- 0 until img.height) {
            for (x <- 0 until img.width) {
                tmp += clamp(img.getPixel(x, y) + amount, 0, 255)
            }
        }

        new Image[Int](tmp.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq)
    }

    private def clamp(x: Int, min: Int, max: Int): Int = if (x < min) min else if (x > max) max else x
}
