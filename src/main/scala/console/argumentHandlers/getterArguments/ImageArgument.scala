package console.argumentHandlers.getterArguments

import console.argumentHandlers.Argument
import exceptions.ArgumentException
import imageGetters.ImageGetter
import imageGetters.fileGetters.JavaIoImageGetter

class ImageArgument(params: Seq[String]) extends Argument[ImageGetter] {
    override def handle(): ImageGetter = {
        if (params.length != 1)
            throw new ArgumentException("--image requires exactly 1 parameter")

        new JavaIoImageGetter(params.head)

    }
}
