package vistas;

import clases.ClienteDAO;
import clases.DetalleDAO;
import clases.DetallePedido;
import clases.GPedido;
import clases.PedidoDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarPedido extends javax.swing.JPanel {
    PedidoDAO dto;
    DetalleDAO det;
    DefaultTableModel dt;
    int fila;
    public ConsultarPedido() {
        initComponents();
        dto = new PedidoDAO();
        det= new DetalleDAO();
    }
    void muestra3(){
        DefaultTableModel dt = (DefaultTableModel) tbPedidos.getModel();
   
        dt.setRowCount(0);
        for(GPedido x:dto.LisPed(txtDni.getText())){
            Object v[]={x.getCodp(),x.getFechar(),x.getFechae(),x.getEstado()};
            dt.addRow(v);
        } 
          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultarPedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbArticulos = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPedidos = new javax.swing.JTable();
        btnEntregado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnEnCurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 580));

        btnConsultarPedido.setBackground(new java.awt.Color(0, 191, 197));
        btnConsultarPedido.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnConsultarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultarPedido.setText("Consultar pedidos");
        btnConsultarPedido.setToolTipText("");
        btnConsultarPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 191, 197)));
        btnConsultarPedido.setOpaque(true);
        btnConsultarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarPedidoMouseClicked(evt);
            }
        });

        tbArticulos.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        tbArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código artículo", "Descripción", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbArticulos.setSelectionBackground(new java.awt.Color(0, 191, 197));
        jScrollPane1.setViewportView(tbArticulos);

        txtDni.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

        tbPedidos.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        tbPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Pedido", "Fecha de Recepción", "Fecha de Entrega", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPedidos.setInheritsPopupMenu(true);
        tbPedidos.setSelectionBackground(new java.awt.Color(0, 191, 197));
        tbPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPedidos);

        btnEntregado.setBackground(new java.awt.Color(220, 220, 220));
        btnEntregado.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnEntregado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntregado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entregado.png"))); // NOI18N
        btnEntregado.setToolTipText("");
        btnEntregado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntregadoMouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(150, 150, 150));
        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DNI cliente");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        jLabel4.setOpaque(true);

        btnEnCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEnCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/en_proceso.png"))); // NOI18N
        btnEnCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnCursoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(150, 150, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/articulos_pedido.png"))); // NOI18N
        jLabel1.setText("Artículos del pedido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEntregado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEnCurso))))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnCurso)
                    .addComponent(btnEntregado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarPedidoMouseClicked
        ClienteDAO cdao=new ClienteDAO();
        cdao.setDni(Integer.parseInt(txtDni.getText()));
        if(cdao.BuscarCliente()==1){
            muestra3();
        }
    }//GEN-LAST:event_btnConsultarPedidoMouseClicked

    private void tbPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPedidosMouseClicked
        int f= tbPedidos.getSelectedRow();
        dt=(DefaultTableModel)tbArticulos.getModel();
        dt.setRowCount(0);
 
        for (DetallePedido x:det.LisArtxPed(tbPedidos.getValueAt(f,0).toString())) {
            Object v[]={x.getCoda(),x.getDescripcion(),x.getCantidad(),x.getPrecio()};
            dt.addRow(v);  
        }
    }//GEN-LAST:event_tbPedidosMouseClicked

    private void btnEntregadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntregadoMouseClicked
        fila=tbPedidos.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Elija una fila.");
        }else{
            dt=(DefaultTableModel) tbPedidos.getModel();
            dto.CambiarEstadoEnt(String.valueOf(dt.getValueAt(tbPedidos.getSelectedRow(), 0)));
            muestra3();
        }  
    }//GEN-LAST:event_btnEntregadoMouseClicked

    private void btnEnCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnCursoMouseClicked
        fila=tbPedidos.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Elija una fila.");
        }else{
            dt=(DefaultTableModel) tbPedidos.getModel();
            dto.CambiarEstadoEnc(String.valueOf(dt.getValueAt(tbPedidos.getSelectedRow(), 0)));
            muestra3();
        }
    }//GEN-LAST:event_btnEnCursoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnConsultarPedido;
    private javax.swing.JLabel btnEnCurso;
    private javax.swing.JLabel btnEntregado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbArticulos;
    private javax.swing.JTable tbPedidos;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
