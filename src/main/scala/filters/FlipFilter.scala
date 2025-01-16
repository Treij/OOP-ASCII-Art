package filters

import arrayImages.Image

import scala.collection.mutable.ArrayBuffer

class FlipFilter(flipX: Boolean, flipY: Boolean) extends Filter {
    override def apply(img: Image[Int]): Image[Int] = {
        val tmp = new ArrayBuffer[Int]()
        val yIterator = if (flipX) img.height-1 to  0 by -1 else 0 until img.height
        val xIterator = if (flipY) img.width-1 to 0 by -1 else 0 until img.width
        for (y <- yIterator) {
            for (x <- xIterator) {
                tmp += img.getPixel(x, y)
            }
        }

        new Image[Int](tmp.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq)
    }
}
