# NuPack

This project contains two classes. The first is the NuPackTest class which contains the main method. All test cases are executed within this method. The test begins by creating an object of type Package which is defined in the Package class. Three properties of the package can be set using the setter functions (base price, number of people for the job, and material). Based on this, the function calculateQuote() returns the final price for the job after the appropriate markups are applied.

The NuPack folder contains a build.xml file which contains a build script for ANT. In addition there is a NuPackSample.jar file. Both can be used to run the solution from the command/ terminal window. The .java files are contained within the src folder. The destination for the compiled files after build.xml is executed is the Demo folder.  

# Test Instructions

In order to execute build.xml, please install Apache ANT. 
Once this is done, in command prompt, set the current directory to the NuPack folder where build.xml is located and run the ant command.

```
cd $folderPath\NuPack
ant
```

Alternatively, you can execute the .jar file by first setting the current directory to the NuPack folder where build.xml is located and then running the executable .jar file.

```
cd $folderPath\NuPack
java -jar NuPackSample.jar
```
