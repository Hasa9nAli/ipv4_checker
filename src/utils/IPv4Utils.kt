package utils

import utils.ValidationMessages.ZERO

/**
* this function print the console message and read input text and return that input
* @param message -> the message who see to show in the console
* @return input who user entered it
* @author Hasan Ali
* */
fun readText(message: String): String{
    print(message)
    val input = readln()
    return input
}

/**
 * @param text -> text that will be split depend on don(.) notation
 * @author Hasan ALi
 * @return List of String, Example -> [[12, 23, 12, 90]]
 */
fun splitTextByDot(text: String): List<String> {
    val splitValue = text.split(".")
    return splitValue
}

fun isLengthTextEqualFour(text: Int) : Boolean = text == 4

fun isLengthEqualOne(text: String) = text.length == 1

fun isLessThanThree(text: String) = text.length <= 3

fun isInRange255(text: String) = (text.toInt() in (0..255))

fun isLengthMoreThanOneAndStartWithZero(text: String) = text.length > 1 && !text.startsWith(ZERO)

fun printWelcomeMessage(){
    println("************************************************************\n" +
            "************************************************************\n" +
            "*                                                          *\n" +
            "                   This Code Written By                    *\n" +
            "*                    Hasan ALi Hasan                       *\n" +
            "*                    Android Developer                     *\n" +
            "*                  gmail : ihasanalihasan@gmai.com         *\n" +
            "*                  LinkedIn: ihasanalihasan                *\n" +
            "*                  GitHub:   Hasa9nAli                     *\n" +
            "*                                                          *\n" +
            "************************************************************\n" +
            "************************************************************\n"


    )
}