package screens

import android.view.View
import com.example.myapplication.TodoListActivity
import com.example.myapplicationtest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object TodoScreen : KScreen<TodoScreen>() {
    override val layoutId: Int get() = R.layout.todo_list
    override val viewClass: Class<*> get() = TodoListActivity::class.java

    val rvTodo = KRecyclerView(
        builder = { withId(R.id.rvTodoItems) },
        itemTypeBuilder = {
            itemType {
                TodoItemScreen(it)
            }
        }
    )
    val helloText = KTextView { withId(R.id.helloText) }
    val todoInput = KEditText { withId(R.id.etTodoTitle) }
    val addTodoButton = KButton { withId(R.id.btnAddTodo) }

    class TodoItemScreen(matcher: Matcher<View>) : KRecyclerItem<TodoItemScreen>(matcher) {

        val itemText = KTextView { withId(R.id.tvTodoTitle) }
        val itemCheckbox = KCheckBox { withId(R.id.cbDone) }

    }
}