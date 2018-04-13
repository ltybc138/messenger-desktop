package utils;

import utils.logging.ConsoleLogger;
import utils.logging.LogType;
import utils.logging.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnector {
    public static volatile ServerConnector instance;

    // url of the main server
    private String mainUrl;
    private String USER_AGENT;
    private Logger logger;

    // initializing all private variables
    private ServerConnector() {
        mainUrl = "http://localhost:8080";
        USER_AGENT = "Mozilla/5.0";
        logger = ConsoleLogger.getInstance();
    }

    public static ServerConnector getInstance() {
        ServerConnector localInstance = instance;
        if (localInstance == null) {
            synchronized (ServerConnector.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ServerConnector();
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
            URL url = new URL(mainUrl + "/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // add request header
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", USER_AGENT);

            String urlParams = "login=" + login + "&" +
                    "password=" + password;
            // send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(urlParams);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            logger.log("\n\tSending 'POST' request to URL : " + mainUrl +
                    "\n\tPost params : " + urlParams +
                    "\n\tResponse code : " + responseCode, LogType.INFO);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            logger.log("\n\tResponse : " + response.toString(), LogType.INFO);

            if (codeTranslate(responseCode)) {
                return true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
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
