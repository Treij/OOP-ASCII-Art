package pixelTypeConverters

import arrayImages.Image
import asciiTables._
import org.scalatest.FunSuite

class TableToAsciiConverterTest extends FunSuite {

    val pixels: Seq[Seq[Int]] = Seq(0, 100, 200, 255).grouped(2).toSeq
    val greyImg: Image[Int] = new Image(pixels)

    test("Converting simple") {
        val convertor = new TableToAsciiConverter(new LinearTable("a"))
        val art = convertor.convert(greyImg)
        assert(art.getPixel(0, 0) == 'a')
        assert(art.getPixel(1, 0) == 'a')
        assert(art.getPixel(0, 1) == 'a')
        assert(art.getPixel(1, 1) == 'a')
    }
    test("Converting nonlinear") {
        val convertor = new TableToAsciiConverter(new NonlinearTable(Seq(('a', 0, 100), ('b', 101, 200), ('c', 201, 255))))
        val art = convertor.convert(greyImg)
        assert(art.getPixel(0, 0) == 'a')
        assert(art.getPixel(1, 0) == 'a')
        assert(art.getPixel(0, 1) == 'b')
        assert(art.getPixel(1, 1) == 'c')
    }
}
