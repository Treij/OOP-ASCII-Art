package console.argumentHandlers

import console.argumentHandlers.getterArguments._
import exceptions.ArgumentException
import imageGetters.ImageGetter

class GetterArgumentsProcessor extends ArgumentsProcessor[ImageGetter] {
    def process(commands: Seq[Seq[String]]): ImageGetter = {
        var getters = Vector[ImageGetter]()
        for (cmd <- commands) {
            val argument = cmd.head match {
                case "--image" => Some(new ImageArgument(cmd.tail))
                case "--image-fun" => Some(new FunctionalImageArgument(cmd.tail))

                case _ => None
            }

            argument match {
                case Some(a) => getters = getters.appended(a.handle())
                case None => ()
            }
        }

        if (getters.length != 1)
            throw new ArgumentException("You must define exactly one input image")

        getters.head
    }

    override def getAcceptedCommands: Seq[String] = Seq("--image", "--image-fun")
}
