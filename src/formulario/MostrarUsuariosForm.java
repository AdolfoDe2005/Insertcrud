
package formulario;

import clases.Conexion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


public class MostrarUsuariosForm extends JFrame {

    private JTable usuariosTable; 
    private final Conexion conexion;

    public MostrarUsuariosForm() {
        initComponents();
        conexion = new Conexion(); 
        mostrarUsuarios(); 
    }

    private void initComponents() {
        usuariosTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(usuariosTable);
        scrollPane.setBounds(50, 50, 400, 200);
        add(scrollPane);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLayout(null);
        setVisible(true);
    }

    private void mostrarUsuarios() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Edad");
            model.addColumn("Email");
            model.addColumn("Clave");

            ResultSet rs = conexion.Miusuario();

            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("Nombre"),
                    rs.getString("Edad"),
                    rs.getString("email"),
                    rs.getString("Clave")
                });
            }

            usuariosTable.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los usuarios: " );
        }
    }
}
