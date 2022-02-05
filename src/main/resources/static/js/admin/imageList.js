// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#imageTable').DataTable();
});


/**
 * 모달 창 OPEN
 */

$("#imageTable tbody tr").on("click", function() {

    // 이미지 ID
    let id = $(this).children(".id").text();
    // 이미지명 (제목)
    let title = $(this).children(".title").text();
    // 구분
    let channelName = $(this).children(".channelName").text();
    // 링크
    let link = $(this).children(".link").text();
    // 이미지 이름
    let imgName = $(this).children(".imgName").text();

    $('#modalLabel').text(title);

    $('#id').val(id);
    $('#title').val(title);
    $('#channelName').val(channelName).prop("selected", true);
    $('#link').val(link);
    $('#imgName').val(imgName);

    $('#imageModal').modal('show');
});

/**
 * 수정
 */
$('#btnUpdate').on('click', function() {

    let id = $("#id").val();
    let link = $("#link").val();

    if(!link) {
        alert("링크를 입력해 주세요.");
        $("#link").focus();

        return;
    }

    $('#imgForm').attr("method", "post");
    $('#imgForm').attr("action", "/images/" + id + "/edit")
    $('#imgForm').submit();

});

/**
 * 삭제
 */
$('#btnDelete').on('click', function() {

    let id = $("#id").val();

    $('#imgForm').attr("method", "post");
    $('#imgForm').attr("action", "/images/" + id + "/delete")
    $('#imgForm').submit();

});