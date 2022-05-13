/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.mycompany.gui.BaseForm;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.entities.services.ServiceMenu;
import java.util.ArrayList;

/**
 *
 * @author MSI GAMMING
 */
public class PDF extends BaseForm {

    public PDF(Resources res) {
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setTitle("Liste des menus");
        getContentPane().setScrollVisible(true);
        super.addSideMenu(res);

       
   

        //this.theme=theme;
        SpanLabel sp = new SpanLabel();

        sp.setText(ServiceMenu.getInstance().affichageMenus().toString());
        add(sp);
        //// f twig 
        Button pdf = new Button("pdf");
        add(pdf);
        pdf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {


                    String path = "";
                    Document document = new Document();
                    try {

                    //    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + "reclamation.pdf"));

                        document.open();
                        PdfPTable tb1 = new PdfPTable(10);
                        tb1.addCell("DateRecalamtion");
                        tb1.addCell("EmailReclamation");
                        tb1.addCell("DescriptionReclamation");

                        //tb1.addCell("img");
                        tb1.addCell("EtatReclamation");
                        tb1.addCell("nomuser");

                        ServiceMenu es = new ServiceMenu();
                        ArrayList < Menu> list = es.affichageMenus();
                        for ( Menu m : list) {

                            String nom = String.valueOf(m.getNom());
                            String descp = String.valueOf(m.getDescp());
                            String image = String.valueOf(m.getImage());

                            String prix = String.valueOf(m.getPrix());
                          

                            tb1.addCell(nom);
                            tb1.addCell(descp);
                            tb1.addCell(image);
                            //tb1.addCell(image);
                            tb1.addCell(prix);
                        

                        }
                        document.add(new Paragraph("Menu"));

                        document.add(tb1);
                        document.close();
         //writer.close();
                        com.codename1.io.File file = new com.codename1.io.File("menu.pdf");
                        new AllMenu(res).show();

 //   desktop.open(file);
                    } 
                    catch (Exception e){
                        e.printStackTrace();
                    
                  
                   
      
              }}
                    //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);

                    //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);
                    //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

             


        });}
    
}
