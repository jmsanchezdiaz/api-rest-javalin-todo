package org.example.dao

import org.example.model.Task
import org.example.model.TaskDTO
import org.example.model.TaskStatus

class TaskDao {
    val tasks: MutableList<Task> = mutableListOf(
        Task(0, "Ejemplo 1", "Descripcion ejemplo 1"),
        Task(1, "Ejemplo 2", "Descripcion ejemplo 2", TaskStatus.Completed),
        Task(2, "Ejemplo 3", "Descripcion ejemplo 3")

    )

    fun save(taskDTO: TaskDTO) {
        tasks.add(Task(tasks.size, taskDTO.title, taskDTO.description, taskDTO.status))
    }

    fun findById(id: Int): Task? = tasks.find { task -> task.id == id }

    fun delete(id: Int) {
        tasks.remove(this.findById(id))
    }
}