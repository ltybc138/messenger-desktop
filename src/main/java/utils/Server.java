package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {
    private static Logger logger = LogManager.getLogger(Server.class);
    public static volatile Server instance;

    // url of the main server
    private String mainUrl;
    private String USER_AGENT;

    // initializing all private variables
    private Server() {
        mainUrl = "http://localhost:8080";
        USER_AGENT = "Mozilla/5.0";
        logger.info("Connector has been initialized");
    }

    public static Server getInstance() {
        Server localInstance = instance;
        if (localInstance == null) {
            synchronized (Server.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Server();
                }
            }
        }
        return localInstance;
    }

    /**
     * method for logging into the system in the server
     * @param login user's login
     * @param password user's password
     */
    public boolean login(String login, String password) {
        try {
            logger.info("Connecting to the server...");
            URL url = new URL(mainUrl + "/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            logger.info("Successfully connected");

            // add request header
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            String urlParams = "login=" + login + "&" +
                    "password=" + password;
            // send post request
            logger.info("Sending data to the server...");
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParams);
            wr.flush();
            wr.close();
            logger.info("Successfully sent");

            int responseCode = connection.getResponseCode();
            logger.info("\n\tSending 'POST' request to URL : " + mainUrl +
                    "\n\tPost params : " + urlParams +
                    "\n\tResponse code : ");

            logger.info("Reading response from the server");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            logger.info("Response has been read");

            logger.info("\n\tResponse : " + response.toString());

            if (codeTranslate(responseCode)) {
                return true;
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return false;
    }

    // method for translating response codes
    private boolean codeTranslate(int code) {
        if (code % 100 == 2) {
            return true;
        }
        return false;
    }
}
