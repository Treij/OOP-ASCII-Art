package console.argumentHandlers

import console.argumentHandlers.exportArguments.{ConsoleOutputArgument, FileOutputArgument}
import exporters.text._

class ExportArgumentsProcessor extends ArgumentsProcessor[TextExporter] {
    def process(commands: Seq[Seq[String]]): TextExporter = {
        var exporters = Vector[TextExporter]()
        for (cmd <- commands) {
            val argument = cmd.head match {
                case "--output-console" => Some(new ConsoleOutputArgument(cmd.tail))
                case "--output-file" => Some(new FileOutputArgument(cmd.tail))

                case _ => None
            }

            argument match {
                case Some(a) => exporters = exporters.appended(a.handle())
                case None => ()
            }
        }

        if (exporters.isEmpty)
            new StdOutExporter
        else
            new MultiTextExporter(exporters)
    }

    override def getAcceptedCommands: Seq[String] = Seq("--output-console", "--output-file")
}
