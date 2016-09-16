package com.example

class EmailProfile implements Serializable {
    static transients = ['passwordStrength']

    static final MIN_PASSWORD_STRENGTH = 1

    static belongsTo = [user: User]

    Integer passwordStrength

    static constraints = {

        passwordStrength bindable: true, validator: { Integer strength, EmailProfile self ->
            // only need to validate password strength when saving an email-registered user for the first time
            self.id || strength >= MIN_PASSWORD_STRENGTH
        }
    }
}
