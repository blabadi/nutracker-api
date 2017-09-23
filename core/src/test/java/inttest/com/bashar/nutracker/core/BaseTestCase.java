package inttest.com.bashar.nutracker.core;

import com.bashar.nutracker.core.CoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Bashar on 2017-09-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class, TestConfig.class})
@ActiveProfiles("dev")
public class BaseTestCase {
    @Test
    public final void init(){

    }
}
