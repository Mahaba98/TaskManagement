package com.sensoft


import grails.rest.*
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import grails.gorm.transactions.Transactional


class TaskController extends RestfulController {
    TaskService taskService

    static responseFormats = ['json', 'xml']
    TaskController() {
        super(Task)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond taskService.list(params), model:[taskCount: taskService.count()]
    }

    def show(Long id) {
        respond taskService.get(id)
    }

    @Transactional
    def save(Task task) {
        if (task == null) {
            render status: NOT_FOUND
            return
        }
        if (task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond task.errors
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors
            return
        }

        respond task, [status: CREATED]
    }

    @Transactional
    def update(Task task) {
        if (task == null) {
            render status: NOT_FOUND
            return
        }
        if (task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond task.errors
            return
        }

        try {
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors
            return
        }

        respond task, [status: OK]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || taskService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }

}
