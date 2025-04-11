package kcpoland_ma3;

import java.io.IOException;
import java.util.ArrayList;

public interface Registry {
    //Member Variables//

    //All Registered Users
    public static final ArrayList<Person> userlist = new ArrayList<>();
    
    //All Registered Lodgings
    public static final ArrayList<Lodging> lodgings = new ArrayList<>();

    //Abstract Methods//
    abstract public void save() throws IOException;

    abstract public void load() throws IOException;
}
