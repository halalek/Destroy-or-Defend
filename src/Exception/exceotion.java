package Exception;

import Game.Arena;
import Model.Object.Unit;

public class exceotion {

    public boolean IllegalAttac(Unit unit2) {
        // ابعتلو العنصرالمهاجم مع العنصر يلي برجعو تابع الهجوم اذا رجع ترو معناها استدعي تابع نتيجة الهجوم

        try {
            if (unit2.getHealth()!= 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean IllegalSquare(int temp_x, int temp_y, Arena a)
    //  ابعت الموقع يلي بعتو لل ()move_step
    //قبل استدعاء لاختبار الموقع خارج الرقعة او مشغول
    {
        try {
            if (temp_x <= a.end && temp_y <= a.end2 && a.Arena.get(temp_x).get(temp_y) != null) {
                return true;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
