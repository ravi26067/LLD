# Encapsulation

Get familiar with important aspects of object-oriented programming called data hiding and encapsulation.

## Table of Contents
- [Data hiding](#data-hiding)
  - [Components of data hiding](#components-of-data-hiding)
- [Encapsulation](#encapsulation)
  - [Implementing encapsulation in programming languages](#implementing-encapsulation-in-programming-languages)
- [Advantages of encapsulation](#advantages-of-encapsulation)

## Data hiding
Data hiding is an essential concept in object-oriented programming. In simple terms, it can be defined as masking a class's internal operations and only providing an interface through which other entities can interact with the class without being aware of what is happening within.

### Components of data hiding
Data hiding can be divided into two primary components:
- Encapsulation
- Abstraction

When used together, they allow us to make efficient classes for further use in our application.

## Encapsulation
Encapsulation is a fundamental programming technique used to achieve data hiding in OOP. Encapsulation in OOP refers to binding data and the methods to manipulate that data together in a single unit—class.

Encapsulation is usually done to hide the state and representation of an object from the outside. A class can be thought of as a capsule with methods and attributes inside it.

When encapsulating classes, a good convention is to declare all variables of a class private. This will restrict direct access by the code outside that class.

### Implementing encapsulation in programming languages
In this section, we will show how to implement encapsulation using some of the most popular object-oriented programming languages, such as Java, C#, Python, C++, and JavaScript.

For the sake of explanation, we’ll start off by creating a simple Movie class, which contains the following three data members (attributes):
- title
- year
- genre

#### Java
```java
class Movie {
  // Data members
  private String title;
  private int year;
  private String genre;

  // Default constructor
  public Movie() {
    title = "";
    year = -1;
    genre = "";
  }

  // Parameterized constructor
  public Movie(String t, int y, String g) {
    title = t;
    year = y;
    genre = g;
  }
}
```

There must be a way to interact with variables (`title`, `year`, and `genre`). They include all of the movie's information. The question is, how do we access or modify them?

We can create a `getTitle()` method, which will return the title to us. Similarly, the other two members can also have corresponding getters.

We may draw a conclusion by studying the emerging pattern. These functions should be part of the class itself. Let’s try it out.

### Java
```java
class Movie {
  // Data members
  private String title;
  private int year;
  private String genre;

  // Default constructor
  public Movie() {
    title = "";
    year = -1;
    genre = "";
  }

  // Parameterized constructor
  public Movie(String t, int y, String g) {
    title = t;
    year = y;
    genre = g;
  }
  
  // Getters and setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String t) {
    title = t;
  }
  
  public int getYear() {
    return year;
  }

  public void setYear(int y) {
    year = y;
  }
  
  public String getGenre() {
    return genre;
  }

  public void setGenre(String g) {
    genre = g;
  }
  
  void printDetails() {
    System.out.println("Title: " + title);
    System.out.println("Year: " + year);
    System.out.println("Genre: " + genre);
  }
  
  public static void main(String[] args) {
    Movie movie = new Movie("The Lion King", 1994, "Adventure");
    movie.printDetails();
    
    System.out.println("---");
    movie.setTitle("Forrest Gump");
    System.out.print("New title: " + movie.getTitle());
  }
}
```

The `Movie` class has an interface with public methods for communication.

The private members (variables or functions) cannot be accessed directly from the outside, but public read and write functions allow access to them. This, in essence, is data encapsulation.

## Advantages of Encapsulation 
- Classes are simpler to modify and maintain.
- Which data member we wish to keep hidden or accessible can be specified.
- We choose which variables are read-only and write-only (increases flexibility).
