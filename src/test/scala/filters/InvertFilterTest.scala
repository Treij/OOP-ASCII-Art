package filters

import arrayImages.Image
import org.scalatest.FunSuite

class InvertFilterTest extends FunSuite {
    test("Inverting") {
        val img = new Image(Seq(Seq(0, 127, 128, 255)))
        val f = new InvertFilter
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 255)
        assert(fImg.getPixel(1, 0) == 128)
        assert(fImg.getPixel(2, 0) == 127)
        assert(fImg.getPixel(3, 0) == 0)
    }
}
