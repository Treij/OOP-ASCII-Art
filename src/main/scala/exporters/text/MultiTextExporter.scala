package exporters.text

/**
 * Exports into multiple locations
 * @param exporters
 */
class MultiTextExporter(exporters: Seq[TextExporter]) extends TextExporter {
    override def `export`(item: String): Unit = {
        exporters.foreach(e => e.`export`(item))
    }
}
