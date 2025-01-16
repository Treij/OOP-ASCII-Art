package filters

import arrayImages.Image
import org.scalatest.FunSuite

class MultiFilterTest extends FunSuite {
    val img = new Image(Seq(Seq(1, 2), Seq(3, 4)))

    test( "No filters") {
        val f = new MultiFilter(Seq())
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 1)
        assert(fImg.getPixel(1, 0) == 2)
        assert(fImg.getPixel(0, 1) == 3)
        assert(fImg.getPixel(1, 1) == 4)
    }

    test("One filter") {
        val f = new MultiFilter(Seq(new FlipFilter(true, false)))
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 3)
        assert(fImg.getPixel(1, 0) == 4)
        assert(fImg.getPixel(0, 1) == 1)
        assert(fImg.getPixel(1, 1) == 2)
    }

    test("Two filters") {
        val f = new MultiFilter(Seq(new FlipFilter(true, false), new BrightnessFilter(2)))
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 5)
        assert(fImg.getPixel(1, 0) == 6)
        assert(fImg.getPixel(0, 1) == 3)
        assert(fImg.getPixel(1, 1) == 4)
    }
}
