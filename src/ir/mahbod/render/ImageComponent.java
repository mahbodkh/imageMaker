package ir.mahbod.render;

public class ImageComponent {
  private int x;
  private int y;
  private int width;
  private int height;
  private final int SCALE_FACTOR = 1;
  private byte[] imageInByte;

  public byte[] getImageInByte() {
    return imageInByte;
  }

  public void setImageInByte(byte[] imageInByte) {
    this.imageInByte = imageInByte;
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
