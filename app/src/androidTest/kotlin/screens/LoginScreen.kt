package screens

import com.example.myapplication.MainActivity
import com.example.myapplicationtest.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object LoginScreen : KScreen<LoginScreen>() {
    override val layoutId: Int get() = R.layout.login
    override val viewClass: Class<*> get() = MainActivity::class.java

    val emailField = KEditText { withId(R.id.textEmail) }
    val passwordField = KEditText { withId(R.id.textPassword) }

    val loginButton = KButton { withId(R.id.btnLogin) }
}