package Core;
import dataStructures.*;

/**
 * Created by Matt on 6/18/2017.
 */
public class AccountLinkedList {

    private static LinkedOrderedList users = new LinkedOrderedList();

    public static LinkedOrderedList getUsers() {
        return users;
    }

    public static void setUsers(LinkedOrderedList users) {
        AccountLinkedList.users = users;
    }
}
