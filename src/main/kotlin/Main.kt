import kotlin.collections.ArrayList

fun main() {
    Main().start()
}

class Main {

    // создаем пустой список архивов
    private var archives: ArrayList<Archive> = arrayListOf()

    fun start() {

        // заполнет архивы тестовыми данными
        archives = getTestData()

        // показывает меню и просит пользователя сделать выбор
        while (true) {
            // показываем меню списка архивов
            val menu = Menu(archives.toList(), null)
            menu.showMenu()

            // просим пользователя выбрать пункт меню
            when (val selectedNumber = menu.selectMenu()) {
                // выбрано создание архива
                0 -> createArchive()

                // выбран архив
                in 1..archives.size -> {
                    // заметки выбранного архива
                    archives[selectedNumber - 1].showNotes()
                }

                // выбран выход из программы
                archives.size + 1 -> {
                    println(Texts.BYE.text)
                    break
                }
            }
        }
    }

    private fun createArchive() {
        // просит у пользователя название архива
        val archiveTitle = UserInput().getText(Texts.ARCHIVE_ENTER_TITLE.text)

        // добавляет архив
        archives.add(Archive(archiveTitle, arrayListOf()))
        println(Texts.ARCHIVE_CREATED.text)
    }

    // заполняет архивы тестовыми данными
    private fun getTestData(): ArrayList<Archive> {

        val archives: ArrayList<Archive> = arrayListOf()
        for (i in 1..(2..5).random()) {
            val listNotesArchive: ArrayList<Note> = arrayListOf()
            for (n in 1..(2..5).random()) {
                listNotesArchive.add(
                    Note("Тестовая заметка $n", "Текст тестовой заметки $n")
                )
            }
            archives.add(Archive("Тестовый архив $i", listNotesArchive))
        }

        return archives
    }
}