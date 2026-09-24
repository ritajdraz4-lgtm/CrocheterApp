package ritaj.d.crocheterapp.data;

import androidx.room.Database;

import ritaj.d.crocheterapp.data.MyTaskTable.MyTask;
import ritaj.d.crocheterapp.data.MyUserTable.MyUser;
import ritaj.d.crocheterapp.data.MyUserTable.MyUserQuery;
import ritaj.d.crocheterapp.data.mySubjectTable.MySubject;
import ritaj.d.crocheterapp.data.mySubjectTable.MySubjectQuery;

public class AppDatabase {
@Database(entities = ,  {MyUser.class, MySubject.class, MyTask.class},version=1)
    AppDatabase extends RoomDatabase(

private static AppDatabase db;

    public abstract MyUserQuery getMyUserQuery():

    public abstract MySubjectQuery getMySubjectQuery():

    public static AppDataBase getDB(Context context){


        if(db==null）
        {
          db = Room.dotabaseBuilder(context,AppDataBase.class,
                          AppDataBase.class,

            "Ritaj")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build();
    }
            return db;
}
}