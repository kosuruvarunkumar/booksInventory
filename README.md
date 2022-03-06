# booksInventory
Server based web application for books inventory management

# Features implemented
* Backend
  * Inventory Management
    * List all the books in inventory along with count `GET {baseURL}/`
    * Add books into the inventory `POST {baseURL}/`
        ```
        Request Body
          {
            "gID": "12345",
            "eTag": "12",
            "title": "test",
            "publisher": "test",
            "publishedDate": "test",
            "description": "test",
            "imageLink": "test",
            "authors": "test,test4,test2",
            "count":40
          }
        ```
    * Delete Books from the inventory `DELETE {baseURL}/{id}`
    * Update Books from the inventory `POST {baseURL}/`
        ```
        Request Body
          {
            "gID": "12345",
            "eTag": "12",
            "title": "test",
            "publisher": "test",
            "publishedDate": "test",
            "description": "test",
            "imageLink": "test",
            "authors": "test,test4,test2",
            "count":50
          }
        ```
      
  * Integration with Google books API
    * Integrated Books GET API to retrieve the books matching the title of the books available in the Google `GET {baseURL}/q={queryString}`

# Run and build the system
  * System requirements
     * Install java 8 or higher and add it to the PATH
     * Install maven 2.6.4 and add it to the PATH
  * Build the project
        ```
        mvn install / mvn clean install
        ```
  * Run the project
        ```
        mvn spring-boot:run
        ```
        
  * Access the API endpoints at `http://localhost:8080`
  * My heroku endpoint `https://booksinventoryvarun.herokuapp.com/`
# To Be Done 
  * Add Frontend
