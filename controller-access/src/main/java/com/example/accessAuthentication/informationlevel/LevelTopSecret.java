package main.java.com.example.accessAuthentication.informationlevel;

public class LevelTopSecret extends ConcreteData {
    ComponentData base;

    public LevelTopSecret(ComponentData base) {
        this.base = base;
    }

    @Override
    public String informationData() { // แม่แบบของ Data แต่ละ Level
        return base.informationData() + """
                Information Level : Top Secret

                    Sonnet 18 :
                        Shall I compare thee to a summer’s day?
                        Thou art more lovely and more temperate:
                        Rough winds do shake the darling buds of May,
                        And summer’s lease hath all too short a date:
                        Sometime too hot the eye of heaven shines,
                        And often is his gold complexion dimm'd;
                        And every fair from fair sometime declines,
                        By chance or nature’s changing course untrimm'd;
                        But thy eternal summer shall not fade,
                        Nor lose possession of that fair thou owest;
                        Nor shall Death brag thou wander’st in his shade,
                        When in eternal lines to time thou growest:
                        So long as men can breathe or eyes can see,
                        So long lives this, and this gives life to thee.

                                                          -- Shakespeare
                """; // (บทกวีว่าด้วยความรักแท้ที่ไม่เปลี่ยนแปลงแม้เวลาจะผ่านไป)
    }
}
