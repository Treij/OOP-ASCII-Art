package console.argumentHandlers.exportArguments

import exporters.text.StdOutExporter
import org.scalatest.FunSuite

class ConsoleOutputArgumentTest extends FunSuite {
    test("No parameters") {
        val args: Seq[String] = Seq()
        val a = (new ConsoleOutputArgument(args)).handle()
        a match {
            case _: StdOutExporter => assert(true)
            case _: Any => assert(false)
        }
    }

    test("Any arument") {
        val args: Seq[String] = Seq("Bruh")
        intercept[Exception] {
            new ConsoleOutputArgument(args).handle()
        }

    }

}
