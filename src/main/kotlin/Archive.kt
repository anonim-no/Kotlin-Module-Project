import kotlin.collections.ArrayList

class Archive(val title: String, val notes: ArrayList<Note>): MenuItem {

    fun createNote() {
        val userInput = UserInput()
        val noteTitle = userInput.getText("Введите название заметки")
        val noteText = userInput.getText("Введите текст заметки")
        notes.add(Note(noteTitle, noteText))
    }

    fun showNote(index: Int) {
        println("---")
        println("\"${this.notes.get(index).title}\"")
        println(this.notes.get(index).text)
        println("---")
    }

    override fun getItemTitle(): String {
        return this.title
    }

    override fun createText(): String {
        return "Создать архив"
    }

}