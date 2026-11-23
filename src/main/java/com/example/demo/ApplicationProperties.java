package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class ApplicationProperties {

    public static final int SCREEN_WIDTH = 420;
    public static final int SCREEN_HEIGHT = 600;


    public static final int SPACING = 10;
    public static final int PADDING = 20;


    public static final Font TITLE_FONT = Font.font("Poppins", FontWeight.BOLD, FontPosture.REGULAR, 22);
    public static final Font CLASS_FONT = Font.font("Poppins", FontWeight.BOLD, FontPosture.REGULAR, 16);
    public static final Font BODY_FONT = Font.font("Roboto", FontWeight.NORMAL, FontPosture.REGULAR, 13);


    public static final Color TEXT_COLOR = Color.rgb(34, 34, 34, 1.0);
    public static final Color COMPLETED_COLOR = Color.rgb(46, 125, 50, 1.0);
    public static final Color PROFILE_COLOR = Color.rgb(74, 144, 226, 1.0);
}
