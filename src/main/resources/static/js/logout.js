function logout() {
    $.removeCookie('access_token', {path: '/'});
    $.removeCookie('refresh_token', {path: '/'});
    alert('로그아웃 되었습니다.')
    window.location.href = '/';
}