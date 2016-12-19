/**
 * Created by Yggdrasil on 16/12/12.
 */
function getAllLayout() {
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
        data: {'layout_id': layout_id},
        async: false,
        success: function (data) {
            post = data;
        }
    });
    return post;
}

function dateFormat(timestamp) {
    var date = new Date(parseInt(timestamp)).toLocaleString().replace(/:\d{1,2}$/, ' ');
    var info = '';
    //info += date.getFullYear() + "年";
    // info += date.getMonth() + "月";
    // info += date.getDay() + "日";
    // info += date.getHours() + "时";
    // info += date.getMinutes() + "分";
    //info += date.getSeconds() + "秒";
    return date;
}

function userAuthority() {
    var authority;
    $.ajax({
        url: '/login/user/getCurrAuthority',
        async: false,
        success: function (data) {
            authority = data;
        }
    });
    return authority;
}

function getUserGroup() {
    var userGroup;
    $.ajax({
        url: '/login/layout/getUserGroup',
        async: false,
        success: function (data) {
            userGroup = data;
        }
    });
    return userGroup;
}

function addLayout(layout) {
    alert(layout);
    $.ajax({
        url: '/login/layout/add',
        async: false,
        contentType: 'application/json',
        type: 'post',
        data: layout
    })
}
function deleteLayout(id) {
    alert(id);
    $.ajax({
        url: '/login/layout/deleteById',
        async: false,
        data: {'id': id}
    })
}

function register(user) {
    alert(user);
    var flag = false;
    $.ajax({
        url: '/register.action',
        method: 'post',
        contentType: 'application/json',
        data: user,
        async: false,
        success: function (data) {
            alert(data);
            flag = data == 'success';
        }
    });
    return flag;
}

function modifyInfo(user_info) {
    var flag = false;
    $.ajax({
        url: '/login/user/modifyUserInfo',
        method: 'post',
        contentType: 'application/json',
        data: user_info,
        async: false,
        success: function (data) {
            alert(data);
            flag = data == 'success';
        }
    });
    return flag;
}

function getAllUser() {
    var user;
    $.ajax({
        url: '/login/user/getAll',
        async: false,
        success: function (data) {
            user = data;
        }
    });
    return user;
}

function getLayoutName(layout_id) {
    var layoutName;
    $.ajax({
        url: '/login/layout/getName',
        data: {'layout_id': layout_id},
        async: false,
        success: function (data) {
            layoutName = data;
        }
    });
    return layoutName;
}

function findModeratorsByUser_id(user_id) {
    var moderators;
    $.ajax({
        url: '/login/user/findModeratorByUser_id',
        data: {'user_id': user_id},
        async: false,
        success: function (data) {
            moderators = data;
        }
    });
    return moderators;
}

function getAllUserInfo() {
    var users = getAllUser();
    for (var loop = 0; loop < users.length; loop++) {
        var moderators = findModeratorsByUser_id(users[loop].id);
        for (var loop2 = 0; loop2 < moderators.length; loop2++) {
            moderators[loop2] = getLayoutName(moderators[loop2]);
        }
        users[loop].layouts = moderators;
        users[loop].group_name = getGroupName(users[loop].group_id);
    }
    return users;
}

function getGroupName(group_id) {
    var group_name;
    $.ajax({
        url: '/login/user/getUserGroupNameByGroup_id',
        data: {'group_id': group_id},
        async: false,
        success: function (data) {
            group_name = data;
        }
    });
    return group_name;
}

function getInfo() {
    var info;
    $.ajax({
        url: '/login/user/getCurr',
        async: false,
        success: function (data) {
            info = data;
        }
    });
    return info;
}

$(function () {
    var user_info = $('#user-info');
    var info = getInfo();
    var info_html = '';
    info_html += info.name + '/';
    info_html += '经验值：'+ info.acc_point + '/';
    info_html += '用户组' + getGroupName(info.group_id);
    user_info.append(info_html);
});