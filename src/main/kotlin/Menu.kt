
// принимает список элементов и выбранный архив в случае если выводит список заметок
class Menu<T : MenuItem>(private val listItems: List<T>, private val archive: Archive?) {

    // выводит меню (архивов или заметок) и возвращает выбранный пользователем пункт меню
    fun showMenu() {

        println(Texts.BR.text)

        when (archive) {
            null -> {
                println(Texts.ARCHIVE_LIST.text)
                println("0. " + Texts.ARCHIVE_CREATE.text)
                if (listItems.isNotEmpty()) {
                    listItems.forEachIndexed { index, t -> println("${index + 1}. ${t.getItemTitle()}") }
                } else {
                    println(Texts.ARCHIVE_LIST_EMPTY.text)
                }
                println("${listItems.size + 1}. " + Texts.EXIT.text)
            }
            else -> {
                println(Texts.NOTE_LIST.text + '"' + archive.getItemTitle() + '"')
                println("0. " + Texts.NOTE_CREATE.text)
                if (listItems.isNotEmpty()) {
                    listItems.forEachIndexed { index, t -> println("${index + 1}. ${t.getItemTitle()}") }
                } else {
                    println(Texts.NOTE_LIST_EMPTY.text)
                }
                println("${listItems.size + 1}. " + Texts.ARCHIVE_EXIT.text)
            }
        }

        println(Texts.BR.text)

    }

    // просит пользователя ввести номер пункта меню
    fun selectMenu(): Int {
        while (true) {
            val selectedNumber = UserInput().selectMenu()
            if (selectedNumber >= 0 && selectedNumber <= listItems.size + 1) {
                return selectedNumber
            } else {
                println(Texts.MENU_WRONG_NUMBER.text)
                println(Texts.BR.text)
            }
        }
    }
}

