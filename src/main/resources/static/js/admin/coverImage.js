/**
 * 커버 이미지 변경 모달 창 OPEN
 */

$("#btn-coverImg-modal").on("click", function() {
    $('#modal-coverImg-edit').modal('show');
});

/**
 * 수정
 */
$('#btn-coverImg-edit').on('click', function() {

    let file = $("#file").val();

    if(!file) {
        alert("파일을 선택해주세요.");

        return;
    }

     $('#coverImgEditForm').submit();
});

/**
 * 파일용량 확인
 */
$("#file").off().on("change", function() {
    if (this.files && this.files[0]) {

        var maxSize = 1 * 1024 * 1024;
        var fileSize = this.files[0].size;

        if(fileSize > maxSize){
            alert("첨부파일 사이즈는 1MB 이내로 등록 가능합니다.");
            $(this).val('');
            return false;
        }
    }
});