package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TodoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(TodoListActivity::class.java)

    @Test
    fun firstTest() {
        // scenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.etTodoTitle)).perform(ViewActions.typeText("test todo"))
        onView(withId(R.id.btnAddTodo)).perform(ViewActions.click()).check(matches(isDisplayed()))
        onView(withId(R.id.helloText)).check(matches(withText("test todo")))
        onView(withId(R.id.etTodoTitle)).check(matches(withText("")))
        println()
        //  scenario.close()
    }
}