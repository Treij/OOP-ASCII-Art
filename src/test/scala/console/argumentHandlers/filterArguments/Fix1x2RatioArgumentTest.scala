package console.argumentHandlers.filterArguments

import filters.FontRatio1x2Filter
import org.scalatest.FunSuite

class Fix1x2RatioArgumentTest extends FunSuite {
    test("No parameter") {
        val args: Seq[String] = Seq()
        val a = (new Fix1x2RatioArgument(args)).handle()
        a match {
            case a: FontRatio1x2Filter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Some parameter") {
        val args: Seq[String] = Seq("Bruh")
        intercept[Exception] {
            new Fix1x2RatioArgument(args).handle()
        }

    }

}
