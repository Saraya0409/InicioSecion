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
public class Cliente {

    private static final String ip = "127.0.0.1"; // Cambiar a la dirección del servidor
    private static final int puerto = 5432;

    public String login(String username, String password) {
        try (Socket socket = new Socket(ip, puerto); PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Envía datos de usuario al servidor
            salida.println(username + ":" + password);
            // Espera la respuesta del servidor
            String response = entrada.readLine();

            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error de conexión";
        }
    }

    public static void main(String[] args) {
        MenuInicioSecion menu = new MenuInicioSecion();
        menu.setVisible(true);
    }
}
