package console.argumentHandlers.exportArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import exporters.text.{StdOutExporter, TextExporter}

class ConsoleOutputArgument(params: Seq[String]) extends Argument[TextExporter] {
    override def handle(): TextExporter = {
        if (params.nonEmpty)
            throw new ArgumentException("--output-console requires exactly 0 parameters")

        new StdOutExporter
    }
}
