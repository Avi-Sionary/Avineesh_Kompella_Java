# Project 2 - Bookstore Inventory

In this assessment, you will build a REST API to manage inventory for a bookstore. In addition, you will produce a 1-3 minute video summary of the project. The requirements and features are detailed below.

## Structure
Your solution must have the following structural elements:

- Your solution must be in an IntelliJ project called Summative-2-Lastname-Firstname.
- Your project must be built using Spring Boot and Spring Data JPA. Initialize your project using start.spring.io.
- Your project must have a series of tests using MockMvc.
- Your project must work with an existing database.
- Your REST API must accept and return data in JSON format where appropriate.
- Your REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.

## Requirements and Features
Your solution must be based on the existing book_store database. The script to create the book_store database is provided.

The Bookstore web service manages inventory for a bookstore. You must implement and document REST APIs to allow callers to create, read, read all, update, and delete Books, Authors, and Publishers in the system. The system must also allow callers to find Books by Author.

## User Stories
Your service must implement the following user stories:

- As an API user, I would like to create, read, update, and delete authors.
- As an API user, I would like to create, read, update, and delete publishers.
- As an API user, I would like to create, read, update, and delete books.
- As an API user, I would like to find all books by a given author.

## Video Summary Requirement
Create a 1-3 minute video summary highlighting your project. Be sure to highlight the sections of the project that are important in meeting the project requirements. Be sure to provide the following video requirements:
- Video should be created in MP4 format.
- Video should include a screen capture recording to display the important sections of the project.

## Submission
Once you have completed your summative assessment, follow the submission steps listed below:

## General set up and format requirements: 10%
- Solution must be in an IntelliJ project called Summative-2-Lastname-Firstname.
- Project must be built using Spring Boot and Spring Data JPA. Initialize your project using start.spring.io.
- Project must use Spring Data JPA that follows the pattern shown in this module.
- Project comes with a full set of test cases.
- The REST API must accept and return data in JSON format where appropriate.
- The REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.
- Provide a 1-3 minute Video Summary of the project.

## Book API Code: 30%
- Code is clean (follows general patterns as presented in class).
- Implementation of Book repository and controller for:
  * Create
  * Read
  * Read All
  * Update
  * Delete
  * Search Book by Author
- Test of Book repository for:
  * Create
  * Read
  * Read All
  * Update
  * Delete
  * Search Book by Author

## Author API Code: 30%
- Code is clean (follows general patterns as presented in class)
- Implementation of Author repository and controller for:
  * Create
  * Read
  * Read All
  * Update
  * Delete
- Test of Author repository for:
  * Create
  * Read
  * Read All
  * Update
  * Delete
## Publisher API Code: 30%
- Code is clean (follows general patterns as presented in class)
- Implementation of Publisher repository and controller for:
  * Create
  * Read
  * Read All
  * Update
  * Delete
- Test of Publisher repository for:
  * Create
  * Read
  * Read All
  * Update
  * Delete