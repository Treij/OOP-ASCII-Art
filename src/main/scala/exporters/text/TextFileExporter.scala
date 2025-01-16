package exporters.text

import java.io.{File, PrintWriter}

/**
 * Exports text into file
 */
class TextFileExporter(fileName: String) extends TextExporter {
    override def `export`(item: String): Unit = {
        val file: File = new File(fileName)
        val pw = new PrintWriter(file)
        pw.write(item)
        pw.close()
    }
}
