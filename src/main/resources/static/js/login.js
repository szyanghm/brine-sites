/*
---------------------------
-Click on the Button Join !-
---------------------------
*/


var t = 1;

function join_1(){
if(t == 0){  document.querySelectorAll('.cont_letras > p')[0].style.left = '200px';
  document.querySelectorAll('.cont_letras > p')[1].style.left = '-320px';
  document.querySelectorAll('.cont_letras > p')[2].style.left = '200px';
setTimeout(function(){
  document.querySelector('.cont_join').className = 'cont_join cont_join_form_act';
},1000);    
t++;
          }else{
t++;            
document.querySelector('.cont_form_join').style.bottom = '-420px';
            
           
setTimeout(function(){               
	document.querySelector('.cont_join').className = 'cont_join cont_join_form_act cont_join_finish';
    }
   ,500);
  }           
           
}

//获取验证码
function getVerify(){
    var basepath = $("#imgVerify").attr("codeName");
    basepath = basepath + "/sys/getVerify?"+Math.random();
    $("#imgVerify").attr("src",basepath);
}

$(function () {
    //记住密码
    jzmy();
    $("#sub").click(function(){
        // $('#subform').submit();
        var password = $("input[name=password]").val();
        var username = $("input[name=username]").val();
        if(!checkAccount(username)){
            $(".error_msg").text("帐号输入错误(Account Input Error.)");
            return;
        }else{
            $(".error_msg").text("");
        }
        if(!checkPassword(password)){
            $(".error_msg").text("密码输入错误(Password Input  Error.)");
            return;
        }else{
            $(".error_msg").text("");
        }
        //校验验证码
        var inputVerify = $(".inputVerify").val();
        if(inputVerify!=null&&inputVerify!=''){
            if(!checkVerify(inputVerify)){
                $(".error_msg").text("验证码输入错误(Account Input Error.)");
                return;
            }
        }

        var char=password.substring(1,3);password=password.replace(char,char+"abc");
        password = md5(password);

        var param = {
            'account': username,
            'password': password,
            'verify':inputVerify
        };
        $.ajax({
            type: "POST",
            url: "/sys/login",
            headers: {
                "Content-Type": "application/json; charset=utf-8"
            },
            data:JSON.stringify(param),
            dataType: "JSON",
            success: function(data){
                window.location.href='/sys/page/index';
            }
        });
    });
    $('input[name=username]').live('input propertychange', function() {
        var account = $('input[name=username]').val();
        var code = Cookies.get(account+'verifcation_code');
        if(code>=3){
            $(".display_n").show();
            getVerify();
        }else{
            $(".display_n").hide();
        }
    })

})
