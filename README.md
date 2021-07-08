# Fetch_Rewards

**Requirements**

1. Eclipse Enterprise Edition(EE)
2. Java 8
3. TOMCAT 9
4. JSON Library(jar)-json-20180813.jar
5. Servlet Api Library(jar)-servlet-api.jar

**SetUp**

**TOMCAT SetUp:**
Download Apache Tomcat 9 from https://tomcat.apache.org/download-90.cgi 
Extract the Tomcat to the desired path.

Open Eclipse. Navigate to server Tab.
Right Click. New -> Server
Select Apache Tomcat 9 from View.
Click on Configure RunTime. -> Click on the Add Button in Preferences Window.
Select Apache Tomcat v9.0 as runtime. -> Next.
Select Tomcat Installation directory(Navigate the tomcat directory path extracted earlier).
Select Finish.

Download the json library jar(json-20180813.jar) from the provided library folder at the same level as this Readme file on the Github.
Download the Servlet Api Library(servlet-api.jar) from the provided library folder at the same level as this Readme file on the Github.

Copy the json library file and Servlet Api Library files to Tomcat lib folder.

**Project Execution**

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
