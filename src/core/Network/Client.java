package core.Network;

import core.Program;
import core.addressBook.Register;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Logger;

public class Client implements Runnable {

    private Logger logger = Logger.getLogger(Program.class.getName());
    private Register register;
    private int portNumber;

    public Client(Register register, int portNumber) {
        this.register = register;
        this.portNumber = portNumber;
    }

    public void connect() {
        try {
            Socket socket = new Socket("192.168.0.20", portNumber);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            writer.println("getall");
            writer.flush();
            logger.info("Client sending \"getall\" command to server.");

            for (String line = reader.readLine(); !(line.equals("")); line = reader.readLine()) {
                String[] splitLine = line.split(" ");
                if (splitLine.length > 1) {
                    register.addServerContact(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
                }
            }
            logger.info("Adding contacts from server to the local Register.");

            writer.println("exit");
            writer.flush();
            logger.info("Client sending \"exit\" command to server.");

            reader.close();
            writer.close();
            socket.close();


        } catch (SocketException e) {
            logger.severe("The socket " + portNumber + " could not be reached." + " " + e);
            System.out.println("The socket " + portNumber + " could not be reached.");
        } catch (IOException e) {
            logger.severe("An error occurred with the input- or outputstream. " + " " + e);
            System.out.println("An error occured when trying to run the client.");
        }
    }


    @Override
    public void run() {
        connect();
    }
}