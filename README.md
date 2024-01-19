# WeatherReport
This is the backend project which is based on forecast api to fetch the weather details

## Quick Start

### Setup in Intellij
- Clone the Project and import it in your fav IDE here we are using Intellij
- It downloads all the required dependencies
- In order to call the external api we need their secret key.
  - grab the header key and host key and put them into application.yml

- once the above steps are done just run the application in a regular way
- Once the application is running hit the api with below curl commands

```
curl --request GET 'http://localhost:8080/api/v1/weather/Munich/summary'
```

```
curl --request GET 'http://localhost:8080/api/v1/weather/Munich/hourly'
```
