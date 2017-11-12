package test_pckg;

import com.toledo.mario.*;
import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
/**
 * Created by armando on 11/7/17.
 */
public class ToledoMarioGameTest extends TestCase {

    // mock creation
    List mockedList = mock(List.class);

    @Test
    public void testBatchCreation() throws Exception {
        ToledoMarioGame toledoMarioGame = new ToledoMarioGame();
        assertEquals(1, 1);
    }

}
