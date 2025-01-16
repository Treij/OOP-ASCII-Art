package console.argumentHandlers.filterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import filters.{Filter, FlipFilter}

class FlipArgument(params: Seq[String]) extends Argument[Filter]{
    override def handle(): Filter = {
        if (params.length != 1)
            throw new ArgumentException("--flip requires exactly 1 parameter")

        params.head match {
            case "x" => new FlipFilter(true, false)
            case "y" => new FlipFilter(false, true)
            case "xy" | "yx" => new FlipFilter(true, true)
            case _ => throw new ArgumentException("Invalid parameter for --flip")
        }
    }
}
