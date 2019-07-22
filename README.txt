demo20-spring-boot-oauth2jwt

To test the application, you can use POSTMAN like the following:

	1. Copy paste http://localhost:8080/oauth/token as a POST request
	2. Go to authorization tab and use basic auth for inserting
	the username as kurosh-client-username and password as kurosh-secret-client-password
	3. Go to the Body tab and insert the username, password, and grant_type according
	to your database and own configuration
	
If you need help in setting up this project, send me a message at LinkedIn or my email 
kurosh_farsimadan@yahoo.com

Example query after getting the token is like the following

http://localhost:8080/api/usercount?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NTU5NzU0NjMsInVzZXJfbmFtZSI6IkFkYW0iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImp0aSI6ImE3MmE1Mzg1LTdiOTUtNDQ2OC1iNGE0LWNkNzMyZjgzYThkYyIsImNsaWVudF9pZCI6ImVyaWEtY2xpZW50LXVzZXJuYW1lIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIiwidHJ1c3QiXX0.uhODaioZK60Rcj75m2DDMizXZ-PvMjqwaWSXSfkMW90
	
