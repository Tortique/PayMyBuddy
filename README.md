<img src="https://user-images.githubusercontent.com/11331740/114841177-d874e100-9dd7-11eb-82d4-d64ee6987548.jpg">

# PayMyBuddy
Projet 6

This application provide to friends a way to pay them each other.

First step was to build diagrams :

<img src ="https://user-images.githubusercontent.com/11331740/114840297-f68e1180-9dd6-11eb-9560-5143f752b2b6.png" width="250" height="250">
<img src ="https://user-images.githubusercontent.com/11331740/114840307-f9890200-9dd6-11eb-97be-51a72d14587b.png" width="250" height="250">

Second step, coding : 
First page: /index
  This page let choice to choose between register or login page.
Second page: /register
  With infos like email, password and name, register a new account in DataBase.
Third page: /login
  Log in with email and password.
Fourth page: /home
  Welcome page, with addFriend functionality and friend's list.
Fifth page: /profile
  If its the first connection, suggests to create a Balance. After you can add money on balance.
Sixth page: /transfer
  Choose a friend in friend's list, an amount, comment your transaction and send money to friends. Transaction's list showss the last ten.

And if your a good detective, you saw the logout button.

SQL script is in main/resources folder.
