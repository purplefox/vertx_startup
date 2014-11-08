package getstarted;

import org.vertx.java.core.Future;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

/**
 * Created by ziemek on 30/10/14.
 */
public class Verticle1 extends Verticle {

    @Override
    public void start(final Future<Void> startedResult) {
        start();

        RouteMatcher routeMatcher = new RouteMatcher();
        routeMatcher.get("/verticle1",
                httpServerRequest -> {
                    httpServerRequest.response().end("VERTICLE-1");
                }
        );
      routeMatcher.get("/verticle2",
        httpServerRequest -> {
          httpServerRequest.response().end("VERTICLE-2");
        }
      );

        vertx.createHttpServer().requestHandler(routeMatcher).listen(1234, "localhost", startResult -> {
            if (startResult.succeeded()) {
                System.out.println("[HTTP-SERV] [DEPLOY] [SUCESS] in Verticle1 --> " + startResult.result());
                startedResult.setResult(null);
            } else {
                System.out.println("[HTTP-SERV] [DEPLOY] [ERROR] in Verticle1 --> " + startedResult.cause());
                startedResult.setFailure(startResult.cause());
            }
        });

    }

}
