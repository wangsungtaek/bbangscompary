// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#collaboTable').DataTable();
});


/**
 * 모달 창 OPEN
 */

$("#collaboTable tbody tr").on("click", function() {

    // 이미지 ID
    let id = $(this).children(".id").text();
    // 협력사명
    let name = $(this).children(".name").text();
    // 링크
    let link = $(this).children(".link").text();
    // 이미지 이름
    let imgName = $(this).children(".imgName").text();

    $('#modalLabel').text(name);

    $('#id').val(id);
    $('#name').val(name);
    $('#link').val(link);
    $('#imgName').val(imgName);

    $('#collaboModal').modal('show');
});

/**
 * 수정
 */
$('#btnUpdate').on('click', function() {

    let id = $("#id").val();

    $('#collaboForm').attr("method", "post");
    $('#collaboForm').attr("action", "/collaborates/" + id + "/edit")
    $('#collaboForm').submit();

});

/**
 * 삭제
 */
$('#btnDelete').on('click', function() {

    let id = $("#id").val();

    $('#collaboForm').attr("method", "post");
    $('#collaboForm').attr("action", "/collaborates/" + id + "/delete")
    $('#collaboForm').submit();

});