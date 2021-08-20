Social Media Application

Social media application consist of total 6 entities including User,UserProfile,Post,Comments,Likes and Tags. Each entities related with each other as shown in ER Diagram.

User : User(End User) is responsible to create certain operation such as creating profile creating Post, updating post, liking the post,commenting on the post and adding multiple tags in a post.User can contains only email field.

URL for user
create user : http://localhost:8080/social-media/addUser
get All user : http://localhost:8080/social-media/getAllUsers
get a user : http://localhost:8080/social-media/getUser/{email}
delete user : http://localhost:8080/social-media/deleteUser/{id}

User Profile : User can update his profile which include name, address and date of birth. We can access user profile from user api's itself.

URL for user profile
create user Profile : http://localhost:8080/social-media/addUser
get user Profile : http://localhost:8080/social-media/getUser/{email}
get All user Profile : http://localhost:8080/social-media/getAllUsers
delete user Profile : http://localhost:8080/social-media/deleteUser/{id}

Posts : User can create post, update post, and delete a particular post. User is also responsible to Like a particular post, commenting on a post and add a tags to a particular post. Post include fields such as postName, details, created date and updated date. other than that user can also add a tags.

URL for post
create post : http://localhost:8080/social-media/user/post
update post :  http://localhost:8080/social-media/user/post
get post : http://localhost:8080/social-media/user/getPost/{id}
get All post : http://localhost:8080/social-media/getAllPosts
delete post : http://localhost:8080/social-media/delete-post/{id}

Comments: User can add multiple comments on a single post and also can delete the comments.

URL for comments
add comments ; http://localhost:8080/social-media/comments
delete comments : http://localhost:8080/social-media/delete-comments/{id}

Likes : User is able to like post only one time. If user trying to same post twice the it does not count. Total like count is visible in Post entity.

URL for Like 
add like :http://localhost:8080/social-media/post/like

![ER-Diagram](https://user-images.githubusercontent.com/88184567/130204654-56b9d8c3-374b-45d7-992e-6ee9e4cfcaaa.jpg)

