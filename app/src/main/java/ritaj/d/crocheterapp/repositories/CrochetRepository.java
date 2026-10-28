package ritaj.d.crocheterapp.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ritaj.d.crocheterapp.model.MyCrochetTable.Hook;
import ritaj.d.crocheterapp.model.MyCrochetTable.HookQuery;
import ritaj.d.crocheterapp.model.MyCrochetTable.Pattern;
import ritaj.d.crocheterapp.model.MyCrochetTable.PatternQuery;
import ritaj.d.crocheterapp.model.MyCrochetTable.Yarn;
import ritaj.d.crocheterapp.model.MyCrochetTable.YarnQuery;

public class CrochetRepository {
    private HookQuery hookQuery;
    private YarnQuery yarnQuery;
    private PatternQuery patternQuery;
    private LiveData<List<Hook>> allHooks;
    private LiveData<List<Yarn>> allYarns;
    private LiveData<List<Pattern>> allPatterns;

    /**
     * منشئ الكلاس (Constructor).
     * يقوم بتهيئة قاعدة البيانات واسترجاع كائنات الـ DAO.
     *
     * @param application سياق التطبيق (Application Context) المستخدم لإنشاء قاعدة البيانات.
     */
    public CrochetRepository(Application application) {
        // ملاحظة: يجب إنشاء قاعدة البيانات AppDataBase وإضافة الجداول الثلاثة
        // AppDataBase db = AppDataBase.getDb(application);
        // hookQuery = db.hookQuery();
        // yarnQuery = db.yarnQuery();
        // patternQuery = db.patternQuery();
        // allHooks = hookQuery.getAllHooks();
        // allYarns = yarnQuery.getAllYarns();
        // allPatterns = patternQuery.getAllPatterns();
    }

    // ========== عمليات السنانير (Hooks) ==========

    /**
     * LiveData جلب جميع السنانير الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع السنانير المحدثة تلقائياً.
     */
    public LiveData<List<Hook>> getAllHooks() {
        return allHooks;
    }

    /**
     * إضافة سنارة جديدة.
     *
     * @param hook السنارة المراد إضافتها.
     */
    public void insertHook(Hook hook) {
        new Thread(() -> {
            if (hookQuery != null) {
                hookQuery.insertHook(hook);
            }
        }).start();
    }

    /**
     * تعديل سنارة موجودة.
     *
     * @param hook السنارة المراد تعديلها.
     */
    public void updateHook(Hook hook) {
        new Thread(() -> {
            if (hookQuery != null) {
                hookQuery.update(hook);
            }
        }).start();
    }

    /**
     * حذف سنارة.
     *
     * @param hook السنارة المراد حذفها.
     */
    public void deleteHook(Hook hook) {
        new Thread(() -> {
            if (hookQuery != null) {
                hookQuery.delete(hook);
            }
        }).start();
    }

    /**
     * جلب السنانير حسب الحجم.
     *
     * @param size حجم السنارة.
     * @return قائمة السنانير بالحجم المحدد.
     */
    public LiveData<List<Hook>> getHooksBySize(String size) {
        if (hookQuery != null) {
            return hookQuery.getHooksBySize(size);
        }
        return null;
    }

    // ========== عمليات الخيوط (Yarns) ==========

    /**
     * LiveData جلب جميع الخيوط الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع الخيوط المحدثة تلقائياً.
     */
    public LiveData<List<Yarn>> getAllYarns() {
        return allYarns;
    }

    /**
     * إضافة خيط جديد.
     *
     * @param yarn الخيط المراد إضافته.
     */
    public void insertYarn(Yarn yarn) {
        new Thread(() -> {
            if (yarnQuery != null) {
                yarnQuery.insertYarn(yarn);
            }
        }).start();
    }

    /**
     * تعديل خيط موجود.
     *
     * @param yarn الخيط المراد تعديله.
     */
    public void updateYarn(Yarn yarn) {
        new Thread(() -> {
            if (yarnQuery != null) {
                yarnQuery.update(yarn);
            }
        }).start();
    }

    /**
     * حذف خيط.
     *
     * @param yarn الخيط المراد حذفه.
     */
    public void deleteYarn(Yarn yarn) {
        new Thread(() -> {
            if (yarnQuery != null) {
                yarnQuery.delete(yarn);
            }
        }).start();
    }

    /**
     * جلب الخيوط حسب اللون.
     *
     * @param color لون الخيط.
     * @return قائمة الخيوط باللون المحدد.
     */
    public LiveData<List<Yarn>> getYarnsByColor(String color) {
        if (yarnQuery != null) {
            return yarnQuery.getYarnsByColor(color);
        }
        return null;
    }

    /**
     * جلب الخيوط حسب النوع.
     *
     * @param type نوع الخيط (قطن، صوف، أكريليك).
     * @return قائمة الخيوط بالنوع المحدد.
     */
    public LiveData<List<Yarn>> getYarnsByType(String type) {
        if (yarnQuery != null) {
            return yarnQuery.getYarnsByType(type);
        }
        return null;
    }

