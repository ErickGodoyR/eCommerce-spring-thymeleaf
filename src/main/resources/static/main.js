
let region = ["Tarapaca","Antofagasta","Atacama","Coquimbo","Valparaiso","Libertador Bernardo OHiggins","Maule",
"Bio Bio","La Araucania","Los Lagos","Aysen",
"Magallanes","Metropolitana","Los Rios","Arica y Parinacota","Ñuble"];


let ciudad = ["Iquique","Alto Hospicio","Pozo al Monte","Camiña","Colchane","Huara","Pica",
"Antofagasta","Mejillones","Sierra Gorda","Taltal","Calama","Ollague","San Pedro de Atacama","Tocopilla","Maria Elena",
"Chañaral","Diego de Almagro","Copiapo","Caldera","Tierra Amarilla","Vallenar","Alto del Carmen","Freirina","Huasco",
"Illapel","Canela","Los Vilos","Salamanca","Coquimbo","Andacollo","La Serena","La Higuera","Paihuano","Vicuña",
"Ovalle","Combarbala","Monte Patria","Punitaqui","Rio Hurtado",
"Isla de Pascua","Los Andes","Calle Larga","Rinconada","San Esteban","Quilpue","Limache",
"Olmue","Villa Alemana","La Ligua","Cabildo","Papudo","Petorca","Zapallar","Quillota","Hijuelas","La Calera","La Cruz",
"Nogales","San Antonio","Algarrobo","Cartagena","El Quisco","El Tabo","Santo Domingo","San Felipe","Catemu","Llay Llay",
"Panquehue","Putaendo","Santa Maria","Valparaiso","Casa Blanca","Concon","Juan Fernendez","Puchuncavi","Quintero",
"Viña del Mar",
"Rancagua","Codegua","Coinco","Coltauco","Doñihue","Graneros","Las Cabras","Machali","Malloa","Mostazal",
"Olivar","Peumo","Pichidegua","Quinta de Tilcoco","Rengo","Requinoa","San Vicente de Tagua Tagua","San Fernando",
"Chepica","Chimbarongo","Lolol","Nancagua","Palmilla","Peralillo","Placilla","Santa Cruz","Pichilemu","La Estrella",
"Litueche","Marchigue","Navidad","Paredones",
"Cauquenes","Chanco","Curico","Hualañe","Licanten","Molina","Rauco","Romeral","Sagrada Familia","Teno","Vichuquen",
"Linares","Colbun","Longavi","Parral","Retiro","San Javier","Villa Alegre","Yerbas Buenas","Talca","Constitucion",
"Curepto","Empedrado","Maule","Pelarco","Pencahue","Rio Claro","San Clemente","San Rafael",
"Lebu","Arauco","Cañete","Contulmo","Curanilahue","Los Alamos","Tirua","Los Angeles","Alto Bio Bio","Antuco",
"Cabrero","Laja","Mulchen","Nacimiento","Quilaco","San Rosendo","Santa Barbara","Tucapel","Yumbel","Concepcion",
"Chiguayante","Coronel","Florida","Hualpen","Hualqui","Lota","Penco","San Pedro de la Paz","Santa Juana",
"Talcahuano","Tome",
"Temuco","Carahue","Chol Chol","Cunco","Curarrehue","Freire","Galvarino","Gorbea","Lautaro","Loncoche","Melipeuco",
"Nueva Imperial","Padre de Las Casas","Perquenco","Pitrufquen","Pucon","Saavedra","Teodo Schmidt","Tolten","Vilcun",
"Villarrica","Angol","Collipulli","Curacautin","Ercilla","Lonquimay","Los Sauces","Lumaco","Puren","Renaico",
"Traiguen","Victoria",
"Castro","Ancud","Chonchi","Curaco de Velez","Dalcahue","Puqueldon","Queilen","Quellon","Quemchi","Quinchao",
"Puerto Montt","Calbuco","Cochamo","Fresia","Frutillar","Los Muermos","Llanquihue","Maullin","Puerto Varas",
"Osorno","Puerto Octay","Purranque","Puyehue","Rio Negro","San Juan de la Costa","San Pablo","Chaiten","Futaleufu",
"Hualaihue","Palena",
"Aysen","Cisnes","Guaitecas","Cochrane","OHiggins","Tortel","Coyhaique","Lago Verde","Chile Chico","Rio Ibañez",
"Cabo de Hornos","Antartica","Punta Arenas","Laguna Blanca","Rio Verde","San Gregorio","Porvenir","Primavera",
"Timaukel","Puerto Natales","Torres del Paine",
"Colina","Lampa","Til Til","Puente Alto","Pirque","San Jose de Maipo","San Bernardo","Buin","Calera de Tango","Paine",
"Melipilla","Alhue","Curacavi","Maria Pinto","San Pedro","Santiago","Cerrillos","Cerro Navia","Conchali","El Bosque",
"Estacion Central","Huechuraba","Independencia","La Cisterna","La Florida","La Granja","La Pintana","La Reina",
"Las Condes","Lo Barnechea","Lo Espejo","Lo Prado","Macul","Maipu","Ñuñoa","Pedro Aguirre Cerda","Providencia",
"Pudahuel","Quilicura","Quinta Normal","Recoleta","Renca","San Joaquin","San Miguel","San Ramon","Vitacura","Talagante",
"El Monte","Isla de Maipo","Padre Hurtado","Peñaflor",
"La Union","Futrono","Lago Ranco","Rio Bueno","Valdivia","Corral","Lanco","Los Lagos","Mafil","Mariquina","Paillaco",
"Panguipulli",
"Arica","Camarones","Putre","General Lagos",
"Bulnes","Chillan","Chillan Viejo","El Carmen","Pemuco","Pinto","Quillon","San Ignacio","Yungay","Quirihue","Cobquecura",
"Coelemu","Ninhue","Portezuelo","Ranquil","Trehuaco","San Carlos","Coihueco","Ñiquen","San Fabian","San Nicolas"];


