package console.argumentHandlers.tableArguments

import asciiTables.{AsciiTable, LinearTable}
import org.scalatest.FunSuite

class DefinedTableArgumentTest extends FunSuite {
    test("Valid argument") {
        val args: Seq[String] = Seq("default")
        val a = (new DefinedTableArgument(args)).handle()
    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new DefinedTableArgument(args).handle()
        }
    }

    test("Invalid parameter") {
        val args: Seq[String] = Seq("invalid-parmeter :D")
        intercept[Exception] {
            new DefinedTableArgument(args).handle()
        }
    }


}
