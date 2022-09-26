package org.example.controllers

import io.javalin.apibuilder.CrudHandler
import io.javalin.http.Context
import org.example.dao.TaskDao
import org.example.exceptions.NotFoundException
import org.example.model.*
import java.time.LocalDate
import java.util.*


object TasksController : CrudHandler {
    val taskDAO : TaskDao = TaskDao()

    override fun create(ctx: Context) {
        val taskFromUser = ctx.bodyAsClass<TaskDTO>()

        taskDAO.save(taskFromUser)
    }

    override fun delete(ctx: Context, resourceId: String) {
        val taskById : Task = findTaskIfPossible(resourceId.toInt())

        taskDAO.delete(resourceId.toInt())
    }

    override fun getAll(ctx: Context) {
        ctx.json(taskDAO.tasks)
    }

    override fun getOne(ctx: Context, resourceId: String) {
        val taskById : Task = findTaskIfPossible(ctx.pathParam("id").toInt())

        ctx.json(taskById)
    }

    override fun update(ctx: Context, resourceId: String) {
        val taskBody = ctx.bodyAsClass<TaskDTO>()
        val taskById: Task = findTaskIfPossible(resourceId.toInt())

        if(taskById.status == TaskStatus.Pending){
            taskById.title = taskBody.title
            taskById.description = taskBody.description
            taskById.status = taskBody.status
        }

        ctx.json(taskById)
    }

    fun checkTask(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        val taskById: Task = findTaskIfPossible(id)

        taskById.check()

        ctx.json(taskById)
    }

    fun uncheckTask(ctx: Context) {
        val id = ctx.pathParam("id").toInt()
        val taskById: Task = findTaskIfPossible(id)

        taskById.uncheck()

        ctx.json(taskById)
    }

    private fun findTaskIfPossible(id: Int) : Task {
        val taskById : Task? = taskDAO.findById(id)

        if(Objects.isNull(taskById)) throw NotFoundException()

        return taskById!!
    }
}