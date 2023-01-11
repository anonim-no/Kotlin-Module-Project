fun main() {
    Main().start()
}

class Main {

    // создаем список архивов
    var archives: ArrayList<Archive> = arrayListOf()

    fun start() {

        // заполняем архивы тестовыми данными
        archives = getTestData()

        while (true) {
            // выбранный пункт меню
            var selectedNumber: Int

            // показываем меню списка архивов
            // и просим пользователя выбрать пункт меню
            selectedNumber = Menu(
                "Список архивов:",
                "Создать архив",
                archives.toList()
            ).showMenu()

            when(selectedNumber) {
                // создание архива
                0 -> createArchive()
                // выход из программы
                archives.size + 1 ->  {
                    println("Работа завершена.")
                    break;
                }
                // один из архивов
                in 1..archives.size -> {
                    // выбранный архив
                    val selectedArchive = archives.get(selectedNumber - 1)

                    while (true) {
                        // показываем меню списка заметок
                        // и просим пользователя выбрать пункт меню
                        selectedNumber = Menu(
                            "Список заметок архива \"${selectedArchive.title}\":",
                            "Создать заметку",
                            selectedArchive.notes.toList()
                        ).showMenu()

                        when (selectedNumber) {
                            // создание заметки
                            0 -> selectedArchive.createNote()
                            // выход из архива
                            selectedArchive.notes.size + 1 -> {
                                println("Выходим из архива.")
                                break
                            }
                            // показываем выбранную заметку
                            in 1..selectedArchive.notes.size -> {
                                // показываем содержимое заметки
                                selectedArchive.showNote(selectedNumber-1)
                            }
                        }

                    }
                }
            }

        }

    }

    fun createArchive() {
        val archiveTitle = UserInput().getText("Введите название архива")
        archives.add(Archive(archiveTitle, arrayListOf()))
    }

    private fun getTestData(): ArrayList<Archive> {

        val listNotesArchive1: ArrayList<Note> = arrayListOf()
        listNotesArchive1.add(
            Note(
                "Тестовая заметка 1, Архив 1",
                "Текст текстовой заметки 1, Архив 1"
            )
        )
        listNotesArchive1.add(
            Note(
                "Тестовая заметка 2, Архив 1",
                "Текст текстовой заметки 2, Архив 1"
            )
        )

        val listNotesArchive2: ArrayList<Note> = arrayListOf()
        listNotesArchive2.add(
            Note(
                "Тестовая заметка 1, Архив 2",
                "Текст текстовой заметки 1, Архив 2"
            )
        )
        listNotesArchive2.add(
            Note(
                "Тестовая заметка 2, Архив 2",
                "Текст текстовой заметки 2, Архив 2"
            )
        )

        val archives: ArrayList<Archive> = arrayListOf()
        archives.add(Archive("Тестовый архив 1", listNotesArchive1))
        archives.add(Archive("Тестовый архив 2", listNotesArchive2))

        return archives
    }
}