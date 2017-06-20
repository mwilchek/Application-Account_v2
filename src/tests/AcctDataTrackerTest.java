package tests;

import Core.AcctDataTracker;
import Core.User;
import dataStructures.IndexedList;
import org.junit.jupiter.api.Test;

/**
 * Created by Matt on 6/19/2017.
 */
public class AcctDataTrackerTest {
    @Test
    public void outputAccounts(User user) throws Exception {
        IndexedList<User> list = new IndexedList<>();
        list.add(user);
        AcctDataTracker.outputAccounts(list);
    }

    @Test
    public void readAccounts() throws Exception {
        System.out.print((IndexedList<User>)AcctDataTracker.readAccounts());
    }

}