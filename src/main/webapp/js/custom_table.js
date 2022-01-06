$(document).ready(function () {
    $('#dtBasicExample').DataTable();
    $('.dataTables_length').addClass('bs-select');
});
// Basic example
$(document).ready(function () {
    $('#dtBasicExample').DataTable({
        "ordering": false // false to disable sorting (or any other option)
    });
    $('.dataTables_length').addClass('bs-select');
});
