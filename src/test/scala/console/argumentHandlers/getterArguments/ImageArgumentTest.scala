package console.argumentHandlers.getterArguments

import imageGetters.fileGetters.FileImageGetter
import org.scalatest.FunSuite

class ImageArgumentTest extends FunSuite {
    test("Valid argument") {
        val args: Seq[String] = Seq("tmp.jpg")
        val a = (new ImageArgument(args)).handle()
        a match {
            case a: FileImageGetter => assert(true)
            case b: Any => assert(false)
        }
    }

    test("No parameter") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new ImageArgument(args).handle()
        }
    }

    test("Invalid parameter") {
        val args: Seq[String] = Seq("invalid-parmeter :D")
        intercept[Exception] {
            new ImageArgument(args).handle()
        }
    }


}
