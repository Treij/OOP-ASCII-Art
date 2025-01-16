package pixelTypeConverters

import arrayImages.Image
import arrayImages.pixels.RgbPixel
import asciiTables.AsciiTable

import scala.collection.mutable.ArrayBuffer


/**
 * Ascii conversion
 * @param table
 */
class TableToAsciiConverter(table: AsciiTable) extends PixelTypeConverter[Int, Char] {

    override def convert(img: Image[Int]): Image[Char] = {

        val arr = new ArrayBuffer[Char]()
        for (y <- 0 until img.height) {
            for (x <- 0 until img.width) {
                val p: Int = img.getPixel(x, y)
                arr += table.getChar(p)
            }
        }

        new Image[Char](arr.grouped(img.width).map(x => x.toIndexedSeq).toIndexedSeq)

    }
}
