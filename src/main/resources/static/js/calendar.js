var modalCrearCita = new bootstrap.Modal(document.getElementById('modalCrear'));
let frm = document.getElementById("formCrear");
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth',
        locale: 'es',
        headerToolbar: {
            left: 'prev, next, today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay, listWeek'
        },
        slotMinTime: '08:00:00',
        slotMaxTime: '21:00:00',
        slotDuration: '00:15:00',  // franjas de 15 minutos
        height: '100%',
        dateClick: function (info){
            document.getElementById('start').value = info.dateStr;
            modalCrearCita.show();
        }
    });
    calendar.render();
});