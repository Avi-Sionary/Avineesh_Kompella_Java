### Video Summary: 
https://drive.google.com/file/d/1A5InIGBGe2Ac7U1QoG41GsKJkyN_3FIL/view?usp=sharing

# Summative-1-Kompella-Avineesh

## About
Simple REST web service. It provides quote-of-the-day, word-of-the-day, and Magic 8 Ball services. Also includes a short video summary of the project. Built for the Advanced Java Bootcamp run by Netflix Career Pathways + 2U.

## Features
This web service is a quote-of-the-day, word-of-the-day, and Magic 8 Ball service. You must implement and document the following REST APIs:

### Quote API:
- URI: /quote
- Method: GET
- Request Body: None
- Response Body: Quote

Quote object instance variables:
- id
- author
- quote

### Word API
- URI: /word
- Method: GET
- Request Body: None
- Response Body: Definition

Definition object instance variables:
- id
- word
- definition

### Magic 8 Ball API:
- URI: /magic
- Method: POST
- Request Body: Question
- Response Body: Answer
- The POST request for the Magic 8 Ball endpoint includes a user-provided question.

NOTE: The students are not being asked to provide Entity/Model validations or validation responses in this summative project. This means that it is possible to submit the Magic 8 Ball POST request without a question, and a response will still be returned.

Answer object instance variables:
- id
- question
- answer

## User Stories
Service implements the following user stories:

- As an API user, I would like to request a quote from a list of at least 10 quotes. Quotes must be served at random.

- As an API user, I would like issue definition requests from a list of at least 10 words and their corresponding definitions. Words and definitions must be served up at random.

- As an API user, I would like to request Magic 8 Ball responses from a list of at least 6 different responses. Magic 8 Ball answers must be served up at random.

