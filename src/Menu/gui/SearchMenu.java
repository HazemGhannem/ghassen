/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.BaseForm;
import com.mycompany.gui.NewsfeedForm;
import com.mycompany.gui.WalkthruForm;
import com.mycompany.myapp.entities.Menu;
import com.mycompany.myapp.entities.services.ServiceMenu;
import com.mycompany.myapp.gui.ProfileForm;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MSI GAMMING
 */
public class SearchMenu extends BaseForm {

    Form current;

    public SearchMenu(Resources res) {
        setTitle("Liste des Menus");

        Container co;
        //search
        Toolbar.setGlobalToolbar(true);
        add(new InfiniteProgress());

        Display.getInstance().scheduleBackgroundTask(() -> {
            // this will take a while...
            Display.getInstance().callSerially(() -> {
                removeAll();
                ArrayList<Menu> p = new ArrayList();
                ServiceMenu sa = new ServiceMenu();
                p = sa.affichageMenus();
                for (Menu f : p) {
                    MultiButton m = new MultiButton();

                    m.setTextLine1(" Descp : " + f.getDescp());

                    add(m);
                }
                revalidate();
            });
        });

        getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                getContentPane().animateLayout(150);
            }
        }, 4);

        //Tool Bar
        getToolbar().addCommandToSideMenu("Newsfeed", null, e -> new NewsfeedForm(res).show());
        getToolbar().addCommandToSideMenu("Menu", null, e -> new AllMenu(res).show());

        getToolbar().addCommandToSideMenu("Profile", null, e -> new ProfileForm(res).show());

    }
}
