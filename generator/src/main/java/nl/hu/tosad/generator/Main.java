package nl.hu.tosad.generator;

import nl.hu.tosad.generator.rule.communication.ConnectionController;
import nl.hu.tosad.generator.rule.communication.ConnectionControllerInterface;

import java.io.IOException;

public class Main {
    public static final int PORT_DRY = 8084;
    public static final int PORT_WET = 8085;


    public static void main(String[] args) throws IOException {
        ConnectionControllerInterface connectionController = new ConnectionController();
        connectionController.runController();
    }
}
