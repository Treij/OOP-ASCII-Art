package console.argumentHandlers.exportArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import exporters.text.{TextExporter, TextFileExporter}

class FileOutputArgument(params: Seq[String]) extends Argument[TextExporter] {
    override def handle(): TextExporter = {
        if (params.length != 1)
            throw new ArgumentException("--output-file requires exactly 1 parameter")

        new TextFileExporter(params.head)
    }
}
