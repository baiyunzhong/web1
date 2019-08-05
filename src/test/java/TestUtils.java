import com.jnshu.ssm.utils.DateUtil;
import org.junit.Test;

import java.util.Date;
import java.util.logging.Logger;

/**
 * author : baiyunzhong
 * created time : 2019/8/5
 */
public class TestUtils {
    private static final Logger LOGGER =Logger.getLogger("TestUtils");
    @Test
    public void testDateUtil () {
        Date date =new Date(System.currentTimeMillis());
        String dateStr =new DateUtil().dateToString(date);
        LOGGER.info("Date"+ date);
        LOGGER.info("Date转String"+ dateStr);
        LOGGER.info("Long"+System.currentTimeMillis());
        LOGGER.info("Long转String"+DateUtil.longToString(System.currentTimeMillis()));


    }


}
