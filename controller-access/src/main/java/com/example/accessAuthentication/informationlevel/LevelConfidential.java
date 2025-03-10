package main.java.com.example.accessAuthentication.informationlevel;

public class LevelConfidential implements ComponentData {
    @Override
    public String informationData() { // แม่แบบของ Data แต่ละ Level
        return """
                Information Level : Confidential

                    Sonnet 25 :
                        Let those who are in favour with their stars
                        Of public honour and proud titles boast,
                        Whilst I, whom fortune of such triumph bars,
                        Unlook'd for joy in that I honour most.
                        Great princes' favourites their fair leaves spread
                        But as the marigold at the sun's eye,
                        And in themselves their pride lies buried,
                        For at a frown they in their glory die.
                        The painful warrior famoused for fight,
                        After a thousand victories once foil'd,
                        Is from the book of honour razed quite,
                        And all the rest forgot for which he toil'd:
                        Then happy I, that love and am beloved
                        Where I may not remove nor be removed.

                                                -- Shakespeare

                """; // (พูดถึงผู้ที่อวดอ้างเกียรติยศจากโชคชะตา
                     // ในขณะที่เขาเองพบความสุขในสิ่งที่เขาให้ค่าที่สุด)
    }
}
