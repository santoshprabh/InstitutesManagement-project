
# Institutes management project

This project is a backend servivce for Institutes management system  which helps Institutes to rigister themselves and add key information and provides for retrival and modification of information as and when required.


## API Reference

#### Register institute

post /http://localhost:8080/api/institutes

Request format

{
    "name":"vtu",
    "location":"mysore",
    "contact":"vtu@gmail.com",
    "courses":"ME"

}



Response format

{
    "id": 5,
    "name": "vtu",
    "location": "mysore",
    "contact": "vtu@gmail.com",
    "courses": "ME"
}

#### Get all institutes

```http
  GET /http://localhost:8080/api/institutes
```



#### Get institute

```http
  GET /http://localhost:8080/api/institutes/1
```


#### update institute


```http
  put /http://localhost:8080/api/institutes/1
```


#### delete institute
```http
  delete /http://localhost:8080/api/institutes/1

###Tech Stacks

**Client:** postman

**Server:** MySQL,Embedded tomcat,embedded H2 database,docker

languages used:JAVA

framworks used:Springboot,Hibernate,Junit,Mockito,AssertJ.




## Deployment

To deploy this project run

```bash
docker build -t institutemanagemnt

docker run -p hostingport:portofcontainer(8080:8000)
```

