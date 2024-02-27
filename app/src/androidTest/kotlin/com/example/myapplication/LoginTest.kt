package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import screens.LoginScreen
import screens.TodoScreen

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun firstTest() {
        val email = "Nastia"
        LoginScreen {
            emailField {
                isVisible()
                replaceText(email)
            }
            passwordField {
                isVisible()
                replaceText("pass")
            }
            loginButton {
                click()
            }
        }
        TodoScreen {
            helloText {
                containsText(email)
            }
            todoInput {
                typeText("my todo")
            }
            addTodoButton {
                click()
            }
            rvTodo {
                childAt<TodoScreen.TodoItemScreen>(0) {
                    itemText.containsText("my todo")
                    itemCheckbox.click()
                }
            }

        }

    }
}