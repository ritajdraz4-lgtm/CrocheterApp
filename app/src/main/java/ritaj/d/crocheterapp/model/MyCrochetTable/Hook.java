package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Hook")
public class Hook {
    @PrimaryKey(autoGenerate = true)
    private int hookId;
    private String size; // حجم السنارة (مثلاً: 2mm, 3mm, 4mm)
    private String type; // نوع السنارة (مثلاً: معدنية، بلاستيكية)
    private int quantity; // الكمية المتوفرة
    private String brand; // العلامة التجارية (اختياري)

    public Hook(String size, String type, int quantity, String brand) {
        this.size = size;
        this.type = type;
        this.quantity = quantity;
        this.brand = brand;
    }

    // Getters and Setters
    public int getHookId() {
        return hookId;
    }

    public void setHookId(int hookId) {
        this.hookId = hookId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
