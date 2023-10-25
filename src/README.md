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

**Note:** Ideally I should have used lombok, however, I suppose that due to dependency errors I couldn't get it to work and so I put the getters and setters in manually

## Running the API
In case you don't run through the IDE, navigate to the project directory and run the follow command in command line:
`mvn spring-boot:run
`
