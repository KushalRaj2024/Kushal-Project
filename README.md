**Features:**
Retrieve jokes via the /jokes endpoint.
Supports retrieving a specified number of jokes (default is 5, maximum is 100).
Jokes are fetched in batches of 10 in parallel to improve performance.
Validates input parameters and returns appropriate error messages.
Stores fetched jokes in a NoSQL database.
**Usage**:
Retrieve Jokes
To retrieve jokes, send a GET request to the /jokes endpoint with an optional count query parameter to specify the number of jokes to retrieve.

Example request:


bash
Copy code
GET /jokes?count=10
**Error Handling**
If the provided count parameter is invalid (less than 1 or greater than 100), the service returns a 400 Bad Request response with an error message.
Example error response:

json
Copy code
{
"message": "You can get no more than 100 jokes at a time"
}"# Kushal-Project" 
# java-jokes
