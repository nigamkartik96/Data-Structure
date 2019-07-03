import model.Address;
import model.Qualification;
import model.User;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    private User user1, user2;

    public static void main(String args[]) throws IllegalAccessException, InstantiationException {
        MainClass obj = new MainClass();
        obj.initialize();

    }

    public void initialize() throws IllegalAccessException, InstantiationException {
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(new Address("Yoyo", "b-234"));
        addressList.add(new Address("fwfe", "b-235"));

        Qualification qualification = new Qualification("ghar se", null);

        user1 = new User("Baap", "email", null, qualification);

        // addressList.remove(1);
        qualification = new Qualification("bahar se", "masti ke liye");

        user2 = new User("Baap ka beta", null, addressList, qualification);
        ArrayList<String> listOfClasses = new ArrayList<>();
        listOfClasses.add("Address");
        listOfClasses.add("Qualification");
        System.out.println(merge(this.user1, this.user2, listOfClasses));
    }

    public <T> T merge(T local, T remote, ArrayList<String> listOfClass)
            throws IllegalAccessException, InstantiationException {
        Class<?> clazz = local.getClass();
        Object merged = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object localValue = field.get(local);
            Object remoteValue = field.get(remote);
            if (localValue != null) {
                if (listOfClass.contains(localValue.getClass().getSimpleName())) {
                    field.set(merged, this.merge(localValue, remoteValue, listOfClass));
                } else {
                    field.set(merged, (remoteValue != null) ? remoteValue : localValue);
                }
            } else if (remoteValue != null) {
                field.set(merged, remoteValue);
            }
        }
        return (T) merged;
    }

}
