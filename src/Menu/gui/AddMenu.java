/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.gui;

import com.codename1.components.ToastBar;
import com.codename1.l10n.DateFormatPatterns;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.BaseForm;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.entities.services.ServiceMenu;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MSI GAMMING
 */
public class AddMenu extends BaseForm {

    String Imagecode;
    String filePath = "";

    public AddMenu(Resources res, Form previous) {
        super("Ajouter Menu", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajouter Menu");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        tb.addSearchCommand(e -> {
        });
        Menu fa = new Menu();

        TextComponent nom = new TextComponent().labelAndHint("nom");
        add(nom);

        TextComponent descp = new TextComponent().labelAndHint("descp");
        add(descp);

        TextComponent image = new TextComponent().labelAndHint("image");
        add(image);

        TextComponent prix = new TextComponent().labelAndHint("prix");
        add(prix);

        Button Ajouter = new Button("Ajouter");

        Ajouter.addActionListener((evt) -> {
            if (nom.getText().equals("") || (descp.getText().equals("")) || (image.getText().equals("")) || (prix.getText().equals(""))) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {

                ServiceMenu sf = new ServiceMenu();
                fa.setNom(nom.getText());
                fa.setDescp(descp.getText());
                fa.setImage(image.getText());
                fa.setPrix(Integer.parseInt(prix.getText()));

                sf.ajoutMenu(fa);
                Dialog.show("Success", "Menu ajoute avec success", new Command("OK"));
                new AllMenu(res).show();

            }
        });

        addStringValue("", FlowLayout.encloseRightMiddle(Ajouter));

        /////////////////////////////////////   Notification     /////////////////////
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Ajouter Nouvelle Menu ");
        status.setExpires(4000);  // only show the status for 3 seconds, then have it automatically clear
        status.show();
        System.out.println("Hallo");
///////////////////////////////////////////

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));

    }

}
