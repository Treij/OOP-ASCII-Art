package console.argumentHandlers.filterArguments

import filters.InvertFilter
import org.scalatest.FunSuite

class InvertArgumentTest extends FunSuite {
    test("No parameter") {
        val args: Seq[String] = Seq()
        val a = (new InvertArgument(args)).handle()
        a match {
            case a: InvertFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Some parameter") {
        val args: Seq[String] = Seq("Bruh")
        intercept[Exception] {
            new InvertArgument(args).handle()
        }

    }


}
