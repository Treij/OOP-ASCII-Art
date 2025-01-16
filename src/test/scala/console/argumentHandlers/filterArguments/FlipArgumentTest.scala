package console.argumentHandlers.filterArguments

import filters.FlipFilter
import org.scalatest.FunSuite

class FlipArgumentTest extends FunSuite {
    test("Parameter x") {
        val args: Seq[String] = Seq("x")
        val a = (new FlipArgument(args)).handle()
        a match {
            case a: FlipFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Parameter y") {
        val args: Seq[String] = Seq("y")
        val a = (new FlipArgument(args)).handle()
        a match {
            case a: FlipFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Parameter xy") {
        val args: Seq[String] = Seq("xy")
        val a = (new FlipArgument(args)).handle()
        a match {
            case a: FlipFilter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("Bad parameter") {
        val args: Seq[String] = Seq("Bruh")
        intercept[Exception] {
            new FlipArgument(args).handle()
        }

    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new FlipArgument(args).handle()
        }

    }
}
