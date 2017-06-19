package Core;

import dataStructures.IndexedList;

/**
 * Created by Matt on 6/18/2017.
 */
public class AccountIndexedList<U extends Person> {

    private static IndexedList users = new IndexedList();

    public static IndexedList getUsers() {
        return users;
    }

    public static void setUsers(IndexedList<User> users) {
        AccountIndexedList.users = users;
    }
}
