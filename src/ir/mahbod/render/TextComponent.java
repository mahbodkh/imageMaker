package ir.mahbod.render;

public class TextComponent {
    private final int SCALE_FACTOR = 1;
    private String text = "";
    private int x;
    private int y;
    private int rotation;
    private int fontSize;
    private String fieldName;
    private int width;
    private int height;
    private int type;
    private String lang;
    private String fontFilePath;
    private int redColor;
    private int blueColor;
    private int greenColor;


    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRedColor() {
        return redColor;
    }

    public void setRedColor(int redColor) {
        this.redColor = redColor;
    }

    public int getBlueColor() {
        return blueColor;
    }

    public void setBlueColor(int blueColor) {
        this.blueColor = blueColor;
    }

    public int getGreenColor() {
        return greenColor;
    }

    public void setGreenColor(int greenColor) {
        this.greenColor = greenColor;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getFontFilePath() {
        return fontFilePath;
    }

    public void setFontFilePath(String fontFilePath) {
        this.fontFilePath = fontFilePath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWidth() {
        return width / SCALE_FACTOR;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height / SCALE_FACTOR;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getX() {
        return x / SCALE_FACTOR;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y / SCALE_FACTOR;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFontSize() {
        return fontSize / SCALE_FACTOR;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
