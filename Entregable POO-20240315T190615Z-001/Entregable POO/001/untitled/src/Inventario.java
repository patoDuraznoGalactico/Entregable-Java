import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Inventario {

    private int index = 1;
    private ArrayList<ProductoEspecifico> productos = new ArrayList<>();

    public void añadirProductos(){
        try {
            String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre del producto: ");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el precio del producto: "));
            String categoria = JOptionPane.showInputDialog("Por favor ingrese la categoria del producto: ");
            String marca = JOptionPane.showInputDialog("Por favor ingrese la marca del producto: ");


            ProductoEspecifico productoEsp = new ProductoEspecifico(index,nombre,precio,categoria,marca);
            System.out.println(productoEsp.toString());
            index++;
            this.productos.add(productoEsp);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo agregar el producto, por favor añada valores validos");

        }

    }

    public void eliminar(){
        int idEliminar;
        if (productos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay productos para eliminar");
        }else{
            this.listarProductos();
            String id = JOptionPane.showInputDialog("Ingrese el id del producto que desa eliminar: ");

            if (id != null){
                idEliminar = Integer.parseInt(id);
                this.productos.removeIf(producto-> producto.getId() == idEliminar);
                JOptionPane.showMessageDialog(null , "Producto eliminado correctamente");
            }
        }
    }

    public void listarProductos(){
        if (productos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay productos");
        }else{
            String text= "";
            System.out.println("p");
            for (ProductoEspecifico producto: this.productos){
                text += (producto.toString()+"\n");
                System.out.println(producto.toString());
            }
            System.out.println(text);
            JOptionPane.showMessageDialog(null,text);

        }
    }
    public void buscar(){
        if (productos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay productos pa buscar");
        }else{
            int option;
            do {
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                Buscar productos
                
                1. Buscar por id.
                2. Buscar por categoria.              
                3. Salir.
                """));

                switch (option){
                    case 1:
                        String idBuscar = JOptionPane.showInputDialog("Ingrese el id del producto que desea buscar: ");
                        for (ProductoEspecifico p: this.productos){
                            if(p.getId() == Integer.parseInt(idBuscar)){
                                JOptionPane.showMessageDialog(null,p.toString()
                                );
                            }
                        }
                        break;
                    case 2:

                        String claseBuscar = JOptionPane.showInputDialog("Ingrese la categoria que desea buscar: ");
                        String text= "";
                        for (ProductoEspecifico c: this.productos){
                            System.out.println(claseBuscar + c.getCategoria());
                            if (c.getCategoria().equals(claseBuscar)){
                                text += (c.toString()+"\n");
                                System.out.println(c.toString());
                            }
                        }
                        if (text ==""){
                            JOptionPane.showMessageDialog(null,"categoria no existente");
                        }else{
                            JOptionPane.showMessageDialog(null,text);
                        }
                }
            }while (option != 3);



        }
    }
}
