package console.argumentHandlers

import asciiTables.{AsciiTable, LinearTable}
import console.argumentHandlers.tableArguments._
import exceptions.ArgumentException

class TableArgumentsProcessor extends ArgumentsProcessor[AsciiTable] {
    def process(commands: Seq[Seq[String]]): AsciiTable = {
        var tables = Vector[AsciiTable]()
        for (cmd <- commands) {
            val argument = cmd.head match {
                case "--custom-table" => Some(new CustomTableArgument(cmd.tail))
                case "--table" => Some(new DefinedTableArgument(cmd.tail))

                case _ => None
            }

            argument match {
                case Some(a) => tables = tables.appended(a.handle())
                case None => ()
            }
        }

        tables.length match {
            case 0 => new LinearTable("@%#*+=-:. ")
            case 1 => tables.head
            case _ => throw new ArgumentException("You can define only one conversion table")
        }
    }

    override def getAcceptedCommands: Seq[String] = Seq("--custom-table", "--table")
}
