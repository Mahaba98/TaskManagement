package backend

import com.sensoft.Role
import com.sensoft.Task
import com.sensoft.User
import com.sensoft.UserRole
import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->

        addUserRole()
        addTask()
    }
    User user1
    User user2

    @Transactional
    void addUserRole() {
        user1 = new User(username:"user@gmail.com",password:"pwd@123", firstName: "Mariama", lastName: "Gueye").save flush:true
        user2 = new User(username:"moustapha@gmail.com",password:"password@123", firstName: "Moustapha", lastName: "Sene").save flush:true
        def role1 = new Role(authority:"ROLE_USER").save flush:true
        def role2 = new Role(authority:"ROLE_USER").save flush:true
        UserRole.create(user1,role1)
        UserRole.create(user2,role2)
    }

    @Transactional
    void addTask() {
        
        if (Task.count() == 0){
            new Task(name: "task1", creationDate: new Date(), completionDate: new Date(), description:"description1", author: user1).save(flush:true)
            new Task(name: "task2", creationDate: new Date(), completionDate: new Date(), description:"description2", author: user1).save(flush:true)
            new Task(name: "task3", creationDate: new Date(), completionDate: new Date(), description:"description3", author: user1).save(flush:true)
            new Task(name: "task4", creationDate: new Date(), completionDate: new Date(), description:"description4", author: user2).save(flush:true)
        }
    }

        /*
        def role1 = Role.findByAuthority("ROLE_USER")
        if(role1==null){
            role1= new Role(authority:"ROLE_USER")
            role1.save()
        }
        def user1 = User.findByUsername("user@gmail.com")
        if(user1==null){
            user1= new User(username:"user@gmail.com",password:"pwd@123")
            user1.save()
        }
        def userRole = UserRole.findByUserAndRole(user1,role1)
        if (userRole==null){
            UserRole.create(user1,role1)
        }
         */


    def destroy = {
    }
}
