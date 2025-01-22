# Waste Sorting System

A RESTful API for waste sorting management.

## Description
The Waste Sorting System is a Spring Boot application designed to streamline the management of waste types, disposal guidelines and categories. 
It supports CRUD operations and enforces validation rules to ensure data consistency.

## Features
- Add, update, and delete disposal guidelines, catergories, waste types as well as recycling tips.
- Validate user inputs with detailed error handling.
- RESTful API endpoints for managing waste types and categories.
- Custom exception handling with meaningful error messages.

### Endpoints
- **GET /api/waste-types**: Retrieve all waste types.
- **GET /api/wast-types{id}**: Retrieve waste types by id.
- **GET /api/wast-types/category{category}**: Retrieve waste types by filtering using category.
- **GET /api/disposal-guidelines/{id}**: Retrieve disposal guidelines by id.
- **GET /api/disposal-guidelines**: Retrieve disposal guidelines.
- **GET /api/categories**: Retrieve all categories.
- **GET /api/categories/{id}**: Retrieve all categories by id.
- **GET /api/*recycling-tips*: Retrieve all recycling tips.
- **GET /api/recycling-tips{id}**: Retrieve recycling tips by id.

- **POST /api/waste-types**: Add a new waste type.
- **POST /api/disposal-guidelines**: Add a disposal guideline.
- **POST /api/categories**: Add a new category.
- **POST /api/recycling-tip**: Add a recycling tip type.

- **DELETE /api/categories/{id}**: Delete category by id.
- **DELETE /api/waste-types/{id}**: Delete waste type by id.
- **DELETE /api/disposal-guidlines/{id}**: Delete disposal guideline by id.
- **DELETE /api/recycling-tips/{id}**: Delete recycling-tips type by id.

- **UPDATE /api/categories/{id}**: Update category by id.
- **UPDATE /api/waste-types/{id}**: Update waste type by id.
- **Update /api/disposal-guidlines/{id}**: Update disposal guideline by id.
- **Update /api/recycling-tips/{id}**: Update recycling-tips type by id.

### Sample Request

POST /api//api/categories

{
  "wasteCategory": "Recycling",
  "description": "Waste that can be reused"
}

POST /api//api/waste-types

{
  "wasteType": "Chemicals",
  "wasteExample": "Acid",
  "category" : {
    "categoryId" : 1
  }
}

POST /api//api/disposal-guidelines

{
  "disposalMethod": "Local hazardous waste facilities.,
  "location": "Drop off at hazardous waste collection sites.",
  "wasteId" : {
    "wasteId" : 1
  }
}

POST /api//api/recycling-tips

{
  "additionalInfo": "Shredded paper can often be composted or taken to specialized recycling centers.",
  "material": "Paper",
  "tipDescription" : "Flatten boxes and remove tape or stickers."
  "wasteId" : {
    "wasteId" : 1
  }
}



























