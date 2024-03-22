package controller;

import entity.Autor;
import model.AutorModel;

import javax.swing.*;
import java.util.List;

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
    public static void getAll(){
        AutorModel objModel = new AutorModel();
        String listAutor = "Lista de Autores: \n";
        for (Object i: objModel.findAll()){
            //Convertir el objeto a Autor.
            Autor objAutor = (Autor) i;
            listAutor += objAutor.toString()+ "\n";
        }
        JOptionPane.showMessageDialog(null, listAutor);
    }

    public static void searchById(){
        AutorModel objAutorModel = new AutorModel();
        int idSearch = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id del autor: "));
        Autor objAutor = objAutorModel.findById(idSearch);
        JOptionPane.showMessageDialog(null,objAutor.toString());
    }
}
