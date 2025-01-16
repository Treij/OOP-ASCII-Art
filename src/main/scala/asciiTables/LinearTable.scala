package asciiTables

class LinearTable(characters: Seq[Char]) extends AsciiTable {
    require(characters.nonEmpty)

    override def getChar(value: Int): Char = {
        require(value >= 0 && value < 256)

        characters((value * (characters.length-1) / 255f).round)
    }
}
