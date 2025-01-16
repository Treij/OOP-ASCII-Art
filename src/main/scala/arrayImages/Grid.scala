package arrayImages

/**
 * A representation of a grid, doesnt support empty grid
 * @param cells 2D collection of values, every row needs to be equal in length
 * @tparam T type of value to be stored
 */
class Grid[T](cells: Seq[Seq[T]]) {

    require(cells.nonEmpty)
    require(cells.head.nonEmpty)
    require(cells.tail.forall(row => row.length == cells.head.length))

    val width: Int = cells.head.length
    val height: Int = cells.length


    val indexedCells: IndexedSeq[T] = cells.flatten.toIndexedSeq

    /**
     * Returns value on a given position
     */
    def getCell(x: Int, y: Int) : T = {
        if (isOutOfBounds(x, y)) throw new IndexOutOfBoundsException(s"Tried to access $x, $y, but max is $width, $height")

        indexedCells(get1DPos(x, y))
    }

    private def isOutOfBounds(x: Int, y: Int) : Boolean = x >= width || y >= height || x < 0 || y < 0

    private def get1DPos(x: Int, y: Int) : Int = y * width + x
}
