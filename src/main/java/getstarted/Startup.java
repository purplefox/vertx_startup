package getstarted;

import org.vertx.java.platform.Verticle;

/**
 * Created by ziemek on 30/10/14.
 */
public class Startup extends Verticle {

  public void start() {

      container.deployVerticle("getstarted.Verticle1", deployResult -> {
          if (deployResult.succeeded()) {
              System.out.println("success 1");
          } else {
              System.out.println("error 1: " + deployResult.cause());
          }
      });

      container.deployVerticle("getstarted.Verticle2",deployResult -> {
          if (deployResult.succeeded()) {
              System.out.println("success 2");
          } else {
              System.out.println("error 2" + deployResult.cause());
          }
      });

  }
}
