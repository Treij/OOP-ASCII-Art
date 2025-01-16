package asciiTables

/**
 *
 * @param table is a sequence of tuples. First value is Character, remaining values are from and to
 */
class NonlinearTable(table: Seq[(Char, Int, Int)]) extends AsciiTable {
    require(table.nonEmpty)
    require(table.head._2 == 0 && table.last._3 == 255)
    if (table.length >= 2)
        require(table.sliding(2).forall(window => window.head._3 + 1 == window.last._2))

    override def getChar(value: Int): Char = {
        table.filter(range => range._2 <= value && range._3 >= value).head._1
    }
}
