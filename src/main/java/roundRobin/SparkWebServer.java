package roundRobin;

import static spark.Spark.*;

public class SparkWebServer {

        public static void main(String... args){
            port(getPort());
            staticFileLocation("/public");
            HttpClient httpClient = new HttpClient();
            get("/", (req,res) -> {
                res.redirect("index.html");
                return null;
            });

            get("/answers", (req,res) -> {
                res.status(200);
                res.type("application/json");
                String resp = httpClient.getMessage();
                httpClient.changeNumberServer();
                return resp;
            });
        }

        private static int getPort() {
            if (System.getenv("PORT") != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567;
        }

    }

