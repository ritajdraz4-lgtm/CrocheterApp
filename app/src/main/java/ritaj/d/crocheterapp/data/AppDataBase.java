package ritaj.d.crocheterapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ritaj.d.crocheterapp.data.MyTaskTable.MyTask;
import ritaj.d.crocheterapp.data.MyTaskTable.MyTaskQuery;
import ritaj.d.crocheterapp.data.MyUserTable.MyUser;
import ritaj.d.crocheterapp.data.MyUserTable.MyUserQuery;
import ritaj.d.crocheterapp.data.mySubjectTable.MySubject;
import ritaj.d.crocheterapp.data.mySubjectTable.MySubjectQuery;


@Database (entities ={MyUser.class,MySubject.class, MyTask.class},version=1)
public abstract class AppDataBase extends RoomDatabase{
    private static  AppDataBase db;


    public abstract MyUserQuery getMyUserQuery();

    public abstract MySubjectQuery getMySubjectQuery();

    public abstract MyTaskQuery getMyTaskQuery();

    public static AppDataBase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,AppDataBase.class,"Ritaj")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}