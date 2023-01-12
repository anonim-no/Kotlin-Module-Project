class Work {

    val menuList = mutableListOf<Menu>()

    fun start() {

        // создаем меню
        createMenu()

        // основное тело
        while (true) {
            // вывод начального меню на экран
            showMenuItems(Texts.ARCHIVE_LIST, Texts.EXIT, menuList)
            try {
                // просим пользователя выбрать пункт меню
                val indexMenu = UserInput().selectNumberMenu(menuList.size)

                // выход из программы
                if (indexMenu == menuList.size) {
                    println(Texts.BYE)
                    break
                }

                // вызываем обработчик для пункта меню архивов
                menuList[indexMenu].handler()

            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun createMenu() {
        // создаем меню архивов
        menuList.add(Menu(Texts.ARCHIVE_CREATE) {

            // создание архива
            val archiveName = UserInput().getText(Texts.ARCHIVE_ENTER_TITLE)
            val archiveScreen = Archive(archiveName)

            // создаем меню заметок
            val archiveScreenItems = Menu(Texts.NOTE_CREATE) {

                // создание заметки
                val userInput = UserInput()
                val noteTitle = userInput.getText(Texts.NOTE_ENTER_TITLE)
                val noteText = userInput.getText(Texts.NOTE_ENTER_TEXT)
                val note = Note(noteTitle, noteText)
                println(Texts.NOTE_CREATED)

                // просмтор заметки
                note.handler = {
                    println(Texts.BR)
                    println(Texts.NOTE + " \"${note.title}\":")
                    println(note.text)
                    println(Texts.BR)
                    UserInput().exitNote()
                    archiveScreen.handler()
                }

                // добавляем заметку в меню
                archiveScreen.subMenu.add(note)
                archiveScreen.handler()
            }

            archiveScreen.subMenu.add(archiveScreenItems)

            // обработчик для пункта архив
            archiveScreen.handler = {

                // показываем пункты меню архива
                showMenuItems("${Texts.NOTE_LIST} \"${archiveScreen.title}\"", Texts.ARCHIVE_EXIT, archiveScreen.subMenu)
                try {
                    val indexMenu = UserInput().selectNumberMenu(archiveScreen.subMenu.size)
                    if (indexMenu != archiveScreen.subMenu.size) {
                        archiveScreen.subMenu[indexMenu].handler()
                    }
                } catch (e: Exception) {
                    println(e.message)
                    archiveScreen.handler()
                }
            }

            menuList.add(menuList.size, archiveScreen)

            println(Texts.ARCHIVE_CREATED)
        })
    }

    private fun showMenuItems(title: String, exit: String, list: List<Menu>) {
        println(Texts.BR)
        println(title)
        list.forEachIndexed { index, menu -> println("$index. ${menu.title}") }
        println("${list.size}. $exit")
    }
}