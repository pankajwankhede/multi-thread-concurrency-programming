package atomic.demo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by xuliugen on 2017/10/27.
 */
public class AtomicIntegerFieldUpdaterDemo {

    public static AtomicIntegerFieldUpdater atomic =
            AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        User user = new User("xuliugen", 24);
        System.out.println(atomic.getAndIncrement(user));
        System.out.println(atomic.get(user));
    }

    static class User {
        private String userName;
        public volatile int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
