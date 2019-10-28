[![Build Status](https://travis-ci.org/afrunt/imdb.svg?branch=master)](https://travis-ci.org/afrunt/imdb)
## Java library for reading from [IMDb datasets](https://www.imdb.com/interfaces/)  
Add client to your project:
```xml
<dependency>
  <groupId>com.afrunt.imdb</groupId>
  <artifactId>imdb-reactive-client</artifactId>
  <version>1.0.7</version>
</dependency>
```

### Usage
Search for "Mortal Kombat":
```java
new IMDbClient()
    .fluxFor(TitleBasics.class)
    .filter(titleBasics -> titleBasics.getPrimaryTitle().contains("Mortal Kombat"))
    .subscribe(System.out::println);
```
or simply find all Van Damme's 😆
```java
new IMDbClient()
    .fluxFor(Name.class)
    .filter(name -> name.getPrimaryName().contains("Van Damme"))
    .subscribe(System.out::println);
```
and much more...