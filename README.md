# Job_Listing

## Overview
This is the backend that can be integrated to a frontend to build a full stack job listing application.

## To run (with Docker)

Expose port 9090 from the image and access the project via the exposed port. You can hit the swagger endpoint to post or search the jobs from the sample jobs stored on MongoDB Atlas.

Example:

```
docker build -t joblisting-docker.jar .
```

### To confirm docker image files

```
docker image ls
```

### To run docker image

```
docker run -p 9090:8080 joblisting-docker.jar
```

## Testing the server

Once started, you can navigate to [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html) to view the Swagger Resource Listing. This tell you that the server is up and ready with swagger-ui.

## Using the UI

You can inspect the job listing API using swagger-ui. You can access the swagger-ui source code from [here](https://github.com/swagger-api/swagger-ui).



