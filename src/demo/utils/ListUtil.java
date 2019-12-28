package demo.utils;

import java.util.List;
import java.util.Set;

/**
 * Author:xianglei
 * Date: 2019-12-25 08:48
 * Description:
 */
public class ListUtil {

    public static boolean isEmpty(Object list) {
        if(list == null) return true;
        if(list instanceof List) {
            return ((List) list).isEmpty();
        } else if(list instanceof Set) {
            return ((Set) list).isEmpty();
        }
        return true;
    }
}
