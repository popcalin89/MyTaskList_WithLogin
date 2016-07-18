
function listTasks(tasks) {// modificari
    var myTaskHTML = document.getElementById('myTaskHTML')
    var listHtml = '';

    for (var i = 0; i < tasks.length; i++) {
        var task = tasks[i];
        //var checked = task.done ? ' checked=""' : '';
        var taskHtml =
            '<ul>' +
                //'<input type="checkbox"' + checked + ' value="' + task.id + '" onclick=markDone("' + task.id + '")>' +
            '<input type="checkbox" value="' + task.id + '" onclick=markDone("' + task.id + '")>' +
            task.task +
            '</ul>';
        listHtml += taskHtml;
    }
    myTaskHTML.innerHTML = listHtml;
}

function markDone(id) {
    $.ajax({
        url: 'items?action=done&id='+id
    }).done(function (response) {
        loadTasks();
    });
}

function loadTasks() {
    $.ajax({
        url: 'items?action=list'
    }).done(function (response) {
        listTasks(response.myTask);
    });
}

function addTask() {
    var toDoText = document.getElementById('todoid').value;
    $.ajax({
        url: 'items?action=add&value='+toDoText
    }).done(function (response) {
        location.href = "todolist.html";
    });
}