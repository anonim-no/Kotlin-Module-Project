import kotlin.collections.ArrayList

class Archive(private val title: String, private val notes: ArrayList<Note>) : MenuItem {

    fun showNotes() {
        while (true) {
            // показывает меню списка заметок
            val menu = Menu(this.notes.toList(), this)
            menu.showMenu()

            // и просит пользователя выбрать пункт меню
            when (val selectedNumber = menu.selectMenu()) {
                // выбрано создание заметки
                0 -> this.createNote()

                // выбрана заметка
                in 1..this.notes.size -> {
                    // показывает содержимое заметки
                    showNote(selectedNumber - 1)
                }

                // выбран выход из архива
                this.notes.size + 1 -> {
                    println(Texts.ARCHIVE_EXIT.text)
                    break
                }
            }
        }
    }

    // показывает заметку
    private fun showNote(index: Int) {
        println(Texts.BR.text)
        println(Texts.NOTE.text + " \"${this.notes[index].title}\":")
        println(this.notes[index].text)
        println(Texts.BR.text)
        UserInput().exitNote()
    }

    // получает заголовок и текст заметки от пользователя и создает заметку
    private fun createNote() {
        val userInput = UserInput()
        val noteTitle = userInput.getText(Texts.NOTE_ENTER_TITLE.text)
        val noteText = userInput.getText(Texts.NOTE_ENTER_TEXT.text)
        notes.add(Note(noteTitle, noteText))
        println(Texts.NOTE_CREATED.text)
    }

    override fun getItemTitle(): String {
        return this.title
    }

}