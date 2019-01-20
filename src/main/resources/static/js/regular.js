function checkPassword(str){
    var reg = /^[a-zA-Z]\w{5,17}$/;
    if (! reg.test(str)){
        return false;
    }
    return true;
}

function checkAccount(str){
    var reg = /^[a-zA-Z]([-_a-zA-Z0-9]{4,15})+$/;
    if (! reg.test(str)){
        return false;
    }
    return true;
}

function checkVerify(str){
    var reg = /^[0-9]{4}$/;
    if (! reg.test(str)){
        return false;
    }
    return true;
}


//判断字符是否为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}
function isBlank(obj) {
    if(!isEmpty(obj)){
        var str = obj.trim();
        if(isEmpty(str)){
            return true;
        }else {
            return false;
        }
    }else {
        return true;
    }
}