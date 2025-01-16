package imageGetters.generators
import arrayImages.Image
import arrayImages.pixels.RgbPixel

/**
 * General image generator from lambda expression
 * @param func function that returns an integer for x and y coordinate
 */
class FunctionGenerator(width: Int, height: Int, func: (Int, Int) => Int) extends ImageGenerator {
    override def getImage: Image[RgbPixel] = {
        val array =
            (0 until height).map(y => {
                (0 until width).map(x => {
                    val value = clamp(func(x, y))
                    RgbPixel(value, value, value)
                })
            })
        new Image(array)
    }

    def clamp(x: Int): Int = if (x < 0) 0 else if (x > 255) 255 else x
}
