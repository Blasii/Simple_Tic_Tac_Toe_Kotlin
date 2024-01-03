import java.util.*

fun main() {
    val input = readlnOrNull()

    if (isPalindrome(input)) {
        println("yes")
    } else {
        println("no")
    }
}

fun isPalindrome(str: String?): Boolean {
    // Check if the string is null or empty
    if (str.isNullOrEmpty()) {
        return false
    }

    // Remove spaces and convert to lowercase for case-insensitive comparison
    val cleanStr = str.replace("\\s".toRegex(), "").lowercase(Locale.getDefault())

    // Check if the cleaned string is equal to its reverse
    return cleanStr == cleanStr.reversed()
}
