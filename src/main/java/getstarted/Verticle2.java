package getstarted;

import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.AsyncResultHandler;
import org.vertx.java.core.Future;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;
/**
 * Created by ziemek on 30/10/14.
 */
public class Verticle2 extends Verticle {

    @Override
    public void start(Future<Void> startedResult) {

        RouteMatcher routeMatcher = new RouteMatcher();
        routeMatcher.get("/verticle2",
                httpServerRequest -> {
                    httpServerRequest.response().end("VERTICLE-2");
                }
        );

        startedResult.setHandler(voidAsyncResult -> {
            vertx.createHttpServer().requestHandler(routeMatcher).listen(1234, "localhost", startResult -> {
                if (startResult.succeeded()) {
                    System.out.println("started server started in Verticle2: " + startResult.result());
                    startedResult.setResult(null);
                } else {
                    System.out.println("error server started in Verticle2:" + startedResult.cause());
                    startedResult.setFailure(startResult.cause());
                }
            });
        });
    }

}
