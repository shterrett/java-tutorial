package testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalmerTest {
    @Test
    public void itRuns() {
        assertEquals(1, 1);
    }

    @Test
    public void calmSpeechRemovesExclamation() {
        final String excited = "I! AM! VERY!!! EXCITED!!!";
        final String calm = Calmer.calmSpeech(excited);
        assertEquals("I AM VERY EXCITED", calm);
    }

    @Test
    public void calmSpeechDoesNotChangeCalmString() {
        final String alreadyCalm = "I AM VERY CALM";
        final String stillCalm = Calmer.calmSpeech(alreadyCalm);
        assertEquals(alreadyCalm, stillCalm);
    }

    @Test
    public void calmAudienceRemovesOneParty() {
        final String[] invitees = {
                "Republican",
                "Green",
                "Independent",
                "Democrat"
        };
        final List<String> calmInvitees = Calmer.calmAudience(Arrays.asList(invitees));
        assertTrue(calmInvitees.contains("Republican") || calmInvitees.contains("Democrat"));
        assertFalse(calmInvitees.contains("Republican") && calmInvitees.contains("Democrat"));
    }
}