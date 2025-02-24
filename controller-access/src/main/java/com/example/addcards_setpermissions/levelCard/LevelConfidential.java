package main.java.com.example.addcards_setpermissions.levelCard;

public class LevelConfidential implements CardStrategy {

    @Override
    public String setAccessLevel() {
        return "Confidential";
    }

    @Override
    public boolean setisActive() {
        return true;
    }
}

/*
 * Confidential (ระดับลับต่ำสุด):
 * 
 * ข้อมูลที่อยู่ในระดับนี้จะถูกป้องกันจากการเปิดเผยต่อบุคคลภายนอกที่ไม่ได้รับอนุญาต
 * หากข้อมูลนี้รั่วไหล อาจทำให้เกิดผลกระทบที่ไม่รุนแรงต่อความมั่นคงของประเทศ
 */