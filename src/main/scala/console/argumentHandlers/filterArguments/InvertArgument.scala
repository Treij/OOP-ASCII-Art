package console.argumentHandlers.filterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import filters.{Filter, InvertFilter}

class InvertArgument(params: Seq[String]) extends Argument[Filter]{
    override def handle(): Filter = {
        if (params.nonEmpty)
            throw new ArgumentException("--invert requires 0 parameters")

        new InvertFilter
    }
}
