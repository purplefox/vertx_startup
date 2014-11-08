package getstarted;

import org.vertx.java.core.Future;
import org.vertx.java.platform.Verticle;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ziemek on 30/10/14.
 */
public class Startup extends Verticle {
    @Override
    public void start(final Future<Void> startedResult) {

      AtomicInteger count = new AtomicInteger();

        container.deployVerticle("getstarted.Verticle1", deployResult -> {
            if (deployResult.succeeded()) {
                System.out.println("[VERTICLE-DEPLOY] [SUCCESS] Verticle1 --> " + deployResult.result());
                if (count.incrementAndGet() == 2) {
                  startedResult.setResult(null);
                }
            } else {
                System.out.println("[VERTICLE-DEPLOY] [ERROR] Verticle1 --> " + deployResult.cause());
                startedResult.setFailure(deployResult.cause());
            }
        });

        container.deployVerticle("getstarted.Verticle2",deployResult -> {
            if (deployResult.succeeded()) {
                System.out.println("[VERTICLE-DEPLOY] [SUCCESS] Verticle2 --> " + deployResult.result());
                if (count.incrementAndGet() == 2) {
                  startedResult.setResult(null);
                }
            } else {
                System.out.println("[VERRICLE-DEPLOY] [ERROR] Verticle2 --> " + deployResult.cause());
                startedResult.setFailure(deployResult.cause());
            }
        });

    }

}
