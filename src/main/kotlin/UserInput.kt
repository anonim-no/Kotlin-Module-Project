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
    fun selectNumberMenu(countItems: Int): Int {
        println(Texts.BR)
        println(Texts.MENU_SELECT)
        val inputData = scanner.nextLine()
        if (isInteger(inputData)) {
            val index = Integer.parseInt(inputData)
            if (index in 0..countItems) {
                return index
            } else throw Exception(Texts.MENU_WRONG_NUMBER)
        } else throw Exception(Texts.MENU_WRONG_INPUT)
    }

    // просит пользователя нажать Enter для выхода из заметки
    fun exitNote() {
        while (true) {
            println(Texts.NOTE_ENTER_ANY_TEXT_FOR_EXIT)
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