function diaLaboral(dia){
    switch (dia){
        case 0:
            return domingo;
            break;
        case 1:
            return lunes;
            break;
        case 2:
            return martes;
            break;
        case 3:
            return miercoles;
            break;
        case 4:
            return jueves;
            break;
        case 5:
            return viernes;
            break;
        case 6:
            return sabado;
            break;
    }
}
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
            if(info.date >= hoy && diaLaboral(info.date.getDay())) {
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