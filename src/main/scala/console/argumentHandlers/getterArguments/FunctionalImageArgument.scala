package console.argumentHandlers.getterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import imageGetters.ImageGetter
import imageGetters.generators.function._

class FunctionalImageArgument(params: Seq[String]) extends Argument[ImageGetter] {
    override def handle(): ImageGetter = {
        if (params.length != 1)
            throw new ArgumentException("--image-fun requires exactly 1 parameter")

        params.head match {
            case "bubbles" => new BubblesFunctionGenerator
            case "grid" => new GridFunctionGenerator
            case "waves" => new WavesFunctionGenerator
            case "gradient" => new GradientFunctionGenerator
            case "cvut" => new CvutFunctionGenerator
            case "crazy" => new CrazyFunctionGenerator
            case "sincos" => new SinCosFunctionGenerator
            case "random" => new RandomFunctionGenerator

            case other => throw new ArgumentException("Unknown function name \"" + other + "\" in parameter of --image-fun")
        }
    }

}
