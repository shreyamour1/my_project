
Problem statement-  As per the assignment given by Neethu

Technologies used- Java, Spring Boot, H2 Database, Maven

---------------------------------------------------------------------------------------------------------------------------------------
How to start the application-

a) Clone the project from the git repository
b) Make sure that you have maven and Java installed in your local machine.
c) Run "mvn clean install" command inside the project directory to download spring dependencies required by maven.
d) Then go to file "DemoApplication.java" and run it as Java application.
e) The application will be up at port 1122
f) To connect to the database , go to url "http://localhost:1122/h2-console/", after the application is up.
g) Other configuarble properties related to database, port, logging are mentioned in "application.properties" file

-------------------------------------------------------------------------------------------------------------------------------------------

Things covered as part of the assignement


1) Added CRUD operation for Property class object.

Usecases
--------------------------------------------------------------------------------------------------------------------

POST - http://localhost:1122/property/

Eg of property JSON-
Request-

{"id": 1,
"latitude": 20.03,
"longitude": 13.45,
"price": 2000,
"noOfBedRooms": 4,
"noOfBathRooms": 2
}

Response-

{"id": 1,
"latitude": 20.03,
"longitude": 13.45,
"price": 2000,
"noOfBedRooms": 4,
"noOfBathRooms": 2
}


Response is stored in H2 database

-------------------------------------------------------------------------------------------------------
GET BY ID- id=1

GET  - http://localhost:1122/property/1

Response-

{
    "id": 1,
    "latitude": 20.03,
    "longitude": 13.45,
    "price": 2000.0,
    "noOfBedRooms": 4,
    "noOfBathRooms": 2
}

------------------------------------------------------------------------------------------------------------

GET all properties


GET -  http://localhost:1122/property/

Response- List of all properties stored in db


------------------------------------------------------------------------------------------------------------
DELETE BY ID- 

DELETE - http://localhost:1122/property/2

Response- FORBIDDEN 

Property with id will be deleted from H2 database.

-----------------------------------------------------------------------------------------------------------------
UPDATE- 


POST -  http://localhost:1122/property/

Request -

{"id": 1,
"latitude": 20.03,
"longitude": 13.45,
"price": 2000,
"noOfBedRooms": 5,
"noOfBathRooms": 2
}

Same as POST request with some field change, it will update the existing property. In above example, noOfBedRooms is changed.

--------------------------------------------------------------------------------------------------------------------------------------

2) Validation in property request- Added @NotNull in Property object, which will automatically not allow to persist in database, if mandatory fields are missing.

POST -  http://localhost:1122/property/ 

Request with some fileds(latitude) missing as below-

{"id": 1,
"longitude": 13.45,
"price": 2000,
"noOfBedRooms": 5,
"noOfBathRooms": 2
}

Response- 

{
    "timestamp": "2019-11-03T10:47:53.272+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Could not commit JPA transaction; nested exception is javax.persistence.RollbackException: Error while committing the transaction",
    "path": "/property/"
}

----------------------------------------------------------------------------------------------------------------

3) Error handling if in GET request , property doesnot exist

REQUEST -

GET POST -  http://localhost:1122/property/200

RESPONSE-  NoPropertyException custom exception is thrown and below response in postman

{
    "timestamp": "2019-11-03T10:22:03.531+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "No such property exist",
    "path": "/property/5"
}

----------------------------------------------------------------------------------------------------------

4) POST Requirement request to get list of properties with percentage >= 40 .
    a) Stored percentage of each field in ParamPercentage Object
	b) Used haversine formula to calculate distance for given and required latitudes and longitudes.
	c) Calculated percentage of each parameter as per the required problem statement.
	d) Handled error handling like if mandatiry fields are not present.
	
	
Use cases
-----------------------------------------------------------------------------------------------------------------------------------------------------------

a) Missing certain mandatory fields like latitude , both min and max budget- MissingMandatoryException( custom exception will be thrown) if fields are itself not present-

POST http://localhost:1122/requirement
Request-

{
	"id": 1,
"longitude": 13.45,
"minBedRoom": 2,
"maxBedRoom": 4,
"minBathRoom": 5,
"maxBathRoom": 10
}

Response-

{
    "timestamp": "2019-11-03T10:33:23.845+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Mandatory parameter(s): latitude,budget are missing",
    "path": "/requirement/"
}

----------------------------------------------------------------------------------------------------------------------------------

Positive scenarios

Before testing the below scenarios, we should make sure that following proprties are present in database

ID  	LATITUDE  	LONGITUDE  	NO_OF_BATH_ROOMS  	NO_OF_BED_ROOMS  	PRICE  
1	   20.03	   13.45	    2	                              4	   200.0
2	   20.03	   13.45	    2	                              4	   300.0
----------------------------------------------------------------------------------------------------------------------------------

b) Valid requirement when everything is given

POST http://localhost:1122/requirement
{
	"id": 1,
"latitude": 20.00,
"longitude": 13.45,
"minBudget": 200,
"maxBudget": 300,
"minBedRoom": 2,
"maxBedRoom": 4,
"minBathRoom": 5,
"maxBathRoom": 10
}

Response is both above metioned properties.

---------------------------------------------------------------------------------------------------------------------------

c)When either min or max budget / either min or max bathrrom/ min or max bedroom is given-

POST http://localhost:1122/requirement

{
	"id": 1,
"latitude": 20.00,
"longitude": 13.45,
"maxBudget": 250,
"maxBedRoom": 4,
"minBathRoom": 2
}

Response- Both above mentioned propeties will be the output

Contribution percentage wise for each field of both properties distance, budget, bathroom,bedroom
28.966521492962496 15.0 20.0 20.0
28.966521492962496 15.0 20.0 20.0
I have added print statement for percentage contribution.

--------------------------------------------------------------------------------------------------------------------------------

Many use cases with different latitude,longitude and any other combination can be tested. The one I mentioned is just an example to show how to run the application

d) When no valid property found, then response is empty array with HTTP Status as 200 ok

-----------------------------------------------------------------------------------------------------------------------------------------------


Future Scope-

1) Many error handling scenarios can be covered, like if database is down, we can add retries to the database for connecting again.
2) Storing the requirement object itself in database and implementing machine learning algorithms so that we can recommend users based on their interest( Recommendation Engine)

------------------------------------------------------------------------------------------------------------------------------------------------


That's all I could cover.
