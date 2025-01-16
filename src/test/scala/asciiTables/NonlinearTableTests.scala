package asciiTables

import org.scalatest.FunSuite

class NonlinearTableTests extends FunSuite{
    test("Basic functionality") {
        val t = new NonlinearTable(Vector(('a', 0,100), ('b', 101,200), ('c', 201,250), ('d', 251,255)))
        assert(t.getChar(0) == 'a')
        assert(t.getChar(100) == 'a')
        assert(t.getChar(101) == 'b')
        assert(t.getChar(120) == 'b')
        assert(t.getChar(200) == 'b')
        assert(t.getChar(201) == 'c')
        assert(t.getChar(255) == 'd')
    }

    test("Out of bounds") {
        val t = new NonlinearTable(Vector(('a', 0,100), ('b', 101,200), ('c', 201,250), ('d', 251,255)))
        intercept[Exception]{ t.getChar(-1)}
        intercept[Exception]{ t.getChar(256)}
        intercept[Exception]{ t.getChar(-1560000)}
        intercept[Exception]{ t.getChar(888888888)}
    }

    test("Doesn't start from zero") {
        intercept[Exception]{
            new NonlinearTable(Vector(('a', 1,100), ('b', 101,200), ('c', 201,255)))
        }
    }

    test("Isn't continuous") {
        intercept[Exception] {
            new NonlinearTable(Vector(('a', 0, 100), ('b', 150, 200), ('c', 201, 255)))
        }
    }

    test("Is overlapping") {
        intercept[Exception] {
            new NonlinearTable(Vector(('a', 0, 100), ('b', 101, 200), ('c', 150, 255)))
        }
    }

    test("Doesn't end at 255") {
        intercept[Exception] {
            new NonlinearTable(Vector(('a', 0, 100), ('b', 101, 200), ('c', 201, 202)))
        }
    }

    test("Only one character") {
        new NonlinearTable(Vector(('a', 0, 255)))
    }

}
