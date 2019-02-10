package com.xenosnowfox.amazonaws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.xenosnowfox.amazonaws.lambda.http.ResponseStatus;
import com.xenosnowfox.amazonaws.lambda.request.parser.ApiGatewayRequestParser;
import com.xenosnowfox.amazonaws.lambda.request.MutableRequest;
import com.xenosnowfox.amazonaws.lambda.response.StringResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Implementation wrapper of the AWS request stream.
 * This class can be extended to provide your specific implementation.
 * Note: this class is NOT thread-safe.
 *
 * <pre><code>
 *     package com.example.myhandler;
 *
 *     import com.xenosnowfox.amazonaws.lambda.*;
 *
 *     public class MyHandler extends AbstractLambdaHandler {
 *         public Response handle(final Request request) {
 *              return null;
 *         }
 *     }
 * </code></pre>
 *
 */
public abstract class AbstractLambdaHandler implements RequestStreamHandler, LambdaHandler {

    /**
     * Stores the Context information.
     */
    private Context context;

    /**
     * Obtains the current Lambda Context provided by Amazon AWS.
     *
     * @return
     *      Amazon AWS's Lambda Context object
     */
    public final Context getLambdaContext() {
        return this.context;
    }

    /**
     * {@inheritDoc}
     */
    public final void handleRequest(final InputStream inputStream, final OutputStream outputStream, final Context context) throws IOException {

        // store the context for this request
        this.context = context;

        // parse the input stream
        MutableRequest request = ApiGatewayRequestParser.parse(inputStream);

        // Invoke the request and obtain a response
        Response response;
        try {
            response = this.handle(request);

            if (response == null) {
                throw new NullPointerException("No Response object returned from request");
            }
        } catch (Exception e) {
            // generate an error response
            response = new StringResponse();
            response.setResponseStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
            response.setBody(ResponseStatus.INTERNAL_SERVER_ERROR.getDescription());

            // build a new log message
            StringBuilder logMessage = new StringBuilder();
            logMessage.append("Exception Occurred\r\n==================");
            logMessage.append("Class: \r\n\t");
            logMessage.append(e.getClass().getName());
            logMessage.append("\r\n\r\n");
            logMessage.append("Exception: \r\n\t");
            logMessage.append(e.getMessage());
            logMessage.append("\r\n\r\n");
            logMessage.append("Stacktrace: \r\n\t");
            for (StackTraceElement ste : e.getStackTrace()) {
                logMessage.append(ste.toString());
                logMessage.append("\r\n\t");
            }
            logMessage.append("\r\n");
            logMessage.append("Request: \r\n");
            logMessage.append(request.toJsonObject().toString());

            // log the error
            context.getLogger().log(logMessage.toString());
        }

        // clear the context
        this.context = null;

        // write the response back to the client
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(response.toJsonString());
        writer.close();
    }
}

