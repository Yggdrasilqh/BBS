/**
 * Created by Yggdrasil on 16/12/12.
 */
function getAllLayout(){
    var layout;
    $.ajax({
        url: '/login/layout/getAll',
        async: false,
        success: function (data) {
            layout = data;
        }
    });
    return layout;
}

function getPostByLayoutId(layout_id) {
    var post;
    $.ajax({
        url: '/login/post/getByLayoutId',
        data: {'layout_id':layout_id},
        async: false,
        success: function (data) {
            post = data;
        }
    });
    return post;
}

function dateFormat(timestamp) {
    var date = new Date(parseInt(timestamp)).toLocaleString().replace(/:\d{1,2}$/,' ');
    var info = '';
    //info += date.getFullYear() + "年";
    // info += date.getMonth() + "月";
    // info += date.getDay() + "日";
    // info += date.getHours() + "时";
    // info += date.getMinutes() + "分";
    //info += date.getSeconds() + "秒";
    return date;
}