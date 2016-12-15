
/**
 * Created by chenq on 2016/12/12,012.
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
function getLocalTime(nS) {
    return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');
}

function getUserNameById(id) {
    var name = "";
    $.ajax({
        url: '/login/user/getName',
        type: 'get',
        async: false,
        data: {"id": id},
        success: function (data) {
            name = data;
        }
    });
    return name;
}



function getUserId() {
    var id = "";
    $.ajax({
        url:'/login/user/getUserId',
        type:'get',
        async:false,
        success:function (data) {
            id=data;
        }
    });
    return id;
}