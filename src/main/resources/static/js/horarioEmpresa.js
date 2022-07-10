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
        slotMinTime: horaApertura,
        slotMaxTime: horaCierre,
        slotDuration: '00:15:00',  // franjas de 15 minutos
        events: reservas,
        eventOverlap: false,
        dateClick: function (info){
            var hoy = new Date();
            hoy.setHours(0,0,0,0,);
            if(info.date >= hoy) {
                frm.reset();
                document.getElementById('start').value = info.dateStr.substring(0, 10);
                document.getElementById('username').value = customerUsername;
                document.getElementById("optionDefault").hidden = false;
                document.getElementById("optionDefault").value = "";
                document.getElementById("optionDefault").text = "Selecciona servicio";
                modalCrearCita.show();
            }
        }
    });
    calendar.render();
});