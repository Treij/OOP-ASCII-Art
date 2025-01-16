package console.argumentHandlers.filterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import filters.{BrightnessFilter, Filter}

class BrightnessArgument(params: Seq[String]) extends Argument[Filter]{
    override def handle(): Filter = {
        if (params.isEmpty)
            throw new ArgumentException("--brightness requires at least 1 parameter")

        var sum = 0
        try {
            sum = params.map(x => x.toInt).sum
        } catch {
            case _: NumberFormatException => throw new ArgumentException("Invalid parameter for --brightness")
        }

        new BrightnessFilter(sum)
    }
}
