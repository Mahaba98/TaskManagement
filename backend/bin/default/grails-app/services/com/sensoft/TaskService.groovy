package com.sensoft

import grails.gorm.services.Service

@Service(Task)
interface TaskService {

    Task get(Serializable id)

    List<Task> list(Map args)

    Long count()

    Task delete(Serializable id)

    Task save(Task task)
}
