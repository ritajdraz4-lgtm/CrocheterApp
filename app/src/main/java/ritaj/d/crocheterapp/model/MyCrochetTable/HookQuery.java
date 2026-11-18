package ritaj.d.crocheterapp.model.MyCrochetTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HookQuery {
    // استخراج جميع السنانير
    @Query("SELECT * FROM Hook")
    LiveData<List<Hook>> getAllHooks();

    // استخراج سنارة حسب المعرف
    @Query("SELECT * FROM Hook WHERE hookId = :hookId")
    Hook getHookById(int hookId);

    // استخراج السنانير حسب الحجم
    @Query("SELECT * FROM Hook WHERE size = :size")
    LiveData<List<Hook>> getHooksBySize(String size);

    // استخراج السنانير حسب النوع
    @Query("SELECT * FROM Hook WHERE type = :type")
    LiveData<List<Hook>> getHooksByType(String type);

    // إضافة سنارة أو مجموعة سنانير
    @Insert
    void insert(Hook... hooks);

    // إضافة سنارة واحدة
    @Insert
    long insertHook(Hook hook);

    // تعديل سنارة أو قائمة سنانير
    @Update
    void update(Hook... hooks);

    // حذف سنارة أو مجموعة سنانير
    @Delete
    void delete(Hook... hooks);

    // حذف سنارة حسب المعرف
    @Query("DELETE FROM Hook WHERE hookId = :hookId")
    void deleteById(int hookId);

    // حذف جميع السنانير
    @Query("DELETE FROM Hook")
    void deleteAllHooks();
}