let combobox1 = document.getElementById('combobox1');
let combobox2 = document.getElementById('combobox2');


//recorre los arrays
function recorrer(combobox,valores){
    combobox2.innerHTML = '';

    for(let index of valores){
        combobox.innerHTML += `
        <option>${index}</option>
        `
    }

}


//completa el select de las regiones
function llenarRegion(){
    recorrer(combobox1,region);
}

llenarRegion();


//completa el select de las ciudades dependiendo de la selección de la región
combobox1.addEventListener('change',(e)=>{
    let dato = e.target.value;

    switch(dato){
        case 'Tarapaca':
              recorrer(combobox2,ciudad.slice(0,7))
            break;
        case 'Antofagasta':
              recorrer(combobox2,ciudad.slice(7,16))
            break;
        case 'Atacama':
              recorrer(combobox2,ciudad.slice(16,25))
            break;
        case 'Coquimbo':
              recorrer(combobox2,ciudad.slice(25,40))
            break;
        case 'Valparaiso':
              recorrer(combobox2,ciudad.slice(40,78))
            break;
        case 'Libertador Bernardo OHiggins':
              recorrer(combobox2,ciudad.slice(78,110))
            break;
        case 'Maule':
              recorrer(combobox2,ciudad.slice(110,139))
            break;
        case 'Bio Bio':
              recorrer(combobox2,ciudad.slice(139,170))
            break;
        case 'La Araucania':
              recorrer(combobox2,ciudad.slice(170,202))
            break;
        case 'Los Lagos':
              recorrer(combobox2,ciudad.slice(202,232))
            break;
        case 'Aysen':
              recorrer(combobox2,ciudad.slice(232,242))
            break;
        case 'Magallanes':
              recorrer(combobox2,ciudad.slice(242,253))
            break;
        case 'Metropolitana':
              recorrer(combobox2,ciudad.slice(253,304))
            break;
        case 'Los Rios':
              recorrer(combobox2,ciudad.slice(304,316))
            break;
        case 'Arica y Parinacota':
              recorrer(combobox2,ciudad.slice(316,320))
            break;
        case 'Ñuble':
              recorrer(combobox2,ciudad.slice(320,341))
            break;
        default:
            break;
    }
});


//pasa a información del combobox2 al combobox3
$(`#combobox2`).on(`change`, function(){
	var valor = this.value;
	var texto = $(this).find(`option:selected`).text();

	$(`#ciudad`).val(valor);
	//alert(valor);

});



/*
function filter_options(){
	if (typeof $("#choice1").data('options') === "undefined") {
       $("#choice1").data('options', $('#choice2 option').clone());
  }
    var id = $("#choice1").val();
    var options = $("#choice1").data('options').filter('[data-option=' + id + ']');
    $('#choice2').html(options);
}

$(function () {
		//Ejecutar el filtro la primera vez
		filter_options();

    //actualizar al cambiar el factor
    $("#choice1").change(function () {
	    filter_options();
		});

});
*/
