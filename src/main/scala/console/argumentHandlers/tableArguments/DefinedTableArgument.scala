package console.argumentHandlers.tableArguments

import asciiTables.{AsciiTable, LinearTable, NonlinearTable}
import console.argumentHandlers.Argument
import exceptions.ArgumentException

class DefinedTableArgument(params: Seq[String]) extends Argument[AsciiTable]{
    override def handle(): AsciiTable = {
        if (params.length != 1)
            throw new ArgumentException("--table requires exactly 1 parameter")

        params.head match {
            case "default" => new LinearTable("@%#*+=-:. ")
            case "long" => new LinearTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
            case "pixelart" => new LinearTable("█▓▒░ ")
            case "spots" => new LinearTable("█▙▚▖ ")
            case "variedSpots" => new LinearTable("█▟▜▛▙▞▚▝▘▗▖ ")
            case "columns" => new LinearTable("█▇▆▅▄▃▂▁ ")
            case "binary" => new LinearTable("# ")
            case "nonlinear" => new NonlinearTable(Vector(('#', 0, 127), ('*', 128, 191), ('=', 192, 223), (':', 224, 239), (' ', 240, 255)))
            case other => throw new ArgumentException("Unknown table name \"" + other + "\" in parameter of --table")
        }
    }
}
