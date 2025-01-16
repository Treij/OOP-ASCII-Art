package filters

import arrayImages.Image
import org.scalatest.FunSuite

class BrightnessFilterTest extends FunSuite {
    val img = new Image(Seq(Seq(100, 101), Seq(102, 103)))

    test("Brightening") {
        val f = new BrightnessFilter(20)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 120)
        assert(fImg.getPixel(1, 0) == 121)
        assert(fImg.getPixel(0, 1) == 122)
        assert(fImg.getPixel(1, 1) == 123)
    }

    test("Darkening") {
        val f = new BrightnessFilter(-20)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 80)
        assert(fImg.getPixel(1, 0) == 81)
        assert(fImg.getPixel(0, 1) == 82)
        assert(fImg.getPixel(1, 1) == 83)
    }

    test("Frying") {
        val f = new BrightnessFilter(1000)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 255)
        assert(fImg.getPixel(1, 0) == 255)
        assert(fImg.getPixel(0, 1) == 255)
        assert(fImg.getPixel(1, 1) == 255)
    }

    test("Burning") {
        val f = new BrightnessFilter(-1000)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 0)
        assert(fImg.getPixel(1, 0) == 0)
        assert(fImg.getPixel(0, 1) == 0)
        assert(fImg.getPixel(1, 1) == 0)
    }

    test("Nothing") {
        val f = new BrightnessFilter(0)
        val fImg = f.apply(img)
        assert(fImg.getPixel(0, 0) == 100)
        assert(fImg.getPixel(1, 0) == 101)
        assert(fImg.getPixel(0, 1) == 102)
        assert(fImg.getPixel(1, 1) == 103)
    }

}
