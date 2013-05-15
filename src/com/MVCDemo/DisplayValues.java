package com.MVCDemo;

import java.awt.*;
/**
 * @author Geoff on 14/05/13
 */
public class DisplayValues {
    public static final String ApplicationTitle = "MVC Demo Application";
    public static final String FirstMenuOptionText = "First Option";
    public static final String FileMenuTitle = "File";
    public static final String EditMenuTitle = "Edit";
    public static final String SecondMenuOptionText = "Second Option";
    public static final String ThirdMenuOptionText = "Third Option";
    public static final String ExportMenuTitle = "Export";
    public static final String ExportCSVMenuOptionText = "to CSV";
    public static final String ExportXMLMenuOptionText = "to XML";

    public static final Dimension FrameSize = new ConstDimension(600, 400);
    public static final Dimension MenuBarSize = new ConstDimension(590, 20);
    public static final Dimension MenuBarWrapperSize = new ConstDimension(590, 22);
    public static final Dimension MainBodyArea = new ConstDimension(590, 380);
    public static final Dimension ExparimentBoxSize = new ConstDimension(588, 378);


    public static class ConstDimension extends Dimension{
        public ConstDimension(int width, int height){
            super(width, height);
        }
        @Override public void setSize(int width, int height) {
            assert false : "immutable dimension";
        }
    }
}
