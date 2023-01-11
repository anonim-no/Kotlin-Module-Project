import java.util.Scanner

class UserInput {

    val scanner = Scanner(System.`in`)

    // Показываем что нужно ввести и возвращаем ввод пользователя
    fun getText(title: String): String {
        println("---")
        println("${title}:")
        while (true) {
            val consoleData = scanner.nextLine()
            if (consoleData.isNotEmpty()) return consoleData
        }
    }

    // Просим пользователя ввести пункт меню
    fun selectMenu(): Int {
        while(true) {
            println("Введите номер пункта меню:")
            val number = scanner.nextLine()
            if (isInteger(number)) {
                return Integer.parseInt(number);
            } else {
                println("Ошибка ввода, необходимо ввести число");
            }
        }
    }

    // проверка что строка число :)
    private fun isInteger(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}