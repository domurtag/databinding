A project that reproduces a Grails bug. To demonstrate the bug follow these steps using Grails 2.5.4

 1. Start the app with `grails run-app`
 2. POST the following JSON with curl
 
 `curl -H "Content-Type: application/json" -X POST -d '{"name":"Test","emailProfile":{"passwordStrength":0}}' http://localhost:8080/databinding/user/signup`
 
 Validation of the user (incorrectly) passes, but `NullPointerException` will be thrown from deep within the bowels of Hibernate 
 during the attempt to save the user.
 
 3. Stop the application
 4. Remove the following from the `com.example.EmailProfile` domain class
 
```
static transients = ['passwordStrength']
``` 

 5. Start the application and post the same JSON as before. Validation of the user correctly fails (because `passwordStrength is 0),
  and no attempt is made to persist the user