import java.util.*

fun generatePassword(A: Int, B: Int, C: Int, N: Int): String {
    val upperCase = ('A'..'Z').toList()
    val lowerCase = ('a'..'z').toList()
    val digits = ('0'..'9').toList()
    val allChars = upperCase + lowerCase + digits

    fun isConsecutiveRepetition(password: String): Boolean {
        return password.windowed(2).any { it[0] == it[1] }
    }

    val random = Random()
    var password = ""

    // Generate uppercase letters
    repeat(A) {
        val randomIndex = random.nextInt(upperCase.size)
        password += upperCase[randomIndex]
    }

    // Generate lowercase letters
    repeat(B) {
        val randomIndex = random.nextInt(lowerCase.size)
        password += lowerCase[randomIndex]
    }

    // Generate digits
    repeat(C) {
        val randomIndex = random.nextInt(digits.size)
        password += digits[randomIndex]
    }

    // Generate the remaining characters
    repeat(N - A - B - C) {
        val randomIndex = random.nextInt(allChars.size)
        password += allChars[randomIndex]
    }

    // Shuffle the password until there are no consecutive repetitions
    while (isConsecutiveRepetition(password)) {
        password = password.toList().shuffled().joinToString("")
    }

    return password
}

fun main() {
    val scanner = Scanner(System.`in`)


    val A = scanner.nextInt()
    val B = scanner.nextInt()
    val C = scanner.nextInt()
    val N = scanner.nextInt()

    val password = generatePassword(A, B, C, N)
    println(password)
}
