package it.Itsrizzoli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class ClientHandler {
    Socket clientSocket;
    ParkingManager parkingManager;
    public ClientHandler(Socket clientSocket, ParkingManager parkingManager) {

        this.clientSocket = clientSocket;
        this.parkingManager = parkingManager;
    }

    void handle(){
        BufferedReader in;
        in = getBufferedReader();
        PrintWriter out = null;
        out = getPrintWriter(out);
        readerLoop(in, out);

    }
    private BufferedReader getBufferedReader() {
        BufferedReader in;
        try {
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return in;
    }
    private PrintWriter getPrintWriter(PrintWriter out) {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    public ClientHandler() {
    }

    private void readerLoop(BufferedReader in, PrintWriter out) {
        String s = "";
        try {
            while ((s = in.readLine()) != null) {
                //System.out.println(s);
                parse(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String parse (String s) {
        String[] parts = s.split("-");
        if (parts.length < 2) {
            return "paramentri insufficienti";
        }
        String cmd = parts[0];
        String plate = parts[1];
        switch (cmd.toLowerCase()) {
            case "park":
                    return park(plate);
            case "whereis":
                break;
            case "pay":
                break;
            default:  return "comando non riconuscuto";
        }
        return "comando non riconuscuto";
    }

    String park(String plate) {
        Pad pad = parkingManager.findFreePad(plate);
        return "non ce posto";
    }
    /*private Ticket getTicket(String s){
        Gson gson = new Gson();
        try{
            Ticket ticket = gson.fromJson(s, Ticket. class);
            System.out.println(ticket);
            if(ticket.plate == null){
                return  null;
            }
            return ticket;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    private String getPlate(String s){
        Gson gson = new Gson();
        try{
            FindCmd findCmd = gson.fromJson(s, FindCmd. class);
            Ticket ticket = parkingManager.findPlate(findCmd.plateToFind);
            if (ticket == null){
                return null;
            }
            return ticket.plate;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }*/
}