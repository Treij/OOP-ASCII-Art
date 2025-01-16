package arrayImages.pixels

import org.scalatest.FunSuite

class RgbPixelTest extends FunSuite {
    test("Valid values") {
        RgbPixel(0, 0, 0)
        RgbPixel(255, 255, 255)
        RgbPixel(125, 70, 42)
    }

    test("Invalid values - negative") {
        intercept[Exception] {
            RgbPixel(-1, 0, 0)
        }
        intercept[Exception] {
            RgbPixel(0, -1, 0)
        }
        intercept[Exception] {
            RgbPixel(0, 0, -1)
        }
        intercept[Exception] {
            RgbPixel(0, 0, -1000000)
        }
    }

    test("Invalid values - over 255") {
        intercept[Exception] {
            RgbPixel(256, 0, 0)
        }
        intercept[Exception] {
            RgbPixel(0, 256, 0)
        }
        intercept[Exception] {
            RgbPixel(0, 0, 256)
        }
        intercept[Exception] {
            RgbPixel(0, 0, 9999256)
        }
    }
}
