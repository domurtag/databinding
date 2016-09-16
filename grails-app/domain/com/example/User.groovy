package com.example

class User implements Serializable {

    String name

    static hasOne = [
            emailProfile: EmailProfile
    ]
}
