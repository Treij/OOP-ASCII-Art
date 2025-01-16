package console.argumentHandlers.exportArguments

import exporters.text.TextFileExporter
import org.scalatest.FunSuite

class FileOutputArgumentTest extends FunSuite {
    test("Filename Parameter") {
        val args: Seq[String] = Seq("file.txt")
        val a = (new FileOutputArgument(args)).handle()
        a match {
            case _: TextFileExporter => assert(true)
            case _: Any => assert(false)
        }
    }

    test("No arument") {
        val args: Seq[String] = Seq()
        intercept[Exception] {
            new FileOutputArgument(args).handle()
        }

    }

    test("Two arguments") {
        val args: Seq[String] = Seq("file.txt", "files.txt")
        intercept[Exception] {
            new FileOutputArgument(args).handle()
        }

    }

}
