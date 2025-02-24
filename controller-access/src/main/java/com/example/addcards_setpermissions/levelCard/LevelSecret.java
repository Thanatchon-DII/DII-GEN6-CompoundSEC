package main.java.com.example.addcards_setpermissions.levelCard;

public class LevelSecret implements CardStrategy {
    @Override
    public String setAccessLevel() {
        return "Secret";
    }

    @Override
    public boolean setisActive() {
        return true;
    }
}
/*
 * Secret (ระดับลับ):
 * 
 * ข้อมูลที่มีความสำคัญต่อความมั่นคงของประเทศ หากข้อมูลนี้รั่วไหล
 * อาจทำให้เกิดผลกระทบที่รุนแรงต่อความมั่นคงของประเทศ
 */
