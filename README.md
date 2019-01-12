# Amazon AWS Lambda Support Library

[![License](https://img.shields.io/github/license/xenosnowfox/library-java-amazonaws-lambda.svg)](https://opensource.org/licenses/MIT)

Support library for working with AWS Lambda functions.

---

## Usage

Simply create a class that extends the `AbstractLambdaHandler`, implementing the handle method.
```java
package com.example;

import com.xenosnowfox.amazonaws.lambda.*;
import com.xenosnowfox.amazonaws.lambda.response.JsonObjectResponse;
import org.json.JSONObject;

public class MyLambdaHandler extends AbstractLambdaHandler {

    public Response handle(final Request request) {

        // create a body payload
        JSONObject json = new JSONObject();
        json.put("message", "Hello Lambda!");

        // generate a response object
        JsonObjectResponse resp = new JsonObjectResponse();
        resp.setBase64Encoded(false);
        resp.setHttpStatus(HttpStatus.OK);
        resp.putHeader("Content-Type", "application/json");
        resp.setBodyContent(json);

        // return the response object
        return resp;
    }
}
```

### Compiling

To compile this project using maven:

```
mvn clean package shade:shade
```

The compiled JAR file will be created in the `/target` folder.

### AWS Lambda Set-up

In AWS Lambda, have your function set to use `com.example.MyLambdaHandler::handleRequest` as it's handler, where MyLambdaHandler is a class that extends the AbstractLambdaHandler class.

## Support

If you need hep using this library, please feel free to send an email or create an issue within GitHub.

## Licence

This project is licensed under **MIT License**