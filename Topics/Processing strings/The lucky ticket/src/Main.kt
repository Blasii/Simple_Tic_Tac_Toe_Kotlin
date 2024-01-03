fun main() {
    
    val ticketNumber = readln()

    // Check if the input is a six-digit number
    if (ticketNumber != null && ticketNumber.matches(Regex("\\d{6}"))) {
        // Extract the first three and last three digits
        val firstThreeDigits = ticketNumber.substring(0, 3)
        val lastThreeDigits = ticketNumber.substring(3)

        // Calculate the sum of digits in each group
        val sumFirstThree = firstThreeDigits.map { it.toString().toInt() }.sum()
        val sumLastThree = lastThreeDigits.map { it.toString().toInt() }.sum()

        // Check if the sums are equal
        val result = if (sumFirstThree == sumLastThree) "Lucky" else "Regular"

        // Output the result
        println(result)
    } else {
        // Invalid input if not a six-digit number
        println("Invalid input. Please enter a six-digit number.")
    }
}
