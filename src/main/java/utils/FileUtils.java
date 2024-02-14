package utils;

import dtos.ToyDto;
import model.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public  class FileUtils {

    public static void saveContacts(File file, List<ToyDto> lista) {

        try {
            FileOutputStream ficheroSalida = new FileOutputStream(file);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(lista);
            objetoSalida.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Toy> getContacts(File file) {

        List<Toy> lista = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (List<Toy>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }




}