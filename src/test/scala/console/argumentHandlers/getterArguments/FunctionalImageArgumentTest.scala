package console.argumentHandlers.getterArguments

import imageGetters.generators.FunctionGenerator
import org.scalatest.FunSuite

class FunctionalImageArgumentTest extends FunSuite {
    test("Valid argument") {
        val args: Seq[String] = Seq("bubbles")
        val a = (new FunctionalImageArgument(args)).handle()
        a match {
            case a: FunctionGenerator => assert(true)
            case b: Any => assert(false)
        }
    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new FunctionalImageArgument(args).handle()
        }
    }

    test("Invalid parameter") {
        val args: Seq[String] = Seq("invalid-parmeter :D")
        intercept[Exception] {
            new FunctionalImageArgument(args).handle()
        }
    }

}
