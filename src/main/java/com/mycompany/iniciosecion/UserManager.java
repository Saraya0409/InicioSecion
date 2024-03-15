/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosecion;

import java.io.*;

/**
 *
 * @author yagoa
 */
public class UserManager {

    private static final String baseDatos = "D:/ClienteServidor/InicioSecion/usuarios.txt";

    public synchronized String login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(baseDatos))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return "Inicio de sesión exitoso para " + username;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Error: Archivo de usuarios no encontrado";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Ocurrió un error al leer el archivo de usuarios";
        }
        return "Error: Usuario o contraseña incorrectos";
    }
}
