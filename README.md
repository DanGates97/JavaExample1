# JavaExample1
This is an application to demonstrate my ability to program in Java. 

The application is divided into three main modules:
1. CLI - Uses the HttpClient API to connect to the Pluralsight ASI to get a selection of courses.  By using the Jackson plugin, the application maps the JSON to Java objects to store into a database using the repository module.
2. Repository - By use of the Repository coding pattern, the module abstracts out the object model. It stores and interacts with the data in a H2 database by use of the Java JDBC.
3. Server (REST API) - Through the use of a JAX-RS resource and the Jersey plugin, the module is able to use the Repository module to serve and update the data over port 4000.

All modules use the JUnit plugin to create simple unit tests and the SLF4J plugins to log messages to the command line.  The build process was also set up to create a stand-alone jar file that is located in the target folder of the Server module.

