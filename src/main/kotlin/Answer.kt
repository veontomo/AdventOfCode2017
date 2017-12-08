import java.io.File

interface Answer {
    fun showAnswer(): String
    fun readLines(fileName: String): List<String> {
        val file = File(javaClass.classLoader.getResource(fileName).file)
        return file.readLines(Charsets.UTF_8)
    }
}