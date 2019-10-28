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
import com.afrunt.imdb.model.*;
import com.afrunt.imdb.reactiveclient.IMDbClient;
//...
new IMDbClient()
    .fluxFor(TitleBasics.class)
    .filter(titleBasics -> titleBasics.getPrimaryTitle().contains("Mortal Kombat"))
    .subscribe(System.out::println);
```
or simply find all Van Damme's 😆
```java
import com.afrunt.imdb.model.*;
import com.afrunt.imdb.reactiveclient.IMDbClient;
//...
new IMDbClient()
    .fluxFor(Name.class)
    .filter(name -> name.getPrimaryName().contains("Van Damme"))
    .subscribe(System.out::println);
```
and much more...
### Model
* com.afrunt.imdb.model.Name
* com.afrunt.imdb.model.TitleAkas
* com.afrunt.imdb.model.TitleBasics
* com.afrunt.imdb.model.TitleCrew
* com.afrunt.imdb.model.TitleEpisode
* com.afrunt.imdb.model.TitlePrincipals
* com.afrunt.imdb.model.TitleRatings