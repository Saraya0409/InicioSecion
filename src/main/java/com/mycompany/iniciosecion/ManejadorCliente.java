/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosecion;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author yagoa
 */
public class ManejadorCliente extends Thread {
    private Socket socketCliente;
    private UserManager manejador;

    public ManejadorCliente(Socket socketCliente, UserManager manejador) {
        this.socketCliente = socketCliente;
        this.manejador = manejador;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);

            String[] userData = in.readLine().split(":");
            String username = userData[0];
            String password = userData[1];

            String response = manejador.login(username, password);
            out.println(response);

            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  

