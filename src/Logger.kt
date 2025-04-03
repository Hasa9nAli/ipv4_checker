
object Logger : LoggerOperations {
    override fun log(message: String) {
        println(message)
    }
}
interface LoggerOperations{
    fun log(message: String)
}