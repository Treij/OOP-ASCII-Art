package arrayImages

import org.scalatest.FunSuite

class ImageTest extends FunSuite {
    test("Basic functionality") {
        val g = new Image(List(List(1, 2), List(3, 4)))

        assert(g.getPixel(0, 0) == 1)
        assert(g.getPixel(1, 0) == 2)
        assert(g.getPixel(0, 1) == 3)
        assert(g.getPixel(1, 1) == 4)
        assert(g.width == 2)
        assert(g.height == 2)
    }

    test("Empty image") {
        intercept[Exception] {
            new Image(List())
        }
    }

    test("Empty image 2") {
        intercept[Exception] {
            new Image(List(List()))
        }
    }

    test("Invalid image") {
        intercept[Exception] {
            new Image(List(List(1, 2), List(3)))
        }
    }

    test("Out of bounds") {
        val img = new Image(List(List(1, 2), List(3, 4)))
        intercept[IndexOutOfBoundsException] {
            img.getPixel(-1, 0)
        }
        intercept[IndexOutOfBoundsException] {
            img.getPixel(0, -1)
        }
        intercept[IndexOutOfBoundsException] {
            img.getPixel(2, 0)
        }
        intercept[IndexOutOfBoundsException] {
            img.getPixel(2, 0)
        }
        intercept[IndexOutOfBoundsException] {
            img.getPixel(100, 100)
        }

    }


}
