http://localhost:8080/api/employees/upload

Go to Postman
Create a Post request with the excel file attached in the code
Go to Body and select form data
under file select excel file and send the post request.

Dependency Required to process excel file.
<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.*.*</version> 
		</dependency>
