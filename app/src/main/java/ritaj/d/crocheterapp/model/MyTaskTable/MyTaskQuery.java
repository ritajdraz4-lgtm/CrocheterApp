package ritaj.d.crocheterapp.model.MyTaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface MyTaskQuery {


    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userId=:userid_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p);

   @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p"+" ORDER BY importance DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p, boolean isCompleted_p);
   @Insert
    void insertTask(MyTask... t);
   @Update
    void updateTask(MyTask... tasks);
   @Delete
    void deleteTask(MyTask... tasks);
   @Query("DELETE FROM MyTask WHERE keyId=:kid")
    void deleteTask(long kid);
   @Query("SELECT * FROM MyTask WHERE subjId=:key_id "+" ORDER BY importance DESC")
    List<MyTask> getTasksBySubjId(long key_id);
    @Query("SELECT * FROM MyTask WHERE subjId=:userId "+" ORDER BY importance DESC")

    LiveData<List<MyTask>> getTasksByUserId(long userId);
    @Query("SELECT * FROM MyTask WHERE subjId=:taskId "+" ORDER BY importance DESC")
    LiveData<MyTask> getTaskById(long taskId);
    @Query("SELECT * FROM MyTask WHERE subjId=:title "+" ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByTitle(String title);
    @Query("SELECT * FROM MyTask WHERE subjId=:description "+" ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByDescription(String description);
    @Query("SELECT * FROM MyTask WHERE subjId=:priority "+" ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByPriority(int priority);
    @Query("SELECT * FROM MyTask WHERE subjId=:userId "+" ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title);
    @Query("SELECT * FROM MyTask WHERE subjId=:tasks "+" ORDER BY importance DESC")
    void insert(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE subjId=:tasks "+" ORDER BY importance DESC")
    void update(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE subjId=:tasks "+" ORDER BY importance DESC")
    void delete(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE subjId=:taskId "+" ORDER BY importance DESC")
    void deleteTaskById(long taskId);
}
