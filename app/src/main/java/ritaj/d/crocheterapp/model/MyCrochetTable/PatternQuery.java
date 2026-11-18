package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PatternQuery {
    // استخراج جميع الباترونات
    @Query("SELECT * FROM Pattern")
    LiveData<List<pattern>> getAllPatterns();

    // استخراج باترون حسب المعرف
    @Query("SELECT * FROM Pattern WHERE patternId = :patternId")
    pattern getPatternById(int patternId);

    // استخراج الباترونات حسب الموضوع (مدرسة، شتاء، صيف، هدايا)
    @Query("SELECT * FROM Pattern WHERE topic = :topic")
    LiveData<List<pattern>> getPatternsByTopic(String topic);

    // استخراج الباترونات حسب مستوى الصعوبة
    @Query("SELECT * FROM Pattern WHERE difficultyLevel = :difficultyLevel")
    LiveData<List<pattern>> getPatternsByDifficulty(String difficultyLevel);

    // استخراج الباترونات حسب نوع الخيط المطلوب
    @Query("SELECT * FROM Pattern WHERE requiredYarnType = :yarnType")
    LiveData<List<pattern>> getPatternsByYarnType(String yarnType);

    // استخراج الباترونات حسب وزن الخيط المطلوب
    @Query("SELECT * FROM Pattern WHERE requiredYarnWeight = :yarnWeight")
    LiveData<List<pattern>> getPatternsByYarnWeight(String yarnWeight);

    // استخراج الباترونات التي تحتاج كباكيب أقل من أو تساوي العدد المتوفر
    @Query("SELECT * FROM Pattern WHERE requiredSkeinCount <= :availableSkeins")
    LiveData<List<pattern>> getPatternsByAvailableSkeins(int availableSkeins);

    // استخراج الباترونات حسب حجم السنارة المطلوب
    @Query("SELECT * FROM Pattern WHERE requiredHookSize = :hookSize")
    LiveData<List<pattern>> getPatternsByHookSize(String hookSize);

    // استخراج الباترونات التي تحتاج ألوان معينة (بحث جزئي)
    @Query("SELECT * FROM Pattern WHERE requiredColors LIKE '%' || :color || '%'")
    LiveData<List<pattern>> getPatternsByColor(String color);

    // استخراج الباترونات حسب الموضوع ومستوى الصعوبة معاً
    @Query("SELECT * FROM Pattern WHERE topic = :topic AND difficultyLevel = :difficultyLevel")
    LiveData<List<pattern>> getPatternsByTopicAndDifficulty(String topic, String difficultyLevel);

    // البحث العام في اسم الباترون أو الوصف
    @Query("SELECT * FROM Pattern WHERE name LIKE '%' || :searchTerm || '%' OR description LIKE '%' || :searchTerm || '%'")
    LiveData<List<pattern>> searchPatterns(String searchTerm);

    // استخراج الباترونات المناسبة للخيط المتوفر (حسب النوع والوزن واللون والكمية)
    @Query("SELECT * FROM Pattern WHERE requiredYarnType = :yarnType AND requiredYarnWeight = :yarnWeight AND requiredSkeinCount <= :availableSkeins")
    LiveData<List<pattern>> getPatternsBasedOnMyYarn(String yarnType, String yarnWeight, int availableSkeins);

    // استخراج الباترونات المناسبة للخيط المتوفر مع مراعاة اللون أيضاً
    @Query("SELECT * FROM Pattern WHERE requiredYarnType = :yarnType AND requiredYarnWeight = :yarnWeight AND requiredSkeinCount <= :availableSkeins AND (requiredColors LIKE '%' || :color || '%' OR requiredColors IS NULL)")
    LiveData<List<pattern>> getPatternsBasedOnMyYarnWithColor(String yarnType, String yarnWeight, int availableSkeins, String color);

    // إضافة باترون أو مجموعة باترونات
    @Insert
    void insert(pattern... patterns);

    // إضافة باترون واحد
    @Insert
    long insertPattern(pattern pattern);

    // تعديل باترون أو قائمة باترونات
    @Update
    void update(pattern... patterns);

    // حذف باترون أو مجموعة باترونات
    @Delete
    void delete(pattern... patterns);

    // حذف باترون حسب المعرف
    @Query("DELETE FROM Pattern WHERE patternId = :patternId")
    void deleteById(int patternId);

    // حذف جميع الباترونات
    @Query("DELETE FROM Pattern")
    void deleteAllPatterns();
}
