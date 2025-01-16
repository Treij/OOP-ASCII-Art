package console.argumentHandlers.filterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import filters.{Filter, FontRatio1x2Filter}

class Fix1x2RatioArgument(params: Seq[String]) extends Argument[Filter]{
    override def handle(): Filter = {
        if (params.nonEmpty)
            throw new ArgumentException("--1x2ratioFix requires exactly 0 parameters")

        new FontRatio1x2Filter
    }
}
