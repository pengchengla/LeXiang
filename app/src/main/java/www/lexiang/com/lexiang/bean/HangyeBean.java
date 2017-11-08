package www.lexiang.com.lexiang.bean;

/**
 * Created by Administrator on 2017/11/6.
 */

public class HangyeBean {
    private String content;
    private boolean isChecked;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public HangyeBean(String content) {
        this.content = content;
    }
}
