import java.util.ArrayList;
import java.lang.reflect.Array;

public class Data {

        private ArrayList<User> users = new ArrayList<>();
        private ArrayList<User> userlist = new ArrayList<>();

        public Data() {
            this.users = new ArrayList<>();
            this.userlist = new ArrayList<>();
            createUsers();

        }

        private void createUsers() {
            User user = new User("Hans1234@gmail.com", 1234, 1, "Team Hans", 30, 2);
            User user1 = new User("Bent78@gmail.com", 1310, 2, "Team Hans", 40, 2);
            User user2 = new User("Peter78@gmail.com", 1311, 2, "Team Hans", 50, 3);
            User user3 = new User("Morten78@gmail.com", 1319, 2, "Team Hans", 60, 3);
            User user4 = new User("Seda19@gmail.com", 1329, 1, "Team Seda", 70, 3);
            User user5 = new User("Christian21@gmail.com", 1339, 2, "Team Seda", 80, 4);
            User user6 = new User("Ahilan25@gmail.com", 1330, 2, "Team Seda", 25, 2);
            User user7 = new User("Alexander20@gmail.com", 1320, 2, "Team Seda", 45, 3);
            User user8 = new User("Martin21@gmail.com", 1314, 1, "Team Martin", 55, 3);
            User user9 = new User("Sebastian29@gmail.com", 1312, 2, "Team Martin", 65, 4);
            User user10 = new User("Carl12@gmail.com", 1313, 2, "Team Martin", 85, 5);
            User user11 = new User("Stig59@gmail.com", 1317, 2, "Team Martin", 95, 5);
            User user12 = new User("Pia55@gmail.com", 1305, 1, "Team Pia", 100, 5);
            User user13 = new User("Caroline23@gmail.com", 1304, 2, "Team Pia", 65, 3);
            User user14 = new User("Dorte43@gmail.com", 1333, 2, "Team Pia", 35, 3);
            User user15 = new User("Klaus78@gmail.com", 1334, 2, "Team Pia", 65, 3);

            users.add(user);
            users.add(user1);
            users.add(user2);
            users.add(user3);
            users.add(user4);
            users.add(user5);
            users.add(user6);
            users.add(user7);
            users.add(user8);
            users.add(user9);
            users.add(user10);
            users.add(user11);
            users.add(user12);
            users.add(user13);
            users.add(user14);
            users.add(user15);

        }

        public ArrayList<User> getUserlist() {
            return userlist;
        }

        public ArrayList<User> getUsers() {
            return users;
        }

    }
