package kg.entities;

import kg.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(name = "post_id", nullable = false)
    private Post post;
    @Column(name = "followers_id", nullable = false)
    private Followers followers;

    public User() {
    }

    public User(String userName, Post post, Followers followers) {
        this.userName = userName;
        this.post = post;
        this.followers = followers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public static int putLikes(Post post){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int LikeQ = post.getLikes();
        LikeQ++;
        Post p= session.load(Post.class, post.getId());
        p.setId(post.getId());
        p.setLikes(LikeQ);
        session.getTransaction().commit();
        session.close();
        return LikeQ;

    }

    //
}
