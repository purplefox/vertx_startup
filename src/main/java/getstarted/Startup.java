package getstarted;

import org.vertx.java.platform.Verticle;

/**
 * Created by ziemek on 30/10/14.
 */
public class Startup extends Verticle {

  public void start() {
      container.deployVerticle("Verticle1.java");
      container.deployVerticle("Verticle2.java");
  }
}
