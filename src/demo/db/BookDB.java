package demo.db;

import demo.bean.BookBean;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author:xianglei
 * Date: 2019-12-24 08:57
 * Description:
 */
public class BookDB {

    private static Map<String, BookBean> books = new LinkedHashMap<String, BookBean>();

    static {
        books.put("1", new BookBean("1", "java web开发"));
        books.put("2", new BookBean("2", "jdbc开发"));
        books.put("3", new BookBean("3", "java基础"));
        books.put("4", new BookBean("4", "struts开发"));
        books.put("5", new BookBean("5", "spring开发"));
    }

    public static Collection<BookBean> getAll() {
        return books.values();
    }

    public static BookBean getBookById(String id) {
        return books.get(id);
    }
}
