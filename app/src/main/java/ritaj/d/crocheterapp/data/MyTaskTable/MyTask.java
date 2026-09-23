package ritaj.d.crocheterapp.data.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity

public class MyTask {

    @PrimaryKey(autoGenerate = true)
    /* رقم المهمة **/
    public long keyld;
    /* درجة الاهمية 1-5 **/
    public int importance;
    /* عنوان قصير **/
    public String shortTitle;
    /* نص المهمة **/
    public String text;


    public long time;
    /* هل تمت المهمة **/
    public boolean isCompleted;
    public long subjld;

    public long userld;

    @Override
    public String toString() {
        return "MyTask{" +
                "keyld=" + keyld +
                ", importance=" + importance +
                ", shortTitle='" + shortTitle + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjld=" + subjld +
                ", userld=" + userld +
                '}';
    }

    public long getUserld() {
        return userld;
    }

    public void setUserld(long userld) {
        this.userld = userld;
    }

    public long getSubjld() {
        return subjld;
    }

    public void setSubjld(long subjld) {
        this.subjld = subjld;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long subjld;

    public long userld;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public long getKeyld() {
        return keyld;
    }

    public void setKeyld(long keyld) {
        this.keyld = keyld;
    }
}
