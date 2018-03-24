package PitcherTest;

import Pitcher.Pitcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PitcherTest {
    @Test
    @DisplayName("Creation Test")
    void testCreatePitcher(){
        Pitcher pitcher = new Pitcher(10);
        assertEquals(0, pitcher.getContent());
    }

    @Test
    @DisplayName("Full Refill Test")
    void testRefillPitcher(){
        Pitcher pitcher = new Pitcher(10);
        pitcher.fullRefill();
        assertEquals(pitcher.getCapacity(), pitcher.getContent());
    }

    @Test
    @DisplayName("Partial Refill Test")
    void testPartialRefillPitcher(){
        Pitcher pitcher = new Pitcher(15);
        pitcher.partialRefill(8);
        assertEquals(8, pitcher.getContent());
    }

    @Test
    @DisplayName("OverRefill Pitcher Test")
    void testOverRefillPitcher(){
        Pitcher pitcher = new Pitcher(20);
        pitcher.partialRefill(200);
        assertEquals(pitcher.getCapacity(), pitcher.getContent(), "Over refill failed");
    }

    @Test
    @DisplayName("Refill from filled Pitcher Test")
    void testRefillFromFilledPitcher(){
        Pitcher pitcher = new Pitcher(20);
        pitcher.partialRefill(5);
        pitcher.partialRefill(5);
        assertEquals(10, pitcher.getContent(), "Not equal");
    }

    @Test
    @DisplayName("Over Refill from Filled Pitcher Test")
    void testOverRefillFromFilledPitcher(){
        Pitcher pitcher = new Pitcher(25);
        pitcher.partialRefill(15);
        pitcher.partialRefill(200);
        assertEquals(pitcher.getCapacity(), pitcher.getContent());
    }

    @Test
    @DisplayName("Refill from another Pitcher Test")
    void testRefillFromOtherPitcher(){
        Pitcher p1 = new Pitcher(15);
        Pitcher p2 = new Pitcher(7);
        p1.partialRefill(5);
        p2.refillFrom(p1);
        assertEquals(5, p2.getContent());
    }

    @Test
    @DisplayName("OverRefill from another Pitcher Test")
    void testOverRefillFromAnotherPitcher(){
        Pitcher p1 = new Pitcher(12);
        Pitcher p2 = new Pitcher(6);
        p1.fullRefill();
        p2.refillFrom(p1);
        assertEquals(p2.getCapacity(), p2.getContent());
    }

    @Test
    @DisplayName("OverRefill from another Filled Pitcher Test")
    void testOverRefillFromAnotherFilledPitcherTest(){
        Pitcher p1 = new Pitcher(17);
        Pitcher p2 = new Pitcher(9);
        p1.partialRefill(10);
        p2.refillFrom(p1);
        assertEquals(p2.getCapacity(), p2.getContent());
    }

    @Test
    @DisplayName("Refill Filled Pitcher form another Filled Pitcher Test")
    void testRefillFilledPitcherFromAnotherFilledPitcher(){
        Pitcher p1 = new Pitcher(20);
        Pitcher p2 = new Pitcher(7);
        p2.partialRefill(3);
        p1.partialRefill(2);
        p2.refillFrom(p1);
        assertEquals(5, p2.getContent());
    }

    @Test
    @DisplayName("Full Refilling a Pitcher from Another and Testing its Capacity test")
    void testCapacityFromPitcherWhenFullRefillingAnotherPitcher(){
        Pitcher p1 = new Pitcher(20);
        Pitcher p2 = new Pitcher(10);
        p1.fullRefill();
        p2.refillFrom(p1);
        assertEquals(p1.getCapacity() - p2.getCapacity(), p1.getContent());
    }

    @Test
    void testCapacityFromPitcherWhenRefillingAnotherPitcher(){
        Pitcher p1 = new Pitcher(20);
        Pitcher p2 = new Pitcher(10);
        p2.fullRefill();
        p1.refillFrom(p2);
        assertEquals(p2.getCapacity(), p1.getContent());
    }
}
