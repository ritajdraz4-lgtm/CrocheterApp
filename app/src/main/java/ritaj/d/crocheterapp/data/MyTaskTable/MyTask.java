package ritaj.d.crocheterapp.data.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity

public class MyTask {

    @PrimaryKey(autoGenerate = true)
    /* رقم المهمة **/
    public long keyId;
    /* درجة الاهمية 1-5 **/
    public int importance;
    /* عنوان قصير **/
    public String shortTitle;
    /* نص المهمة **/
    public String text;


    public long time;
    /* هل تمت المهمة **/
    public boolean isCompleted;
    public long subjId;

    public long userId;

    @Override
    public String toString() {
        return "MyTask{" +
                "keyld=" + keyId +
                ", importance=" + importance +
                ", shortTitle='" + shortTitle + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", isCompleted=" + isCompleted +
                ", subjld=" + subjId +
                ", userld=" + userId +
                '}';
    }

    public long getUserld() {
        return userId;
    }

    public void setUserld(long userld) {
        this.userId = userld;
    }

    public long getSubjld() {
        return subjId;
    }

    public void setSubjld(long subjld) {
        this.subjId = subjld;
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
        return keyId;
    }

    public void setKeyld(long keyld) {
        this.keyId = keyld;
    }
}
