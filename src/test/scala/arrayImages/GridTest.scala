package arrayImages

import org.scalatest.FunSuite

class GridTest extends FunSuite {

    test("Basic functionality") {
        val g = new Grid(List(List(1, 2), List(3, 4)))

        assert(g.getCell(0, 0) == 1)
        assert(g.getCell(1, 0) == 2)
        assert(g.getCell(0, 1) == 3)
        assert(g.getCell(1, 1) == 4)
        assert(g.width == 2)
        assert(g.height == 2)
    }

    test("Empty grid") {
        intercept[Exception] {
            new Grid(List())
        }
    }

    test("Empty grid 2") {
        intercept[Exception] {
            new Grid(List(List()))
        }
    }

    test("Invalid grid") {
        intercept[Exception] {
            new Grid(List(List(1, 2), List(3)))
        }
    }

    test("Out of bounds") {
        val g = new Grid(List(List(1, 2), List(3, 4)))
        intercept[IndexOutOfBoundsException] {
            g.getCell(-1, 0)
        }
        intercept[IndexOutOfBoundsException] {
            g.getCell(0, -1)
        }
        intercept[IndexOutOfBoundsException] {
            g.getCell(2, 0)
        }
        intercept[IndexOutOfBoundsException] {
            g.getCell(2, 0)
        }
        intercept[IndexOutOfBoundsException] {
            g.getCell(100, 100)
        }

    }


}
