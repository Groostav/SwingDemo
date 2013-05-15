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
        setLocation(new Point(0,0));

        final JMenu file = new JMenu(FileMenuTitle){{
            add(new JMenuItem(FirstMenuOptionText));
            add(new JMenuItem(SecondMenuOptionText));
            add(new JMenuItem(ThirdMenuOptionText));
        }};

        final JMenu edit = new JMenu(EditMenuTitle){{
            add(new JMenuItem(FirstMenuOptionText));
            add(new JMenuItem(SecondMenuOptionText));
            add(new JMenuItem(ThirdMenuOptionText));
        }};

        final JMenu export = new JMenu(ExportMenuTitle){{
            add(new JMenuItem(ExportCSVMenuOptionText));
            add(new JMenuItem(ExportXMLMenuOptionText));
        }};

        JMenuBar menuBar = new JMenuBar(){{
            setPreferredSize(MenuBarSize);
            setBackground(Color.LIGHT_GRAY);
            add(file);
            add(edit);
            add(export);
        }};

        this.add(menuBar);
    }
}
