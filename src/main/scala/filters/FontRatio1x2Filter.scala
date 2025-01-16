package filters
import arrayImages.Image

import scala.collection.mutable.ArrayBuffer

/**
 * Fixes most common monospace font ratio (1x2) by squishing the image
 */
class FontRatio1x2Filter extends Filter {
    override def apply(img: Image[Int]): Image[Int] = {
        val tmp = new ArrayBuffer[Int]()
        for (y <- 1 until img.height by 2) {
            for (x <- 0 until img.width) {
                tmp += (img.getPixel(x, y-1) + img.getPixel(x, y)) / 2
            }
        }

        val grouped = tmp.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq
        new Image[Int](grouped)

    }
}