    /**
     * تحديث عدد الكباكيب لخيط معين.
     *
     * @param yarnId معرف الخيط.
     * @param newCount العدد الجديد للكباكيب.
     */
    public void updateSkeinCount(int yarnId, int newCount) {
        new Thread(() -> {
            if (yarnQuery != null) {
                yarnQuery.updateSkeinCount(yarnId, newCount);
            }
        }).start();
    }

    // ========== عمليات الباترونات (Patterns) ==========

    /**
     * LiveData جلب جميع الباترونات الموجودة في قاعدة البيانات كـ.
     *
     * @return قائمة بجميع الباترونات المحدثة تلقائياً.
     */
    public LiveData<List<Pattern>> getAllPatterns() {
        return allPatterns;
    }

    /**
     * إضافة باترون جديد.
     *
     * @param pattern الباترون المراد إضافته.
     */
    public void insertPattern(Pattern pattern) {
        new Thread(() -> {
            if (patternQuery != null) {
                patternQuery.insertPattern(pattern);
            }
        }).start();
    }

    /**
     * تعديل باترون موجود.
     *
     * @param pattern الباترون المراد تعديله.
     */
    public void updatePattern(Pattern pattern) {
        new Thread(() -> {
            if (patternQuery != null) {
                patternQuery.update(pattern);
            }
        }).start();
    }

    /**
     * حذف باترون.
     *
     * @param pattern الباترون المراد حذفه.
     */
    public void deletePattern(Pattern pattern) {
        new Thread(() -> {
            if (patternQuery != null) {
                patternQuery.delete(pattern);
            }
        }).start();
    }

    /**
     * جلب الباترونات حسب الموضوع (مدرسة، شتاء، صيف، هدايا).
     *
     * @param topic الموضوع المطلوب.
     * @return قائمة الباترونات بالموضوع المحدد.
     */
    public LiveData<List<Pattern>> getPatternsByTopic(String topic) {
        if (patternQuery != null) {
            return patternQuery.getPatternsByTopic(topic);
        }
        return null;
    }

    /**
     * جلب الباترونات حسب مستوى الصعوبة.
     *
     * @param difficultyLevel مستوى الصعوبة (مبتدئ، متوسط، متقدم).
     * @return قائمة الباترونات بمستوى الصعوبة المحدد.
     */
    public LiveData<List<Pattern>> getPatternsByDifficulty(String difficultyLevel) {
        if (patternQuery != null) {
            return patternQuery.getPatternsByDifficulty(difficultyLevel);
        }
        return null;
    }

    /**
     * البحث العام في الباترونات (بالاسم أو الوصف).
     *
     * @param searchTerm كلمة البحث.
     * @return قائمة الباترونات المطابقة.
     */
    public LiveData<List<Pattern>> searchPatterns(String searchTerm) {
        if (patternQuery != null) {
            return patternQuery.searchPatterns(searchTerm);
        }
        return null;
    }

    // ========== دوال منطقية متقدمة ==========

    /**
     * جلب الباترونات المناسبة للخيط المتوفر عند المستخدم.
     * تعتمد على نوع الخيط، وزنه، وعدد الكباكيب المتوفرة.
     *
     * @param yarnType نوع الخيط المتوفر.
     * @param yarnWeight وزن الخيط المتوفر.
     * @param availableSkeins عدد الكباكيب المتوفرة.
     * @return قائمة الباترونات المناسبة.
     */
    public LiveData<List<Pattern>> getPatternsBasedOnMyYarn(String yarnType, String yarnWeight, int availableSkeins) {
        if (patternQuery != null) {
            return patternQuery.getPatternsBasedOnMyYarn(yarnType, yarnWeight, availableSkeins);
        }
        return null;
    }

    /**
     * جلب الباترونات المناسبة للخيط المتوفر مع مراعاة اللون أيضاً.
     *
     * @param yarnType نوع الخيط المتوفر.
     * @param yarnWeight وزن الخيط المتوفر.
     * @param availableSkeins عدد الكباكيب المتوفرة.
     * @param color اللون المتوفر.
     * @return قائمة الباترونات المناسبة.
     */
    public LiveData<List<Pattern>> getPatternsBasedOnMyYarnWithColor(String yarnType, String yarnWeight, int availableSkeins, String color) {
        if (patternQuery != null) {
            return patternQuery.getPatternsBasedOnMyYarnWithColor(yarnType, yarnWeight, availableSkeins, color);
        }
        return null;
    }

    /**
     * اقتراح مشروع حياكة بناءً على المخزون المتوفر.
     * هذه الدالة تجمع المعلومات من الخيوط والسنانير وتقترح باترونات مناسبة.
     *
     * @return قائمة الباترونات المقترحة.
     */
    public LiveData<List<Pattern>> suggestProject() {
        // هذه الدالة يمكن تطويرها لاحقاً لتكون أكثر ذكاءً
        // حالياً تعيد جميع الباترونات
        return allPatterns;
    }
}



