/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.gui;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.BaseForm;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.entities.services.ServiceMenu;
import com.mycompany.myapp.services.ServiceCate;

/**
 *
 * @author Hazem
 */
public class ModifierCate extends BaseForm {

    String Imagecode;
    String filePath = "";
    String Image2 = "";

    public ModifierCate(Resources res, Form previous, Categorie fa) {
        super("Modifier categorie", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Modifier categorie");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);

        tb.addSearchCommand(e -> {
        });
        TextComponent nom = new TextComponent().labelAndHint("nom");
        nom.text(fa.getNom());
        add(nom);

        Button Modifier = new Button("Modifier");
        Button Screen = new Button("Screen");

        Modifier.addActionListener((evt) -> {
            if ((nom.getText().equals(""))) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {

                ServiceCate sf = new ServiceCate();
                fa.setNom(nom.getText());

                //fa.setPrix(Integer.parseInt(prix.getText()));
                // fa.setUser_id((int)Double.parseDouble(user_id.getText()));
                //fa.setReunionid((int)Float.parseFloat(reunionid.getText()));
                sf.Updatecat(fa);
                Dialog.show("Success", "Menu modifiee avec success", new Command("OK"));
                new AllCat(res).show();

            }
        });

        addStringValue("", FlowLayout.encloseRightMiddle(Modifier));

        /////////////////////////////////////   Notification     /////////////////////
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage("Modifier cate de  :" + fa.getId());
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
