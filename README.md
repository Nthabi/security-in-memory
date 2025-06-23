# Getting Started

### Reference Documentation

This is a simple Spring security application that does in memory user creation and authentication. 
I use the spring login UI to authenticate but you can do the same via Postman or any REST client
All pages have simple text for the purpose of demonstration


### Endpoints
1. / - This is the home page. Unsecured and accessible without requiring any authentication
2. /stats - This is a secured page that requires authentication. It displays simple text once user has successfully authenticated
3. /new - This is an endpoint you should access via your preferred rest client to register a user. There is no UI for this. Sample payload is 
  {
   "username": "Nthabi",
   "password": "1111"
   }

### How to run the application
    You can either run the application using Docker or locally on your machine
    To use Docker do the following:
    - Ensure Docker is installed on your machine
    - Start your docker daemon
    - cd to the service directory
    - run docker build .
    - docker run <container-name>
    - visit localhost:8080 and specify the endpoint you would like to visit



### Support & Queries
Email: nthabimashiane@gmail.com
