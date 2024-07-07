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
## Note
- The Termii API requires an API key for authentication. You can get your API key by signing up on the [Termii website](https://account.termii.com/signup) and creating a new project.
- You need to create a json file in the root directory of your project and name it `configKey.json` and add your API key to it like this:
```json
{
  "API_KEY": "Your Termii API Key"
}
```
## Usage
#### To get SenderId

```java
    import termii.main.tech.olatunbosun.Messaging;

Messaging messaging = new Messaging();
JSONObject jsonObject = messaging.getAllSenderId();
    System.out.

println(jsonObject.toString());
```
#### To create a new SenderId

```java
    import termii.main.tech.olatunbosun.Messaging;

HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.

put("sender_id","Your SenderId");
    dataMap.

put("usecase","Your Usecase");
    dataMap.

put("company","Your company");

Messaging messaging = new Messaging();
JSONObject jsonObject = messaging.requestSenderId(dataMap);
    System.out.

println(jsonObject.toString());
```
#### Send SMS

```java
    import termii.main.tech.olatunbosun.Messaging;

HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.

put("from","SenderID");
    dataMap.

put("sms","Your message");
    dataMap.

put("type","message Type");
    dataMap.

put("channel","your channel");

//single recipient
    dataMap.

put("to","Your Recipient Number");

//multiple recipients
would be a List of numbers like this

List<String> numbers = new ArrayList<>();

dataMap.put("to",numbers);

//note that the maximum number of recipients is 100 for this api
Messaging messaging = new Messaging();
JSONObject messageObject = messaging.sendMessage(dataMap);
    System.out.

println(messageObject.toString());
```
#### Send Bulk sms

```java
    import termii.main.tech.olatunbosun.Messaging;

HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.

put("from","SenderID");
    dataMap.

put("sms","Your message");
    dataMap.

put("type","message Type");
    dataMap.

put("channel","your channel");

List<String> numbers = new ArrayList<>();
    dataMap.

put("to",numbers);

//note that the maximum number of recipients is 10000 for this api
Messaging messaging = new Messaging();
JSONObject messageObject = messaging.sendBulkMessage(dataMap);
    System.out.

println(messageObject.toString());
```
#### Send Number Message

```java
    import termii.main.tech.olatunbosun.Messaging;

HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.

put("to","Your Recipient Number");
    dataMap.

put("sms","Your message");

Messaging messaging = new Messaging();
JSONObject numberMessageObject = messaging.sendMessage(dataMap);
    System.out.

println(numberMessageObject.toString());
```
#### Send Template Message

```java
    import termii.main.tech.olatunbosun.Messaging;

HashMap<String, Object> dataMap = new HashMap<>();
    dataMap.

put("phone_number","Your Recipient Number");
    dataMap.

put("template_id","Your Template Id");
    dataMap.

put("device_id","Your Device Id");

HashMap<String, Object> templateData = new HashMap<>();
    templateData.

put("product_name","Your Name");
    templateData.

put("otp","Your Number");
    templateData.

put("expiry_time","Your Time");
    dataMap.

put("data",templateData);

Messaging messaging = new Messaging();
JSONObject templateMessageObject = messaging.sendMessage(dataMap);
    System.out.

println(templateMessageObject.toString());
```





## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.





