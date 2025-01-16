package console

import arrayImages.Image
import arrayImages.pixels.RgbPixel
import asciiTables.AsciiTable
import console.pages.textPages.{AsciiArtTextPage, HelpPage}
import console.argumentHandlers._
import exceptions.ArgumentException
import exporters.text.{StdOutExporter, TextExporter}
import filters.Filter
import imageGetters.ImageGetter
import pixelTypeConverters.{DefaultToGreyscaleConverter, TableToAsciiConverter}

import scala.collection.mutable.ArrayBuffer

/**
 * Class that handles the whole app through console UI
 * @param args
 */
class ConsoleUI(args: Seq[String]) {

    if (args.nonEmpty && args.head == "--help")
        (new StdOutExporter).`export`((new HelpPage).render())
    else
        makeAsciiArt()

    /**
     * Processes the args and handles them accordingly
     */
    def makeAsciiArt(): Unit = {
        try {
            val processedArgs: Seq[Seq[String]] = processArgs()
            // println(processedArgs.mkString("Args(\n\t", ",\n\t", "\n)"))

            checkAllArgumentsAccepted(processedArgs)

            val getter: ImageGetter = (new GetterArgumentsProcessor).process(processedArgs)
            val filter: Filter = (new FilterArgumentsProcessor).process(processedArgs)
            val table: AsciiTable = (new TableArgumentsProcessor).process(processedArgs)
            val exporter: TextExporter = (new ExportArgumentsProcessor).process(processedArgs)

            val rgbImg: Image[RgbPixel] = getter.getImage
            val greyImg: Image[Int] = new DefaultToGreyscaleConverter().convert(rgbImg)
            val filteredImg: Image[Int] = filter.apply(greyImg)
            val asciiImg: Image[Char] = new TableToAsciiConverter(table).convert(filteredImg)
            val asciiPage: String = new AsciiArtTextPage(asciiImg).render()
            exporter.`export`(asciiPage)
        } catch {
            case e: ArgumentException => println("Error: " + e.getMessage)
        }


    }

    /**
     * Splits args by individual arguments (starting with --) and their parameters
     * @return
     */
    def processArgs(): IndexedSeq[IndexedSeq[String]] = {
        val tmp = ArrayBuffer[ArrayBuffer[String]]()
        if (args.isEmpty || !args.head.startsWith("--"))
            throw new ArgumentException("Parameters error, try --help")

        var currentArgument = ArrayBuffer[String]()
        for (arg <- args) {
            if (arg.startsWith("--")) {
                tmp += currentArgument
                currentArgument = ArrayBuffer(arg)
            } else {
                currentArgument += arg
            }
        }
        tmp += currentArgument

        tmp.tail.map(x => x.toIndexedSeq).toIndexedSeq
    }

    /**
     * Checks if all arguments are known to the app
     */
    def checkAllArgumentsAccepted(arguments: Seq[Seq[String]]): Unit = {
        val unaccepted = arguments.filter(a => !(new GetterArgumentsProcessor).getAcceptedCommands.contains(a.head))
            .filter(a => !(new FilterArgumentsProcessor).getAcceptedCommands.contains(a.head))
            .filter(a => !(new TableArgumentsProcessor).getAcceptedCommands.contains(a.head))
            .filter(a => !(new ExportArgumentsProcessor).getAcceptedCommands.contains(a.head))

        if (unaccepted.nonEmpty) {
            throw new ArgumentException("Unknown argument \"" + unaccepted.head.head + "\"")
        }
    }
}
