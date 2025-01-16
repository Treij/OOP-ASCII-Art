package pixelTypeConverters

import arrayImages.Image
import arrayImages.pixels.RgbPixel
import org.scalatest.FunSuite

class DefaultToGreyscaleConverterTest extends FunSuite {
    test("Converting") {
        val pixels = Seq(RgbPixel(0, 0, 0), RgbPixel(255, 255, 255), RgbPixel(255, 0, 0), RgbPixel(0, 0, 0)).grouped(2).toSeq
        val rgbImg = new Image(pixels)
        val greyImg = (new DefaultToGreyscaleConverter).convert(rgbImg)
        assert(greyImg.getPixel(0, 0) == 0)
        assert(greyImg.getPixel(1, 0) == 255)
        assert(greyImg.getPixel(0, 1) == 77)
        assert(greyImg.getPixel(1, 1) == 0)
    }
}
