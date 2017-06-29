//로그인 사용자 정보를 가져온다.

$.getJSON(/*contextRoot +*/ '/auth/userinfo.json', function(result) {
  if (result.data != undefined){
  $('#login').append($('<span>').html(result.data.name + '(' + result.data.email + ')'))
             .append($('<a>').attr('id', 'logout-link').attr('href', '#').text('    로그아웃'))
  }
})

$(document.body).on('click', '#logout-link', function(event){
  $.getJSON(/*contextRoot + */'/auth/logout.json', function(result) {
    location.href = '/teacher/index.html'
  })
})