# spring-boot projects

## Project Name

1. BookApplication (Rest Api)
2. BookClient      (Spring Rest Client)
3. BookReceiver    (Spring Messagint - JMS)

## Description

The purpose of Spring Boot Book Application is to demonstrate how to build a RESTful API using Spring Boot framework, and how to interact with a database using Spring Data JPA or In-memory database or HashMap to store the data. The Book Application API exposes several endpoints that allow users to retrieve, create, update, and delete books. The resources are stored in a MySQL database, and are managed using the Spring Data JPA framework. Also every time a book is added, deleted or updated, the application sends a JMS message with the corresponding book.<br>

The purpose of Book Client Application is to call the REST interface of the Book Application using RestTemplate.<br>

The purpose of Book Reciever Application helps to receives all messages send by the BookApplication.



## Installation

To run this project, you will need to have Java and Maven installed on your machine. Then, follow these steps:

1. Clone the repository to your local machine.<br>
2. Open the project in your favorite IDE.<br>
3. Run the Application.java file to start the Spring Boot application.<br>

## Usage

The following endpoints are available in the API:

GET /api/books/: retrieves a list of all books.<br>
GET /api/books/{isbn}: retrieves a single book by ID.<br>
POST /api/books/book: creates a new book.<br>
PUT /api/books/{isbn}: updates an existing book by ID.<br>
DELETE /api/books/{isbn}: deletes a book by ID.<br>
To use the API, you can use a tool such as Postman or cURL. <br> Here is an example of how to retrieve a list of all products using cURL:
<br>
curl http://localhost:8080/api/books
You should receive a JSON response containing an array of books.

## Technologies Used

Java<br>
Spring Boot<br>
Maven<br>

## Contributing

Contributions are welcome! If you find a bug or want to add a new feature, please open an issue or submit a pull request.

## License

N/A

## Contact

If you have any questions or concerns, please feel free to contact me at java.features@gmail.com. Thank you for using my application!
