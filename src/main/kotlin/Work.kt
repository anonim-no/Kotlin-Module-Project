class Work {

    private val menuList = mutableListOf<Menu>()

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

                // пользователь выбрал последний пункт - выход из программы
                if (indexMenu == menuList.size) {
                    println(Texts.BYE)
                    break
                }

                // вызываем обработчик для пункта меню архивов
                menuList[indexMenu].handler()

            } catch (e: Exception) {
                // показываем ошибки выбора пункта меню
                println(e.message)
            }
        }
    }

    private fun createMenu() {
        // создаем меню архивов
        // изначально состоит из двух пунктов 1. создать архив и выход

        // пункт создания архива
        menuList.add(Menu(Texts.ARCHIVE_CREATE) {
            // вызывает функцию создания архива
            // запрашиваем имя
            val archiveName = UserInput().getText(Texts.ARCHIVE_ENTER_TITLE)
            val archiveScreen = Archive(archiveName)

            // архив изначально содержит в себе пункт создания заметки и выход
            // пункт создания заметки
            val archiveScreenItems = Menu(Texts.NOTE_CREATE) {
                // вызываем функцию создания заметки
                // запрашиваем название и текст
                val userInput = UserInput()
                val noteTitle = userInput.getText(Texts.NOTE_ENTER_TITLE)
                val noteText = userInput.getText(Texts.NOTE_ENTER_TEXT)
                val note = Note(noteTitle, noteText)
                println(Texts.NOTE_CREATED)

                // заметка вызывает функцию просмтора заметки
                note.handler = {
                    println(Texts.BR)
                    println(Texts.NOTE + " \"${note.title}\":")
                    println(note.text)
                    println(Texts.BR)
                    // просим нажать Enter для выхода
                    UserInput().exitNote()
                    // показываем меню текущего архива
                    archiveScreen.handler()
                }

                // добавляем заметку в меню архива
                archiveScreen.subMenu.add(note)

                // показываем меню текущего архива
                archiveScreen.handler()
            }

            // добавляем архив
            archiveScreen.subMenu.add(archiveScreenItems)

            // обработчик для пункта архив
            archiveScreen.handler = {

                // показываем пункты меню архива
                showMenuItems("${Texts.NOTE_LIST} \"${archiveScreen.title}\"", Texts.ARCHIVE_EXIT, archiveScreen.subMenu)

                try {
                    // ожидаем выбор пользователя
                    val indexMenu = UserInput().selectNumberMenu(archiveScreen.subMenu.size)
                    if (indexMenu != archiveScreen.subMenu.size) {
                        // вызываем обработчик для пункта меню
                        archiveScreen.subMenu[indexMenu].handler()
                    }
                } catch (e: Exception) {
                    // показываем ошибки выбора пункта меню
                    println(e.message)
                    // показываем меню текущего архива
                    archiveScreen.handler()
                }
            }

            // добавляем созданный архив
            menuList.add(menuList.size, archiveScreen)
            println(Texts.ARCHIVE_CREATED)
        })
    }

    // показывает название, пункты меню и добавляет пункт выхода
    private fun showMenuItems(title: String, exit: String, list: List<Menu>) {
        println(Texts.BR)
        println(title)
        list.forEachIndexed { index, menu -> println("$index. ${menu.title}") }
        println("${list.size}. $exit")
    }
}