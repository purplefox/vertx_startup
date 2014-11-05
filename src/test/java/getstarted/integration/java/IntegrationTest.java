package getstarted.integration.java;

import getstarted.Verticle1;
import getstarted.Verticle2;
import org.junit.Test;
import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpClient;
import org.vertx.java.core.http.HttpClientResponse;
import org.vertx.testtools.TestVerticle;
import org.vertx.testtools.VertxAssert;

import static org.vertx.testtools.VertxAssert.assertEquals;
import static org.vertx.testtools.VertxAssert.testComplete;

/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class IntegrationTest extends TestVerticle {


      @Test
      public void testVerticle1() {
        container.deployVerticle("getstarted.Startup", stringAsyncResult -> {
            HttpClient client = vertx.createHttpClient().setHost("localhost").setPort(1234);

            client.getNow("/verticle1", httpClientResponse -> {

                httpClientResponse.dataHandler(data -> {
                    VertxAssert.assertEquals("VERTICLE-1",data.toString());
                    testComplete();
                });

            });
        });

      }

    @Test
    public void testVerticle2() {
        container.deployVerticle("getstarted.Startup", stringAsyncResult -> {
            HttpClient client = vertx.createHttpClient().setHost("localhost").setPort(1234);

            client.getNow("/verticle2", httpClientResponse -> {

                httpClientResponse.dataHandler(data -> {
                    VertxAssert.assertEquals("VERTICLE-2",data.toString());
                    testComplete();
                });

            });
        });

    }

}
