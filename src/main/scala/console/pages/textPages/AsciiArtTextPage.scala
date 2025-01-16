package console.pages.textPages

import arrayImages.Image
import console.pages.TextPage

class AsciiArtTextPage(img: Image[Char]) extends TextPage {
    override def render(): String = {
        var result = ""

        for (y <- 0 until img.height) {
            for (x <- 0 until img.width) {
                result += img.getPixel(x, y)
            }
            result += "\n"
        }

        result
    }
}
