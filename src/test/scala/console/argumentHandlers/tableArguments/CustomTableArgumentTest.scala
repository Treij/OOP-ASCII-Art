package console.argumentHandlers.tableArguments

import asciiTables.AsciiTable
import org.scalatest.FunSuite

class CustomTableArgumentTest extends FunSuite {
    test("Valid argument") {
        val args: Seq[String] = Seq(" .*x#")
        val a = (new CustomTableArgument(args)).handle()
    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new CustomTableArgument(args).handle()
        }
    }

    test("Invalid parameter") {
        val args: Seq[String] = Seq("")
        intercept[Exception] {
            new CustomTableArgument(args).handle()
        }
    }

}
