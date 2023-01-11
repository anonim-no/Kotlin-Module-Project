import java.util.Scanner

class UserInput {

    private val scanner = Scanner(System.`in`)

    // Показывает что нужно ввести и возвращает ввод пользователя
    fun getText(title: String): String {
        println(title)
        while (true) {
            val consoleData = scanner.nextLine()
            if (consoleData.isNotEmpty()) return consoleData
        }
    }

    // Просит пользователя ввести пункт меню
    fun selectMenu(): Int {
        while (true) {
            println(Texts.MENU_SELECT.text)
            val number = scanner.nextLine()
            if (isInteger(number)) {
                return Integer.parseInt(number)
            } else {
                println(Texts.MENU_WRONG_INPUT.text)
            }
        }
    }

    fun exitNote() {
        while (true) {
            println(Texts.NOTE_ENTER_ANY_TEXT_FOR_EXIT.text)
            scanner.nextLine()
            break
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