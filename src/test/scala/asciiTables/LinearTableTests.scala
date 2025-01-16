package asciiTables

import org.scalatest.FunSuite

class LinearTableTests extends FunSuite{
    test("Basic functionality") {
        val t = new LinearTable("abcd")
        assert(t.getChar(0) == 'a')
        assert(t.getChar(255) == 'd')
        assert(t.getChar(120) == 'b')
        assert(t.getChar(130) == 'c')
    }

    test("Out of bounds") {
        val t = new LinearTable("abcd")
        intercept[Exception]{ t.getChar(-1)}
        intercept[Exception]{ t.getChar(256)}
        intercept[Exception]{ t.getChar(-1560000)}
        intercept[Exception]{ t.getChar(888888888)}
    }

}
