import utils.withGreenColor
import utils.withRedColor

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val ipv4Checker = IPv4Checker(logger = Logger)

    check(
        name = "when 192.1.2.3",
        result = ipv4Checker.isAddressValid("192.1.2.3"),
        correctResult = true,
    )

    check(
        name = "when 255.255.255.255",
        result = ipv4Checker.isAddressValid("255.255.255.255"),
        correctResult = true,
    )

    check(
        name = "when 192.168.1.2 ",
        result = ipv4Checker.isAddressValid(" 192.168.1.2 "),
        correctResult = true,
    )
    check(
        name = "when 0.0.1.2",
        result = ipv4Checker.isAddressValid("0.0.1.2"),
        correctResult = true,
    )
    check(
        name = "when -192.168.1.2",
        result = ipv4Checker.isAddressValid("-192.168.1.2"),
        correctResult = false,
    )
    check(
        name = "when 192.256.1.2",
        result = ipv4Checker.isAddressValid("192.256.1.2"),
        correctResult = false,
    )
    check(
        name = "when 192.06.19.12",
        result = ipv4Checker.isAddressValid("192.06.19.12"),
        correctResult = false,
    )
    check(
        name = "when hasn.06.19.12",
        result = ipv4Checker.isAddressValid("hasn.06.19.12"),
        correctResult = false,

        )
    check(
        name = "when 0.001.ha.hi",
        result = ipv4Checker.isAddressValid("0.001.ha.hi"),
        correctResult = false,
    )

    check(
        name = "when 0.val.190.0",
        result = ipv4Checker.isAddressValid("0.val.190.0"),
        correctResult = false,
    )
    check(
        name = "when 0",
        result = ipv4Checker.isAddressValid("0"),
        correctResult = false,
    )
    check(
        name = "when \"\"",
        result = ipv4Checker.isAddressValid(""),
        correctResult = false,
    )
    check(
        name = "when 189.12.12",
        result = ipv4Checker.isAddressValid("189.12.12"),
        correctResult = false,
    )
    check(
        name = "when 189.12..12",
        result = ipv4Checker.isAddressValid(".189.12..1223"),
        correctResult = false,
    )
    check(
        name = "when 189.12..12",
        result = ipv4Checker.isAddressValid(".189.12..1223"),
        correctResult = false,
    )


}

fun check(name: String, result: Boolean, correctResult: Boolean){
    if(result == correctResult){
        println("Success -> $name".withGreenColor())
    }
    else {
        println("Fail -> $name".withRedColor())

    }
}
