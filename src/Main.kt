//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    check(
        name = "when 192.1.2.3",
        result = isIPv4Valid("192.1.2.3"),
        correctResult = true,
    )

    check(
        name = "when 255.255.255.255",
        result = isIPv4Valid("255.255.255.255"),
        correctResult = true,
    )

    check(
        name = "when 192.168.1.2 ",
        result = isIPv4Valid(" 192.168.1.2 "),
        correctResult = true,
    )
    check(
        name = "when 0.0.1.2",
        result = isIPv4Valid("0.0.1.2"),
        correctResult = true,
    )
    check(
        name = "when -192.168.1.2",
        result = isIPv4Valid("-192.168.1.2"),
        correctResult = false,
    )
    check(
        name = "when 192.256.1.2",
        result = isIPv4Valid("192.256.1.2"),
        correctResult = false,
    )
    check(
        name = "when 192.06.19.12",
        result = isIPv4Valid("192.06.19.12"),
        correctResult = false,
    )
    check(
        name = "when hasn.06.19.12",
        result = isIPv4Valid("hasn.06.19.12"),
        correctResult = false,

        )
    check(
        name = "when 0.001.ha.hi",
        result = isIPv4Valid("0.001.ha.hi"),
        correctResult = false,
    )

    check(
        name = "when 0.val.190.0",
        result = isIPv4Valid("0.val.190.0"),
        correctResult = false,
    )
    check(
        name = "when 0",
        result = isIPv4Valid("0"),
        correctResult = false,
    )
    check(
        name = "when \"\"",
        result = isIPv4Valid(""),
        correctResult = false,
    )
    check(
        name = "when 189.12.12",
        result = isIPv4Valid("189.12.12"),
        correctResult = false,
    )
    check(
        name = "when 189.12..12",
        result = isIPv4Valid(".189.12..1223"),
        correctResult = false,
    )
    check(
        name = "when 189.12..12",
        result = isIPv4Valid(".189.12..1223"),
        correctResult = false,
    )


}

fun isIPv4Valid(value : String): Boolean{
    return false
}

fun check(name: String, result: Boolean, correctResult: Boolean){
    if(result == correctResult){
        println("Success -> $name")
    }
    else {
        println("Fail -> $name")

    }
}
