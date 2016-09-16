package com.example

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UserController {

    def signup(User user) {

        if (!user.save()) {
            log.error "Validation errors $user.errors"
            render "Validation errors ${user.errors}${System.getProperty('line.separator')}"

        } else {
            render "User saved with ID ${user.id}"
        }
    }
}
