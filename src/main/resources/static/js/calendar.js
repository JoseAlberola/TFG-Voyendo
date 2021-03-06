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
        editable: true,
        eventOverlap: false,
        eventAllow: function (dropInfo, draggedEvent){
            var fechaCierre = dropInfo.startStr.substring(0, 10);
            var fechaCierreDate = new Date(fechaCierre + " " + horaCierre);
            return dropInfo.end <= fechaCierreDate && diaLaboral(dropInfo.start.getDay());
        },
        dateClick: function (info){
            if(diaLaboral(info.date.getDay())){
                frm.reset();
                document.getElementById("idappointment").value = 0;
                document.getElementById("btnEliminar").classList.add("d-none");
                document.getElementById('start').value = info.dateStr.substring(0, 10);
                document.getElementById("tituloModal").textContent = "Crear cita";
                document.getElementById("btnAceptar").textContent = "Aceptar";
                document.getElementById("optionDefault").hidden = false;
                document.getElementById("optionDefault").value = "";
                document.getElementById("optionDefault").text = "Selecciona servicio";
                modalCrearCita.show();
            }
        },
        eventClick: function (info){
            document.getElementById("btnEliminar").classList.remove("d-none");
            document.getElementById("tituloModal").textContent = "Modificar cita";
            document.getElementById("btnAceptar").textContent = "Modificar";
            document.getElementById("idappointment").value = info.event.id;
            document.getElementById("username").value = info.event.extendedProps.username;
            document.getElementById("start").value = info.event.startStr.substring(0, 10);
            document.getElementById("starthour").value = info.event.extendedProps.starthour;
            document.getElementById("optionDefault").text = info.event.title;
            document.getElementById("optionDefault").value = info.event.extendedProps.idlabour;
            document.getElementById("idlabour").value = info.event.extendedProps.idlabour;

            var opcionDefault = document.getElementById("optionDefault");
            opcionDefault.hidden = false;
            var optionsSelect = document.getElementsByClassName("opcionesDinamicas");
            for(var i = 0; i < optionsSelect.length; i++){
                if(optionsSelect[i].value == opcionDefault.value){
                    opcionDefault.hidden = true;
                }
            }

            modalCrearCita.show();
        },
        eventDrop: function (info){
            const idappointment = info.event.id;
            const fecha = info.event.startStr.substring(0, 10);  // Extraemos la fecha en formato yyyy-MM-dd de la cadena
            const horaInicio = info.event.startStr.substring(11, 16);  // Extraemos la hora de inicio de la cadena
            const horaFin = info.event.endStr.substring(11, 16);  // Extraemos la hora de fin de la cadena
            const cita = {
                "date": fecha,
                "starthour": horaInicio,
                "endhour": horaFin
            };
            var url = "/reservas/" + idappointment + "/mover";
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                redirect: "follow",
                body: JSON.stringify(cita)
            }).then((res) => {
                swalWithBootstrapButtons.fire(
                    '??Hecho!',
                    'Reserva movida de fecha.',
                    'success'
                )
            })
        }
    });
    calendar.render();
});