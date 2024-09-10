# :surfer: Surfeillance-V2 Front-End

### A Surf Conditions Forecasting App

Welcome to my rewriting of **Surfeillance**! (seem my other repo) During our group project Northcoders Java Bootcamp. This project is mostly to give me a chance to write the backend and reimagine some functions of the app. The frontend is intentionally left unpolished (for now) as i feel i have served my time working with android XMLs during the bootcamp, and now want to focus my frontend energies on different formats.

There are however some intentional differences
- Integration of Local First principles, using the android sqlite3 db, and the Room ORM as the source of truth.
- More consitent adherence to MVVM architecture, with some attempt at Clean Architecture
- Many implementations of RecyclerViews to really hammer home their construction.

This project showcases various programming concepts and techniques including Android MVVM built in Java, Object Oriented Programming (OOP), Local First Development and Room ORM.
# 📚 Table of Contents
- 
  - [About the Project](#about-the-project)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [Usage](#usage)
  - [Built With](#built-with)
  - [Acknowledgements](#acknowledgements)


## <a id="about-the-project"></a>🚀 About the Project
Surfeillance V-2 is a surf forecasting app, that takes weather data from public APIs and transforms it into a coherent forecast for surfing conditions at particular locations. The current MVP is to provide at a glance, when the soonest decent surf is within the prediction period for the users selected locations.

## <a id = "getting-started"></a> 🛠️ Getting Started

### Prerequisites

This program is currently set up only to run in an IDE on an android VM.
Before you begin, ensure you have the following installed on your machine:

- Java JDK 8 or higher
- Maven
- An IDE (preferably IntelliJ IDEA)
- postgres installed with nothing taking up the 2345 localhost port
- nothing already taking up the localhost 8080 port that spring boot will use.

### Installation

1. **Clone the repositories**
   
From this link: https://github.com/notetakingforeggs/surfeillanceV2-backend and https://github.com/notetakingforeggs/surfeillanceV2-frontend
   
2.  **Open the project in your preferred IDE**

Open the cloned repositories in IntelliJ IDEA or any other code editor of your choice.

3. ** Ensure you have a suitable Android VM that is set up in your IDE**

  I have been running mine on a pixel 7 for no particular reason, but just in case it doesnt work on some models, for sure it works on that.

4.  **Build the project using Gradle,**

In IntelliJ IDEA, the project should automatically import Gradle dependencies. 


## <a id = "usage"></a> 🎮 Usage


 
1. **Run the Back-End **
  - ensure the backend is running on port 8080 of localhost. See the readme of the other surfeillance v2 repo for clearer instructions


3. **Run the frontEnd**
   - please note that there is only funcionality for a selection of surf spot of my choosing (that are convenient for me and friends to attend - broader utility intended in the future)

## <a id = "built-with"></a>  🛠️ Built With

- **Java** - The main programming language used.
- **Gradle** - Dependency management.
- **IntelliJ IDEA** - Recommended IDE for running and testing the project.
- **Room ORM** - Object Relational Mapper do deal with SQL queries of loca SQLITE3 db.
  

## <a id = "acknowledgements" ></a> 🙏 Acknowledgements

- **Northcoders Bootcamp** - For the incredible training and support.
- **Various Cohort members** For Invaluable feedback and encouragement.
---

Feel free to explore the project, and happy coding! 🚀


