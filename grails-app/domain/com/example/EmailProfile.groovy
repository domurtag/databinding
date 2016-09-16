package com.example

class EmailProfile implements Serializable {
    static transients = ['passwordStrength']

    static belongsTo = [user: User]

    Integer passwordStrength

    static constraints = {

        passwordStrength bindable: true, validator: { Integer strength, EmailProfile self ->
            strength >= 1
        }
    }
}
