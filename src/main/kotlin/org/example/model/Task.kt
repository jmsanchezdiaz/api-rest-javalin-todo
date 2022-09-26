package org.example.model

import java.time.LocalDate

class TaskDTO(val title: String,
               val description: String,
               val status: TaskStatus = TaskStatus.Pending)


enum class TaskStatus(val value:String) {
    Pending("Pending"),
    Completed("Completed")
}

class Task(
    val id: Int,
    var title: String,
    var description: String,
    var status: TaskStatus = TaskStatus.Pending
) {
    fun check() {
        status = TaskStatus.Completed
    }

    fun uncheck() {
        status = TaskStatus.Pending
    }
}