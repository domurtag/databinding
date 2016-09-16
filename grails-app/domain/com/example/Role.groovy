package com.example

class Role implements Serializable {

	String authority

	static mapping = {
        cache usage: 'read-only'
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
