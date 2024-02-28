package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.qameta.allure.android.rules.LogcatRule
import io.qameta.allure.android.rules.ScreenshotRule
import io.qameta.allure.android.rules.WindowHierarchyRule
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.DisplayName
import io.qameta.allure.kotlin.junit4.Tag
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import screens.LoginScreen
import screens.TodoScreen

@RunWith(AllureAndroidJUnit4::class)
@DisplayName("Login allure tests")
@Tag("Instrumentation")
@LargeTest
class LoginTest : TestCase() {

    @get:Rule
    val ruleChain: RuleChain = RuleChain.outerRule(LogcatRule())
        .around(ScreenshotRule())
        .around(WindowHierarchyRule())

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Description("Login and check todo")
    fun firstTest() = run {
        val email = "Nastia"

        Allure.step("Login user") {
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
        }
        Allure.step("Type todo") {
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
}