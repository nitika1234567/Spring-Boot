package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {
    //Singleton
    private static ArrayList<Post> POSTS=new ArrayList<>();
  /*  static
    {
        Post post1=new Post();
        post1.setTitle("World Wide");
        post1.setBody("A news in utt reported heavy floods in UK districts.");
        post1.setDate(new Date());
        POSTS.add(post1);



        Post post2=new Post();
        post2.setTitle("Music");
        post2.setBody("A Music list");
        post2.setDate(new Date());
        POSTS.add(post2);



        Post post3=new Post();
        post3.setTitle("Technology");
        post3.setBody("Apple new ios 14.5");
        post3.setDate(new Date());
        POSTS.add(post3);


        Post post4=new Post();
        post4.setTitle("National");
        post4.setBody("COVID vaccine");
        post4.setDate(new Date());
        POSTS.add(post4);

    }*/
  private  final String url="jdbc:postgresql://localhost:5432/technicalblog";
  private final String username="postgres";
  private final String password="password";
  public Connection connect() throws SQLException
  {
    return DriverManager.getConnection(url,username,password);
  }
    public ArrayList<Post> getAllPosts()
    {//BUSSINESS LOGIC FOR CONNECTING THE DATABASE
      try {
        //1. connect to databse
        Connection connection=connect();
        // 2. get/create the statement

        Statement statement=connection.createStatement();

        // 3. Execute the select query
        ResultSet resultSet=statement.executeQuery("SELECT * FROM posts");

        // 4.  loop into the resultset and get the data
        while (resultSet.next())
        {
          Post post1 =new Post();
          post1.setTitle(resultSet.getString("title"));
          post1.setBody(resultSet.getString("body"));
          post1.setDate(resultSet.getDate("date"));
          //store data in singleton
          POSTS.add(post1);
        }

      }
      catch(SQLException e)
      {
       System.out.println(e.getMessage());
      }
      return POSTS;
    }
    public void createPost(Post newPost)
    {
      String query="INSERT INTO posts(title,body,date) VALUES(?,?,?)";
      try
      {
        Connection connection=connect();
        //2. prepare a statement
        PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        // fix the values from the VIEWS
        preparedStatement.setString(1,newPost.getTitle());
        preparedStatement.setString(2, newPost.getBody());
        preparedStatement.setDate(3,new Date(newPost.getDate().getTime()));
        int updatedRows = preparedStatement.executeUpdate();
        if(updatedRows>0)
        {
          System.out.println("Update is working fine");
        }


      }
      catch(SQLException e)
      {
        System.out.println(e.getMessage());
      }
    }
}
