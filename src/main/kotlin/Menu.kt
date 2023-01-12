// принимает список элементов меню и выбранный архив в случае если выводит список заметок
class Menu<T : MenuItem>(private val listItems: List<T>, private val archive: Archive?) {

    // выводит меню (архивов или заметок) и возвращает выбранный пользователем пункт меню
    fun showMenu() {

        println(Texts.BR.text)

        when (archive) {
            // если список архивов
            null -> showMenuItems(
                Texts.ARCHIVE_LIST.text,
                Texts.ARCHIVE_CREATE.text,
                Texts.ARCHIVE_LIST_EMPTY.text,
                Texts.EXIT.text
            )
            // если выбран архив - список заметок
            else -> showMenuItems(
                Texts.NOTE_LIST.text + '"' + archive.getItemTitle() + '"',
                Texts.NOTE_CREATE.text,
                Texts.NOTE_LIST_EMPTY.text,
                Texts.ARCHIVE_EXIT.text
            )
        }

        println(Texts.BR.text)

    }

    // выводит пункты меню с заданными текстами
    private fun showMenuItems(title: String, create: String, empty: String, exit: String) {
        println(title)
        println("0. $create")
        if (listItems.isNotEmpty()) {
            listItems.forEachIndexed { index, t -> println("${index + 1}. ${t.getItemTitle()}") }
        } else {
            println(empty)
        }
        println("${listItems.size + 1}. " + exit)
    }

    // просит пользователя ввести номер пункта меню
    fun selectMenu(): Int {
        while (true) {
            val selectedNumber = UserInput().selectNumberMenu { showMenu() }
            if (selectedNumber >= 0 && selectedNumber <= listItems.size + 1) {
                return selectedNumber
            } else {
                println(Texts.MENU_WRONG_NUMBER.text)
                showMenu()
            }
        }
    }
}