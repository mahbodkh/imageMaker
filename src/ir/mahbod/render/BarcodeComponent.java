package ir.mahbod.render;

public class BarcodeComponent{
  private int x;
  private int y;
  private int width;
  private final int SCALE_FACTOR = 1;
  private int height;
  private String text;
  private int fontSize;

  public int getFontSize() {
    return fontSize / SCALE_FACTOR;
  }

  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
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

}
