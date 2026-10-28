package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Yarn")
public class Yarn {
    @PrimaryKey(autoGenerate = true)
    private int yarnId;
    private String color; // لون الخيط
    private String type; // نوع الخيط (مثلاً: قطن، صوف، أكريليك)
    private int skeinCount; // عدد الكباكيب
    private String brand; // العلامة التجارية (اختياري)
    private String weight; // وزن الخيط (مثلاً: DK, Worsted, Chunky)

    public Yarn(String color, String type, int skeinCount, String brand, String weight) {
        this.color = color;
        this.type = type;
        this.skeinCount = skeinCount;
        this.brand = brand;
        this.weight = weight;
    }

    // Getters and Setters
    public int getYarnId() {
        return yarnId;
    }

    public void setYarnId(int yarnId) {
        this.yarnId = yarnId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSkeinCount() {
        return skeinCount;
    }

    public void setSkeinCount(int skeinCount) {
        this.skeinCount = skeinCount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
