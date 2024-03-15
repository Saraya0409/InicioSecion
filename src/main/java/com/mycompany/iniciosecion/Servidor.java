/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosecion;

import java.net.Socket;
import java.io.*;
import java.net.ServerSocket;

/**
 *
 * @author yagoa
 */
public class Servidor {

    private static final int puerto = 5432;
    private static final UserManager manejadorU = new UserManager();

    public static void iniciarServidor() {
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando clientes...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado desde: " + clientSocket.getInetAddress());
                ManejadorCliente manejadorC = new ManejadorCliente(clientSocket, manejadorU);
                manejadorC.start(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        iniciarServidor();
    }
}
