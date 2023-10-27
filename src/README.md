# Country REST API

This Spring Boot REST API is designed to manage country data. It provides endpoints for creating, retrieving, updating, and deleting countries, as well as listing countries in a paginated and sorted manner.

## Implementation Overview

The API is built using Spring Boot and follows RESTful API conventions and principles. It consists of the following components:

- **CountryController:** Handles HTTP requests and defines the REST endpoints.
- **CountryService:** Provides the business logic for managing country data.
- **CountryRepository:** Manages database interactions.
- **CountryDTO:** Data Transfer Object for country information.
- **CountriesResponseDTO:** Data Transfer Object for paginated country data and metadata.
- **Country:** Entity class representing a country in the database.

**Note:** Ideally I should have used Lombok, I couldn't activate eclipse's annotation processing to recognise Lombok's annotations and I couldn't run the program in InteliJ either, so I created the getters, setters and constructors manually

## Running the API
In case you don't run through the IDE, navigate to the project directory and run the follow command in command line:
`mvn spring-boot:run
`
## API Endpoints
### 1. Create a Country

- **Endpoint:** `POST /api/countries`
- **Request Body:** JSON object with the format: `{"name": "<country name>"}`
- **Example Request:**

   ```http
   POST /api/countries
   Content-Type: application/json

   {
     "name": "United States"
   }
  ```
**Example Response (Success)**
```json
HTTP Status: 200 OK
```
**Example Response (Country Already Exists)**
```json
HTTP Status:  404 NOT_FOUND
```
### 2. List All Countries

- **Endpoint:** `GET /api/countries`
- **Parameters:** `page` (default value: 0)
- **Example Request:**

```http 
  GET /api/countries
  ```
**Example Response (Success)**
``` json
HTTP Status: 200 OK
{
"countries": [
{"name": "Canada"},
{"name": "France"},
],
"currentPage": 1,
"totalItems": 2,
"totalPages": 5
}
```
### 3. Retrieve a Country by ID

- **Endpoint:** `GET /api/country/{id}`
- **Example Request:**

 ```http
   GET /api/country/1
````
**Example Response (Success)**
``` json
HTTP Status: 200 OK
{
  "name": "India"
}
```
### 4. Update a Country's Name

- **Endpoint:** `PUT /api/country/{id}`
- **Request Body:** JSON object with the format: `{"name": "<new country name>"}`
- **Example Request:**

```http
   PUT /api/country/1
   Content-Type: application/json

   {
     "name": "USA"
   }
````
**Example Response (Success)**
``` json
HTTP Status: 200 OK
```
**Example Response (Not Success)**
``` json
HTTP Status: 404 NOT_FOUND
```
### 5. Delete a Country

- **Endpoint:** `DELETE /api/country/{id}`
- **Example Request:**

```http
   DELETE /api/country/1
```

**Example Response (Success)**
``` json
HTTP Status: 200 OK
```
**Example Response (Not Success)**
``` json
HTTP Status: 404 NOT_FOUND
```