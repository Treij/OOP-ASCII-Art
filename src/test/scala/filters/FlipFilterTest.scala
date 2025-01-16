package filters

import arrayImages.Image
import org.scalatest.FunSuite

class FlipFilterTest extends FunSuite {
    val img = new Image[Int](Seq(Seq(1, 2, 3), Seq(4, 5, 6)))

    test("FLip x") {
        val f = new FlipFilter(true, false)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 4)
        assert(fImg.getPixel(1, 0) == 5)
        assert(fImg.getPixel(2, 0) == 6)
        assert(fImg.getPixel(0, 1) == 1)
        assert(fImg.getPixel(1, 1) == 2)
        assert(fImg.getPixel(2, 1) == 3)
    }

    test("FLip y") {
        val f = new FlipFilter(false, true)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 3)
        assert(fImg.getPixel(1, 0) == 2)
        assert(fImg.getPixel(2, 0) == 1)
        assert(fImg.getPixel(0, 1) == 6)
        assert(fImg.getPixel(1, 1) == 5)
        assert(fImg.getPixel(2, 1) == 4)
    }

    test("FLip xy") {
        val f = new FlipFilter(true, true)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 6)
        assert(fImg.getPixel(1, 0) == 5)
        assert(fImg.getPixel(2, 0) == 4)
        assert(fImg.getPixel(0, 1) == 3)
        assert(fImg.getPixel(1, 1) == 2)
        assert(fImg.getPixel(2, 1) == 1)
    }

    test("Single pixel") {
        val fImg = (new FlipFilter(true, true)).apply(new Image(Seq(Seq(42))))
        assert(fImg.getPixel(0, 0) == 42)
    }

}
