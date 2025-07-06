# JavaExample1
This is an application to demonstrate my ability to program in Java. As my first attempt to use IntelliJ as an IDE and Maven as the build environment, it had a number of interesting challenges.  However, I learned and worked through the quirks of the environment. As primarily a .NET developer for the last 10 years, I appreciate how that environment just works together out of the box.  Working on this project I can see how the more complicated setup in the Java world leads to a lighter weight and modular code base.
The application is divided into three main modules:
1. CLI - Uses the HttpClient API to connect to the Pluralsight ASI to get a selection of courses.  By using the Jackson plugin, the application maps the JSON to Java objects to store into a database using the repository module.
2. Repository - By use of the Repository coding pattern, the module abstracts out the object model. It stores and interacts with the data in a H2 database by use of the Java JDBC.
3. Server (REST API) - Through the use of a JAX-RS resource and the Jersey plugin, the module is able to use the Repository module to serve and update the data over port 4000.

All modules use the JUnit plugin to create simple unit tests and the SLF4J plugins to log messages to the command line.  The build process was also set up to create a stand-alone jar file that is located in the target folder of the Server module.

Future - The obvious next step would be to build a front end to interact with the API.  I would also like to expand out the database model and implement a more robust database.  Additionally, the use of an ORM tool like Hibernate would be a fun addition once the database model is expanded. I would also like to decouple the repository from the API for scalability.

