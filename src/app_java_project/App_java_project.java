/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app_java_project;

/**
 *
 * @author yabet
 */
public class App_java_project {

    public static void main(String[] args) {
import javax.swing.JOptionPane;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionDeAccesos {
    private static final String HISTORIAL_FILE = "Historial.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Registrar Acceso", "Consultar por Filial", "Consultar por Fecha", "Consultar por Código o Placa", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestión de Accesos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> registrarAcceso();
                case 1 -> consultarPorFilial();
                case 2 -> consultarPorFecha();
                case 3 -> consultarPorCodigoOPlaca();
                case 4 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
 private static void registrarAcceso() {
        String codigo = JOptionPane.showInputDialog("Ingrese el código:");
        String placa = JOptionPane.showInputDialog("Ingrese la placa:");
        String filial = JOptionPane.showInputDialog("Ingrese la filial:");
        String condicion = JOptionPane.showInputDialog("Ingrese la condición (Aceptado o Denegado):");

        String fecha = DATE_FORMAT.format(new Date());
        String registro = String.format("Codigo: %s; Placa: %s; Filial: %s; Condición: %s; Fecha: %s", codigo, placa, filial, condicion, fecha);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORIAL_FILE, true))) {
            writer.write(registro);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Acceso registrado exitosamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo.");
        }
    }

   
