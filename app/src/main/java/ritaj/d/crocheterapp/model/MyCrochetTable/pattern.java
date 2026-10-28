package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pattern")
public class Pattern {
    @PrimaryKey(autoGenerate = true)
    private int patternId;
    private String name; // اسم الباترون
    private String description; // وصف الباترون
    private String difficultyLevel; // مستوى الصعوبة (مبتدئ، متوسط، متقدم)
    private String requiredColors; // الألوان المطلوبة (مفصولة بفاصلة)
    private String requiredYarnType; // نوع الخيط المطلوب
    private String requiredYarnWeight; // وزن الخيط المطلوب
    private String requiredHookSize; // حجم السنارة المطلوب
    private int requiredSkeinCount; // عدد الكباكيب المطلوبة
    private String imagePath; // مسار الصورة/الرسم
    private String topic; // الموضوع (مثلاً: مدرسة، شتاء، صيف، هدايا)
    private String writtenPattern; // الباترون المكتوب
    private String chartPattern; // الباترون المرسوم (رسم بياني)

    public Pattern(String name, String description, String difficultyLevel, String requiredColors,
                  String requiredYarnType, String requiredYarnWeight, String requiredHookSize,
                  int requiredSkeinCount, String imagePath, String topic, String writtenPattern,
                  String chartPattern) {
        this.name = name;
        this.description = description;
        this.difficultyLevel = difficultyLevel;
        this.requiredColors = requiredColors;
        this.requiredYarnType = requiredYarnType;
        this.requiredYarnWeight = requiredYarnWeight;
        this.requiredHookSize = requiredHookSize;
        this.requiredSkeinCount = requiredSkeinCount;
        this.imagePath = imagePath;
        this.topic = topic;
        this.writtenPattern = writtenPattern;
        this.chartPattern = chartPattern;
    }

    // Getters and Setters
    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getRequiredColors() {
        return requiredColors;
    }

    public void setRequiredColors(String requiredColors) {
        this.requiredColors = requiredColors;
    }

    public String getRequiredYarnType() {
        return requiredYarnType;
    }

    public void setRequiredYarnType(String requiredYarnType) {
        this.requiredYarnType = requiredYarnType;
    }

    public String getRequiredYarnWeight() {
        return requiredYarnWeight;
    }

    public void setRequiredYarnWeight(String requiredYarnWeight) {
        this.requiredYarnWeight = requiredYarnWeight;
    }

    public String getRequiredHookSize() {
        return requiredHookSize;
    }

    public void setRequiredHookSize(String requiredHookSize) {
        this.requiredHookSize = requiredHookSize;
    }

    public int getRequiredSkeinCount() {
        return requiredSkeinCount;
    }

    public void setRequiredSkeinCount(int requiredSkeinCount) {
        this.requiredSkeinCount = requiredSkeinCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getWrittenPattern() {
        return writtenPattern;
    }

    public void setWrittenPattern(String writtenPattern) {
        this.writtenPattern = writtenPattern;
    }

    public String getChartPattern() {
        return chartPattern;
    }

    public void setChartPattern(String chartPattern) {
        this.chartPattern = chartPattern;
    }
}
