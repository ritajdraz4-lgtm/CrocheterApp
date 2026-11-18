package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface YarnQuery {
    // استخراج جميع الخيوط
    @Query("SELECT * FROM Yarn")
    LiveData<List<Yarn>> getAllYarns();

    // استخراج خيط حسب المعرف
    @Query("SELECT * FROM Yarn WHERE yarnId = :yarnId")
    Yarn getYarnById(int yarnId);

    // استخراج الخيوط حسب اللون
    @Query("SELECT * FROM Yarn WHERE color = :color")
    LiveData<List<Yarn>> getYarnsByColor(String color);

    // استخراج الخيوط حسب النوع
    @Query("SELECT * FROM Yarn WHERE type = :type")
    LiveData<List<Yarn>> getYarnsByType(String type);

    // استخراج الخيوط حسب الوزن
    @Query("SELECT * FROM Yarn WHERE weight = :weight")
    LiveData<List<Yarn>> getYarnsByWeight(String weight);

    // استخراج الخيوط حسب اللون والنوع معاً
    @Query("SELECT * FROM Yarn WHERE color = :color AND type = :type")
    LiveData<List<Yarn>> getYarnsByColorAndType(String color, String type);

    // استخراج الخيوط التي لديها كباكيب كافية (أكثر من أو تساوي العدد المطلوب)
    @Query("SELECT * FROM Yarn WHERE skeinCount >= :minSkeins")
    LiveData<List<Yarn>> getYarnsWithSufficientSkeins(int minSkeins);

    // البحث عن خيط يحتوي على لون معين (بحث جزئي)
    @Query("SELECT * FROM Yarn WHERE color LIKE '%' || :searchTerm || '%'")
    LiveData<List<Yarn>> searchYarnByColor(String searchTerm);

    // إضافة خيط أو مجموعة خيوط
    @Insert
    void insert(Yarn... yarns);

    // إضافة خيط واحد
    @Insert
    long insertYarn(Yarn yarn);

    // تعديل خيط أو قائمة خيوط
    @Update
    void update(Yarn... yarns);

    // حذف خيط أو مجموعة خيوط
    @Delete
    void delete(Yarn... yarns);

    // حذف خيط حسب المعرف
    @Query("DELETE FROM Yarn WHERE yarnId = :yarnId")
    void deleteById(int yarnId);

    // حذف جميع الخيوط
    @Query("DELETE FROM Yarn")
    void deleteAllYarns();

    // تحديث عدد الكباكيب لخيط معين
    @Query("UPDATE Yarn SET skeinCount = :newCount WHERE yarnId = :yarnId")
    void updateSkeinCount(int yarnId, int newCount);
}
