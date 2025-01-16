package filters

import arrayImages.Image
import org.scalatest.FunSuite

class FontRatio1x2FilterTest extends FunSuite {
    test("Three row image") {
        val img = new Image(Seq(Seq(2, 255),Seq(4, 255),Seq(6, 7)))
        val f = new FontRatio1x2Filter
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 3)
        assert(fImg.getPixel(1, 0) == 255)
        // We don't care about the last row. The implementation can decide to keep it or throw it away
    }
}
