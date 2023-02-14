package com.sensoft

class Task {
    String name
    Date creationDate
    Date completionDate
    String description

    static belongsTo = [author: User]

    static constraints = {
        name blank: false, unique: true
        creationDate nullable: false
        completionDate nullable: true
        description size: 0..500
        author nullable: false
    }
}
