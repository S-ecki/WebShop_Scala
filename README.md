# WebShop_Scala
This was my first small project using Scala. <br/>
It was created for my class [Programmiersprachen und -konzepte](https://ufind.univie.ac.at/de/course.html?lv=051030&semester=2020W) at the University of Vienna

## Structure
The Webshop consists of StoreItems, which get saved in a Database. <br/>

`StoreItem` inherits the Traits `Artikel` (for its fields) and `Logger` (for Console Output) <br/>
`Database` stores StoreItems in an Array and implements the functionality of the Trait `Warenkorb`, namely the functions `store()`, `search()`, `delete()` and `sumUp()`. <br/>
`MainApp` tests those functions. <br/>

Note: The data is not saved persistently, but only during runtime.

## What I´ve learned
* Basic Scala Syntax and Semantics
* Working with IntelliJ + sbt
* The benefits of Functional Programming
