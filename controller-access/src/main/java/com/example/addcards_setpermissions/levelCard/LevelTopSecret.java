package main.java.com.example.addcards_setpermissions.levelCard;

public class LevelTopSecret implements CardStrategy {
    @Override
    public String setAccessLevel() {
        return "Top Secret";
    }

    @Override
    public boolean setisActive() {
        return true;
    }
}
/*
 * Top Secret (ระดับสูงสุด):
 * 
 * ข้อมูลที่มีความสำคัญสูงสุดต่อความมั่นคงของประเทศ
 * การรั่วไหลของข้อมูลระดับนี้อาจมีผลกระทบร้ายแรงหรือทำให้ประเทศตกอยู่ในอันตราย
 */