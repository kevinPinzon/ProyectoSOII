/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploradorarchivos;

import java.io.Serializable;

/**
 *
 * @author xavie
 */
public class NodoArbol implements Serializable{
    private String nombre;
    private int dataServer;
    private char type;
    private String texto;

    public NodoArbol(String nombre, int dataServer, char type) {
        this.nombre = nombre;
        this.dataServer = dataServer;
        this.type = type;
    }
    
    public NodoArbol(String nombre,String texto, int dataServer, char type) {
        this.nombre = nombre;
        this.dataServer = dataServer;
        this.type = type;
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTexto(){
        return texto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    public int getDataServer() {
        return dataServer;
    }

    public void setDataServer(int dataServer) {
        this.dataServer = dataServer;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        if(nombre.equals("root")){
            return nombre;
        }else{
            String temporal[] = nombre.split("/");
            return temporal[temporal.length-1];
        }
    }
    
}
