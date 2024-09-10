
package clases;

import formulario.Crud;
import formulario.Elcrud;
import formulario.MostrarUsuariosForm;
import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    JButton btnCrud1, btnCrud2, btnCrud3;

    public MenuPrincipal() {
      
        setTitle("Selecciona un CRUD");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
           btnCrud3 = new JButton("Ver Usuarios");
        btnCrud3.setBounds(88, 50, 200, 30);
        add(btnCrud3);
        
      
        btnCrud1 = new JButton("RG Y AC");
        btnCrud1.setBounds(88, 100, 200, 30);
        add(btnCrud1);

   
        btnCrud2 = new JButton("Eliminar");
        btnCrud2.setBounds(88, 150, 200, 30);
        add(btnCrud2);
        
        
          btnCrud3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                new MostrarUsuariosForm ().setVisible(true); 
                dispose(); 
            }
        });


        btnCrud1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                new Crud().setVisible(true); 
                dispose(); 
            }
        });

    
        btnCrud2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                new Elcrud().setVisible(true); 
                dispose(); 
            }
        });

       
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
