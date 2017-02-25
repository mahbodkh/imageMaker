package ir.mahbod;

import ir.mahbod.render.ImageMaker;
import ir.mahbod.render.TextComponent;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TextComponent textComponent = new TextComponent();
        textComponent.setText("مهبد خسروانی");
        textComponent.setFontSize(10);
        textComponent.setLang("fa");
        textComponent.setX(200);
        textComponent.setY(70);
//        textComponent.setRotation(45);

        //
        TextComponent textComponent2 = new TextComponent();
        textComponent2.setText("mahbod kh");
        textComponent2.setFontSize(10);
        textComponent2.setLang("en");
        textComponent2.setX(100);
        textComponent2.setY(70);
        textComponent2.setRotation(90);


        //354, 249, 8
        ImageMaker imageMaker = new ImageMaker(354, 247, 4);
        ArrayList<TextComponent> textComponentList = new ArrayList<TextComponent>();
        textComponentList.add(textComponent2);
        textComponentList.add(textComponent);
        imageMaker.setTextComponentList(textComponentList);

        try {

            imageMaker.make();
            imageMaker.getImageInByte();

            // Write Your Right Path for See PNG Image
            imageMaker.write("/home/mkhosravani/Desktop/test.png");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        System.out.println("byte ---- 1");
    }
}
