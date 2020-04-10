package kg;


import kg.db.UserDB;
import kg.entities.Followers;
import kg.entities.Post;
import kg.entities.User;

public class App
{
    public static void main( String[] args )
    {

        Post post1 = new Post(26);
        Post post2 = new Post(38);
        Post post3 = new Post(124);
        Post post4 = new Post(19);
        Post post5 = new Post(56);



        Followers followers1= new Followers(600);
        Followers followers2= new Followers(75);
        Followers followers3= new Followers(25003);
        Followers followers4= new Followers(120);
        Followers followers5= new Followers(700);

        User user1 = new User("jamiliaa", post1, followers1);
        User user2 = new User("kamilla98", post2, followers2);
        User user3 = new User("tory_kelly", post3,  followers3);
        User user4 = new User("andrei22", post4,  followers4);
        User user5 = new User("samira75", post5,  followers5);

        UserDB.create(user1);
        UserDB.create(user2);
        UserDB.create(user3);
        UserDB.create(user4);
        UserDB.create(user5);


        user1.putLikes(post2);
        user2.putLikes(post1);
        user3.putLikes(post4);
        user4.putLikes(post3);
        user5.putLikes(post2);
        user1.putLikes(post4);
        user2.putLikes(post4);

       UserDB.showUsersBySortingNames();



        //у меня все, голова раскалывается(



    }
}
