//记住我
function jzmy() {
    if($("#jzmy").prop("checked")){
        var username = Cookies.get("username");
        var password = Cookies.get("password");
        if(isBlank(username)||isBlank(password)){
            username = $("input[name=username]").val();
            password = $("input[name=password]").val();
            Cookies.set('username', username, { expires: 1, path: '/' });
            Cookies.set('password', password, { expires: 1, path: '/' });
        }
        $("input[name=username]").val(username);
        $("input[name=password]").val(password);
    }
}
