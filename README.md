# Fetch_Rewards
NOTE: This project is completed Developed and tested on Eclipse Enterprise Edition. While using this application Eclipse IDE it is recommended.

NOTE: If you are using any other IDE such as IntelliJ, you might have to customize the build configuration according to your Machine.

**Requirements**

1. Eclipse Enterprise Edition(EE)
2. Java 8
3. TOMCAT 9
4. JSON Library(jar)-json-20180813.jar
5. Servlet Api Library(jar)-servlet-api.jar

**SetUp**

**Eclipse SetUp:**

Download the Eclipse from https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-06/R/eclipse-inst-jre-win64.exe

Choose Eclipse Enterprise Java and Web Dev.

Install.

**TOMCAT SetUp:**

Open Eclipse. Navigate to server Tab.

Right Click. New -> Server

CLick on Apache and choose Tomcat v9.0 Server -> Next.

Select Download and Install Tomcat.(wait for few seconds it will download the tomcat).

NEXT.

Add FetchRewards to configured.

Finish

Download the json library jar(json-20180813.jar) from the provided library folder at the same level as this Readme file on the Github.
Download the Servlet Api Library(servlet-api.jar) from the provided library folder at the same level as this Readme file on the Github.

Copy the json library file and Servlet Api Library files to Tomcat lib and bin folder.

**Project Execution**

Import the project using git.

Select Import from File. Select Git.
Clone URI.
Copy URI and paste into URI tab. NEXT.

Open the project in Eclipse.
Right click on Project. -> Run As -> Run on Server.
Select Tomcat Setup earlier and click next.
Select the project and Click Add.
Click Finish

Project Runs on Below URL:
http://localhost:8080/FetchRewards/

**Project Details**

Instructions for Using the Application

1. Add Transaction
Acceptable format of Input Data:
{ "payer": "DANNON", "points": 1000, "timestamp": "2020-11-02T14:00:00Z" }
{ "payer": "UNILEVER", "points": 200, "timestamp": "2020-10-31T11:00:00Z" }
{ "payer": "DANNON", "points": -200, "timestamp": "2020-10-31T15:00:00Z" }
{ "payer": "MILLER COORS", "points": 10000, "timestamp": "2020-11-01T14:00:00Z" }
{ "payer": "DANNON", "points": 300, "timestamp": "2020-10-31T10:00:00Z" }

3. Spend Points
Please Enter Numerical Characters.

5. Show Balances
Click on the show balances button.

Edge Cases Handled:
1. When the Points to be Spend excceds the available points then we do not allow the point expenditure.
2. If the text characters are entered other than numerical character inside the Spend Point text area then then points will not be deducted and Error message will be displayed.
3. If text entered in the Add transaction Text box other than JSON format data then it will display Invalid Data Message.
4. If transactions are not added and points are spend using the spend point functionality then the error message is thrown(Please ADD the transaction details). 
