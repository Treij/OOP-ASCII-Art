package console.argumentHandlers

import console.argumentHandlers.filterArguments._
import filters._

class FilterArgumentsProcessor extends ArgumentsProcessor[Filter] {
    def process(commands: Seq[Seq[String]]): Filter = {
        var filters = Vector[Filter]()
        for (cmd <- commands) {
            val argument = cmd.head match {
                case "--invert" => Some(new InvertArgument(cmd.tail))
                case "--brightness" => Some(new BrightnessArgument(cmd.tail))
                case "--flip" => Some(new FlipArgument(cmd.tail))
                case "--1x2ratioFix" => Some(new Fix1x2RatioArgument(cmd.tail))

                case _ => None
            }
            argument match {
                case Some(a) => filters = filters.appended(a.handle())
                case None => ()
            }
        }

        filters.length match {
            case 0 => new IdentityFilter
            case 1 => filters.head
            case _ => new MultiFilter(filters)
        }

    }

    override def getAcceptedCommands: Seq[String] = Seq("--invert", "--brightness", "--flip", "--1x2ratioFix")
}
