package getstarted;

import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

/**
 * Created by ziemek on 30/10/14.
 */
public class Verticle1 extends Verticle {
    @Override
    public void start() {
        RouteMatcher routeMatcher = new RouteMatcher();
        routeMatcher.get("/test1",
                httpServerRequest -> httpServerRequest.response().end("TEST 1")
        );

        vertx.createHttpServer().requestHandler(routeMatcher).listen(1234);
    }
}
