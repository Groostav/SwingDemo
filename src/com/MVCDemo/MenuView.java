package com.MVCDemo;

import javax.swing.*;
import java.awt.*;

import static com.MVCDemo.DisplayValues.*;

/**
 * @author Geoff on 14/05/13
 */
public class MenuView extends JMenuBar {
    public MenuView(){
        super();

        JMenu file = new JMenu(FileMenuTitle){{
            add(new JMenuItem(FirstMenuOptionText));
            add(new JMenuItem(SecondMenuOptionText));
            add(new JMenuItem(ThirdMenuOptionText));
        }};

        JMenu edit = new JMenu(EditMenuTitle){{
            add(new JMenuItem(FirstMenuOptionText));
            add(new JMenuItem(SecondMenuOptionText));
            add(new JMenuItem(ThirdMenuOptionText));
        }};

        JMenu export = new JMenu(ExportMenuTitle){{
            add(new JMenuItem(ExportCSVMenuOptionText));
            add(new JMenuItem(ExportXMLMenuOptionText));
        }};

        setPreferredSize(MenuBarSize);
        setLocation(MenuLocation);
        setBackground(Color.LIGHT_GRAY);
        add(file);
        add(edit);
        add(export);
    }
}
