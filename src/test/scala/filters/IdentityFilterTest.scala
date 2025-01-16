package filters

import arrayImages.Image
import org.scalatest.FunSuite

class IdentityFilterTest extends FunSuite {
    test("Identity") {
        val img = new Image[Int](Seq(Seq(1, 2, 3), Seq(4, 5, 6)))
        val fImg = (new IdentityFilter).apply(img)
        for (y <- 0 until img.height)
            for (x <- 0 until img.width)
                assert(fImg.getPixel(x, y) == img.getPixel(x, y))
    }
}
