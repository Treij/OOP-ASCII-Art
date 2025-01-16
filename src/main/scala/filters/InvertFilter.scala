package filters
import arrayImages.Image

import scala.collection.mutable.ArrayBuffer

class InvertFilter() extends Filter {
    override def apply(img: Image[Int]): Image[Int] = {
        val tmp = new ArrayBuffer[Int]()
        for (y <- 0 until img.height) {
            for (x <- 0 until img.width) {
                tmp += 255 - img.getPixel(x, y)
            }
        }

        new Image[Int](tmp.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq)
    }
}
