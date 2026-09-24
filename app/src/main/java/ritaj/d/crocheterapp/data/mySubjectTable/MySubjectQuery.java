package ritaj.d.crocheterapp.data.mySubjectTable;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MySubjectQuery {
    @Query("SELECT * FROM MySubject")
    List<MySubject> getAllSubjects();
    @Insert
    void insert(MySubject...s);
    @Delete
    void deleteTask(MySubject...s);
    @Query("DELETE FROM MySubject WHERE key_id=:keyid")
    void delete(long keyid);
    @Query("SELECT * FROM MySubject WHERE title=:sub")
    MySubject checkSubject(String sub);

}
