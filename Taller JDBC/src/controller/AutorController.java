package controller;

import entity.Autor;
import model.AutorModel;

import javax.swing.*;

public class AutorController {
    public static void create(){
        AutorModel objAutorModel = new AutorModel();

        String nombre = JOptionPane.showInputDialog(null,"Insert name:");
        String nacionalidad = JOptionPane.showInputDialog(null,"Insert nationality:");

        Autor objAutor = new Autor();
        objAutor.setNombre(nombre);
        objAutor.setNacionalidad(nacionalidad);

        objAutor= (Autor) objAutorModel.insert(objAutor);

        JOptionPane.showMessageDialog(null, objAutor.toString());
    }
}
