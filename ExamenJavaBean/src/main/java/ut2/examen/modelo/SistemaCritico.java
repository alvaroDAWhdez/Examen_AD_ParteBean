/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut2.examen.modelo;

import jakarta.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 *
 * @author Alvaro
 */
//Definir el elemento raiz de xml
@XmlRootElement(name="sistema")
public class SistemaCritico implements Serializable {
    
    private String objetivo; //atributo
    private String componente; //etiqueta hija
    
    //Constructor vacio obligatorio para el estándar JavaBean y JAXB
    public SistemaCritico(){       
    }

    public SistemaCritico(String objetivo, String componente) {
        this.objetivo = objetivo;
        this.componente = componente;
    }
    
    // Anotamos los getters para transformarlos en elementos/etiquetas XML
    @XmlAttribute(name = "objetivo")
    public String getObjetivo() {
        return objetivo;
    }
    @XmlElement(name = "componente")
    public String getComponente() {
        return componente;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    @Override
    public String toString() {
        return "SistemaCritico{" + "objetivo=" + objetivo + ", componente=" + componente + '}';
    }
    
    
    
    
}
