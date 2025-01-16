package arrayImages

/**
 * @tparam T defines pixel type (e.g. int, RGB, char, ...)
 */
class Image[T](pixels: Seq[Seq[T]]) {

    val grid : Grid[T] = new Grid(pixels)
    val width: Int = grid.width
    val height: Int = grid.height

    /**
     * Returns a pixel on a given position
     */
    def getPixel(x: Int, y: Int) : T = grid.getCell(x, y)
}
