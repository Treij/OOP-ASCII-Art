package asciiTables

/**
 * Representation of a 0-255 to ascii convertor
 */
trait AsciiTable {
    /**
     * @return Character representing given value
     */
    def getChar(value: Int) : Char
}
