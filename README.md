##  Java SDK Wrapper for the Termii API 
A Java API wrapper that makes it easier to integrate Java-based applications with the Termii API and to develop them quickly.

To facilitate quick prototyping and testing, TermiiJava opens up a wide range of helper methods and decreases the manual effort that comes with consuming the Termii API. 

### Prerequisites

- Java 8 or higher
- Maven

### dependencies in the `pom.xml` file
```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
        //use user versions
    </dependency>
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.13</version>
    </dependency>
</dependencies>
```
## Installation:
- Download TermiiJava 
- Add jar file as a Module to your Java project:
- On Intellij IDEA: File -> Project Structure -> Modules -> Dependencies Tab -> Add -> JARs or Directories -> Attach jar
- On Netbeans: Project properties -> Libraries -> Compile -> ADD JAR/folder -> Add Jar
- On Eclipse: Project properties -> Java Build Path -> Libraries -> Add External JARs -> Add Jar

## Usage
#### To get SenderId
```java
    SenderID senderID = new SenderID(); 
    JSONObject jsonObject = senderID.getAllSenderId();
    System.out.println(jsonObject.toString());
```
#### To create a new SenderId
```java
    HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.put("sender_id", "Your SenderId");
    dataMap.put("usecase", "Your Usecase");
    dataMap.put("company", "Your company");
            
    SenderID senderID = new SenderID(); 
    JSONObject jsonObject = senderID.requestSenderId(dataMap);
    System.out.println(jsonObject.toString());
```
#### Send SMS
```java
    HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.put("to", "Your Recipient Number");
    dataMap.put("from", "SenderID");
    dataMap.put("sms", "Your message");
    dataMap.put("type", "message Type");
    dataMap.put("channel", "your channel");
    
    //in case you want to send message to multiple recipients
    your dataMap.put("to", "Your Recipient Number");  would be an List of numbers like this
    List<String> numbers = new ArrayList<>();
    dataMap.put("to", numbers);
    //note that the maximum number of recipients is 100 for this api
    MessagingApi messagingApi = new MessagingApi();
    JSONObject messageObject = messagingApi.sendMessage(dataMap);
    System.out.println(messageObject.toString());
```
#### Send Bulk sms
```java
    HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.put("from", "SenderID");
    dataMap.put("sms", "Your message");
    dataMap.put("type", "message Type");
    dataMap.put("channel", "your channel");
    List<String> numbers = new ArrayList<>();
    dataMap.put("to", numbers);
    //note that the maximum number of recipients is 10000 for this api
    MessagingApi messagingApi = new MessagingApi();
    JSONObject messageObject = messagingApi.sendBulkMessage(dataMap);
    System.out.println(messageObject.toString());
```
## Note
- The Termii API requires an API key for authentication. You can get your API key by signing up on the [Termii website](https://account.termii.com/signup) and creating a new project.
- You need to create a json file in the root directory of your project and name it `configKey.json` and add your API key to it like this:
```json
{
  "API_KEY": "Your API Key
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.





