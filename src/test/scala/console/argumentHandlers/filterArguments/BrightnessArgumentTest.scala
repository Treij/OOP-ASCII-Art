package console.argumentHandlers.filterArguments

import filters.BrightnessFilter
import org.scalatest.FunSuite

class BrightnessArgumentTest extends FunSuite {
    test("Positive number parameter") {
        val args: Seq[String] = Seq("14")
        val a = (new BrightnessArgument(args)).handle()
        a match {
            case a: BrightnessFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Negative number parameter") {
        val args: Seq[String] = Seq("-14")
        val a = (new BrightnessArgument(args)).handle()
        a match {
            case a: BrightnessFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Not a number parameter") {
        val args: Seq[String] = Seq("Bruh")
        intercept[Exception] {
            new BrightnessArgument(args).handle()
        }

    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new BrightnessArgument(args).handle()
        }

    }


}
