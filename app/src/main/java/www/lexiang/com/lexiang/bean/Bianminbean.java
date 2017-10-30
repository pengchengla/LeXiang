package www.lexiang.com.lexiang.bean;

/**
 * date : ${Date}
 * author:衣鹏宇(ypu)
 */

public class Bianminbean {

      private int Image;
      private String count;

    public Bianminbean(int image, String count) {
        Image = image;
        this.count = count;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
