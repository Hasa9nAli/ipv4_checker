package utils

fun List<String>.addAndUpdate(newItem: String): List<String>{
    val newList = this.toMutableList()
    newList.add(newItem)
    return newList.toList()
}

fun String.withGreenColor(): String = "\u001B[32m $this \u001B[0m"
fun String.withRedColor(): String = "\u001B[31m $this \u001B[0m"