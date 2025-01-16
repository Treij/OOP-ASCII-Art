package console.argumentHandlers.tableArguments

import asciiTables.{AsciiTable, LinearTable}
import console.argumentHandlers.Argument
import exceptions.ArgumentException

class CustomTableArgument(params: Seq[String]) extends Argument[AsciiTable]{
    override def handle(): AsciiTable = {
        if (params.length != 1)
            throw new ArgumentException("--custom-table requires exactly 1 parameter")

        new LinearTable(params.head)
    }
}
