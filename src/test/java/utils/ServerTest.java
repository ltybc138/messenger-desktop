package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void login() {
        Server server = Server.getInstance();
        assertTrue(server.login("admn", "pass"));
    }
}