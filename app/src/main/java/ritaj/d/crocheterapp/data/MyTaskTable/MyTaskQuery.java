package ritaj.d.crocheterapp.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao

public interface MyTaskQuery {


    @Query("SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userId=:userid_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p);

   @Query("SELECT * FROM MyTask WHERE userId=:userid_p AND isCompleted=:isCompleted_p"+"ORDER BY importance DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p, boolean isCompleted_p);
}
