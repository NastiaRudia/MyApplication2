package com.example.myapplication

import io.qameta.allure.kotlin.Allure
import java.io.File

fun File.attachVideoToAllureReport(): Unit = Allure.lifecycle.addAttachment(
    name = name,
    stream = this.inputStream(),
    type = "video/mp4",
    fileExtension = "mp4",
)