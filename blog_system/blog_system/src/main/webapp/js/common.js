//通过此函数来查看登陆状态
function getUserInfo(htmlName){
    $.ajax({
        type:'get',
        url:'login',
        success:function(body){
            //判断此处的body是不是一个有效的user对象，也就是userId是否为0
          if(body.userId && body.userId > 0){
            //登录成功不做处理，可以在控制台上打印一下
            console.log("当前是处在登陆状态");
            if(htmlName == 'blog_list.html'){
                //修改列表页的用户名字为username
               changeName(body.username);
            }
          }else{
            //登录状态不成功，跳转到登录页面
            alert('当前您尚未登录，请登陆后在访问！')
            location.assign("blog_login.html");
          }
        }
    })

}


function changeName(username){
    let nameDiv = document.querySelector('.card>h3');
    nameDiv.innerHTML = username;
}

//把博客详情页的作者栏改成该博客的作者
function authorInfo(){
    $.ajax({
        type:'get',
        url:'authorInfo'+location.search,
        success:function(body){
            if(body.userName){
                //如果作者的名字拿到了
                changeName(body.userName);
            }else{
                console.log('该作者不存在');
            }
        }
    });
}