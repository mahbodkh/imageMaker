package ir.mahbod.render;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class ImageMaker {
    //354 x 249 Passport
    private int width;
    private static final String FONT_ADDRESS = "/opt/ir/ntnaeem/kawthar/office/kats/render-ss-resources/assets/fonts/";
    private final static int RESOLUTION_SCALE = 4;
    private int height;

    private int resolutionScale;


    //private Graphics2D g2d;
    private BufferedImage img;
    private List<TextComponent> textComponentList;
    private List<ImageComponent> imageComponentList;
    private byte[] imageInByte;
    private BarcodeComponent barcodeComponent;


    public int getResolutionScale() {
        return resolutionScale;
    }

    public void setResolutionScale(int resolutionScale) {
        this.resolutionScale = resolutionScale;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public List<TextComponent> getTextComponentList() {
        return textComponentList;
    }

    public void setTextComponentList(List<TextComponent> TextComponentList) {
        this.textComponentList = TextComponentList;
    }

    public List<ImageComponent> getImageComponentList() {
        return imageComponentList;
    }

    public void setImageComponentList(List<ImageComponent> imageComponentList) {
        this.imageComponentList = imageComponentList;
    }

    public ImageMaker(int width, int height, int resolutionScale) {
        this.width = width;
        this.height = height;
        this.resolutionScale = resolutionScale;
        initCanvas();
    }

    public void write(String path) throws IOException {
        InputStream in = new ByteArrayInputStream(imageInByte);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        ImageIO.write(bImageFromConvert, "png", new File(path));
    }

    public byte[] getImageInByte() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }


    private void initCanvas() {
        img = new BufferedImage(getWidth() * getResolutionScale(), getHeight() * getResolutionScale(), BufferedImage.TYPE_INT_ARGB);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
    }

    private void forceStandardDpi(Graphics2D g2d) {
        final AffineTransform trans = g2d.getDeviceConfiguration().getNormalizingTransform();
        trans.setToScale(50, 50);//50x50
    }

    private void renderImageComponent(ImageComponent imageComponent) throws IOException {
        imageComponent.setX(imageComponent.getX() * getResolutionScale());
        imageComponent.setY(imageComponent.getY() * getResolutionScale());
        Graphics2D g2d = img.createGraphics();
        forceStandardDpi(g2d);
        InputStream in = new ByteArrayInputStream(imageComponent.getImageInByte());
        BufferedImage buffImage = ImageIO.read(in);
        int y = imageComponent.getY() + imageComponent.getHeight();

        g2d.drawImage(buffImage,
                imageComponent.getX(),
                imageComponent.getY(),
                null);
        g2d.dispose();
    }

    private void renderBarcodeComponent(BarcodeComponent passportBarcodeComponent) throws IOException, FontFormatException {
        Graphics2D g2d = img.createGraphics();
        forceStandardDpi(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        File fontFile = new File(FONT_ADDRESS + "barcode.ttf");
        Font barcodeFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(48F * getResolutionScale());
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
        g2d.setFont(barcodeFont);
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString(passportBarcodeComponent.getText(),
                passportBarcodeComponent.getX() * getResolutionScale(),
                passportBarcodeComponent.getY() * getResolutionScale() + passportBarcodeComponent.getHeight());
        g2d.dispose();
    }


    enum Lang {
        ENG,
        FARSI
    }

    private void setFontOnG2d(Graphics2D g2d, Lang lang, float fontSize) throws IOException, FontFormatException {

    }

    private void renderTextComponent(TextComponent textComponent) throws IOException, FontFormatException {
        //
        textComponent.setX(textComponent.getX() * getResolutionScale());
        textComponent.setY(textComponent.getY() * getResolutionScale());
        //
        int textWidth = 0;
        Graphics2D g2d = img.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        final AffineTransform trans = g2d.getDeviceConfiguration().getNormalizingTransform();
        trans.setToScale(50, 50);//50x50
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);


        //set font
//        FontMetrics fm = g2d.getFontMetrics();
        AffineTransform affinetransform = new AffineTransform();
        Font font = null;
        if (textComponent.getFontFilePath() == null) {
            if (textComponent.getLang().equals("en")) {
                textComponent.setFontFilePath(FONT_ADDRESS + "arial_farsi.ttf");
            } else if (textComponent.getLang().equals("fa")) {
                textComponent.setFontFilePath(FONT_ADDRESS + "arial_farsi.ttf");
            }
        }
        if (textComponent.getLang().equals("en")) {
            File fontFile = new File(textComponent.getFontFilePath());
            font =
                    Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(0, textComponent.getFontSize() * getResolutionScale());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            g2d.setFont(font);
            textComponent.setX(textComponent.getX());
        }
        //
        if (textComponent.getLang().equals("fa")) {
            File fontFile = new File(textComponent.getFontFilePath());
            font =
                    Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(0, textComponent.getFontSize() * getResolutionScale());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            g2d.setFont(font);
            //


            affinetransform.rotate(Math.toRadians(textComponent.getRotation()), 0, 0);
            Font rotatedFont = font.deriveFont(affinetransform);
            g2d.setFont(rotatedFont);


            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);


            textWidth = (int) (font.getStringBounds(textComponent.getText(), frc).getWidth());
//            textHeight = (int) (arialFont.getStringBounds(textComponent.getText(), frc).getHeight());
            System.out.println("======================");
            System.out.println(textWidth);
            System.out.println("======================");
            //
            textComponent.setX(textComponent.getX() - textWidth);
            System.out.println("===============");
            System.out.println("farsi X : " + textComponent.getX());
            System.out.println("farsi Y : " + textComponent.getY());
            System.out.println("===============");

            System.out.println(">>>>>>>>>");
            System.out.println(textComponent.getRotation());
            System.out.println(">>>>>>>>>");
        }

        affinetransform.rotate(Math.toRadians(textComponent.getRotation()), 0, 0);
        Font rotatedFont = font.deriveFont(affinetransform);
        g2d.setFont(rotatedFont);
        //
        g2d.setColor(
                new Color(
                        textComponent.getRedColor(),
                        textComponent.getGreenColor(),
                        textComponent.getBlueColor()
                )
        );
        g2d.drawString(
                textComponent.getText(),
                textComponent.getX(),
                textComponent.getY());
        g2d.dispose();
    }

    public void make() throws IOException, FontFormatException {
        for (TextComponent TextComponent : textComponentList) {
            renderTextComponent(TextComponent);
        }
        if (imageComponentList != null) {
            System.out.println("size in image maker : " + imageComponentList.size());
            for (ImageComponent passportImageComponent : imageComponentList) {
                renderImageComponent(passportImageComponent);
            }
        }
        if (barcodeComponent != null) {
            renderBarcodeComponent(barcodeComponent);
        }
    }

    public void setBarcodeComponent(BarcodeComponent barcodeComponent) {
        this.barcodeComponent = barcodeComponent;
    }


}
