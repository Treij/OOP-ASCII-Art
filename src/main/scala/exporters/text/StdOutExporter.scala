package exporters.text

/**
 * Exports text into console
 */
class StdOutExporter extends TextExporter {
    override def export(item: String): Unit = {
        print(item)
    }
}
