/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordendecorreoscess;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrdenDeCorreosCESS {

    public static void main(String[] args) throws IOException {
        ArrayList<String> alumnos = leerDatosCSV();
        alumnos = convertirDatos(alumnos);
        formatoBaseDatos(alumnos);
    }
    public static ArrayList<String> leerDatosCSV(){
        String csvFile = ".\\registroNuebo.csv";
        BufferedReader br = null;
        String line = "";
        
        ArrayList<String> alumnos = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                alumnos.add(line);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return alumnos;
    }
    public static ArrayList<String> convertirDatos(ArrayList<String> alumnos){
        for (int i=0; i<alumnos.size(); i++ ){
            String[] alum = alumnos.get(i).split(",");
            //NOMBRE
            String nombre;
            if(alum[1].contains(" ")){
                String[] arrayAlum;
                arrayAlum = alum[1].split(" ");
                nombre=arrayAlum[0];
            }else{
                nombre=alum[1];
            }
            //APELLIDO
            String apellido;
            if(alum[2].contains(" ")){
                String[] arrayAlum;
                arrayAlum = alum[2].split(" ");
                apellido=arrayAlum[0];
            }else{
                apellido=alum[2];
            }
            alumnos.set(i,alumnos.get(i)+","+nombre+"."+apellido+"@cess.edu.mx");
            
            System.out.println(alumnos.get(i));
        }
        return alumnos;
    }
    public static void formatoGoogle(){
        
    }
    public static void formatoMoodle(){
        
    }
    public static void formatoBaseDatos(ArrayList<String> nombres) throws IOException{
        int numLinesBaseDatos = numLinesBaseDatos();
        String csvFile = ".\\baseDatos.csv";
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(csvFile,true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for(int i= numLinesBaseDatos; i< nombres.size();i++){
                bfwriter.write(nombres.get(i)+"\n");
            }
            bfwriter.close();
        } catch (IOException e) {
                System.out.println("Unable to write");
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();//Cierra el archivo
                } catch (IOException e) {
                    System.out.println("Unable to close");
                }
            }
        }
    }
    public static int numLinesBaseDatos(){
        String csvFile = ".\\baseDatos.csv";
        BufferedReader br = null;
        String line = "";
        int numLines=0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                numLines++;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return numLines;
    }
}