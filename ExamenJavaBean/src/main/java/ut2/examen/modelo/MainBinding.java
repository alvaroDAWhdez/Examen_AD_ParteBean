/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut2.examen.modelo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class MainBinding {
    public static void main(String[] args) {
        //Declaramos la ruta del fichero txt
        String rutaFichero = "estado_sistemas.txt";
        List<SistemaCritico> estacionesCriticas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            //Leemos el txt
            while((linea = br.readLine()) != null){
                //Como el archivo esta divido en "," creo un array con cada uno de los elementos usando el split
                String partes[] = linea.split(",");
                if(partes.length == 3){
                    String estado = partes[2].trim();
                    if(estado.equals("Critico")){
                        SistemaCritico sis = new SistemaCritico(partes[0],partes[1]);
                        estacionesCriticas.add(sis);
                        
                    }
                }
            
            }
            
            //Escogemos el peimer elemento de la lista de objetos
           SistemaCritico primerSistema = estacionesCriticas.get(0);
           //Creamos el xml
           File fichero = new File("objetivo_urgente.xml");
           
           try{
            // Instanciamos el contexto pasándole la clase objetivo
            JAXBContext contexto = JAXBContext.newInstance(SistemaCritico.class);
            Marshaller marshaller = contexto.createMarshaller();
            
            // Configuración para que el XML de salida tenga tabulaciones y saltos de línea legibles
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            // Volcamos el objeto directamente al archivo físico
            marshaller.marshal(primerSistema,fichero);
            System.out.println("Archivo objetivo_urgente.xml generado correctamente mediante Binding.");
            
           } catch (Exception e) {
            System.err.println("Error durante el Marshalling: " + e.getMessage());
           }
            
            
            
        } catch (FileNotFoundException e) {
            // Error específico: El archivo no existe
            System.err.println("Error: Transmisión imperial no encontrada.");
            
        } catch (IOException e) {
            // Error genérico: Fallo de hardware, permisos de lectura, etc.
            System.err.println("Fallo general de Entrada/Salida: " + e.getMessage());
            
        }
    }
    
}
