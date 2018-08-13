# usersCRUD

## API

* **URL**

  `/users` or `/users?id=:id`
  
* **Method:**

  `GET` | `POST` 
  
*  **URL Params**

   *Optional:*
 
   `id=[string]`
   
* **Data Params**

  `{ firstName : [string], lastName : [string] }`
  
* **Success Response:**

  * **Code:** 200 OK <br />
    **Content:** `{ id : [string], firstName : [string], lastName: [string] }` <br />
              or `{ users: [ {
                      id : [string], 
                      firstName : [string], 
                      lastName: [string]
                    }
                  ] }`
                  
  OR
  
  **Code:** 201 CREATED <br />
  **Content:** `{ id : [string], firstName : [string], lastName: [string] }`
                  
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** `{ error : "No such document" }`  <br />
              or `{ error : "Invalid new user." }`

  OR

  * **Code:** 500 INTERNAL ERROR <br />
    **Content:** `{ error : "Internal error" }`

* **Tested by Postman**

  * Add a new user
  
  <img src="https://github.com/Yifeiww/usersCRUD/blob/master/add_new_user.png" width="70%" height="70%" />
  
  * Get all the users
  
  <img src="https://github.com/Yifeiww/usersCRUD/blob/master/get_all_users.png" width="70%" height="70%" />
  
  * Get a single user by id
  
  <img src="https://github.com/Yifeiww/usersCRUD/blob/master/get_a_single_user_by_id.png" width="70%" height="70%" />
  
  * Try to get a user that doesn't exist
  
  <img src="https://github.com/Yifeiww/usersCRUD/blob/master/get_a_user_that_doesn't_exist.png" width="70%" height="70%" />



## Built With

* [Resteasy](https://github.com/resteasy/Resteasy) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Could Firestore](https://firebase.google.com/docs/firestore/) - Database used
