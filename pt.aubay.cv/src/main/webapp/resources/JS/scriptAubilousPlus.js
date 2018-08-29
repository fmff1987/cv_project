var timer;
function colorStatus() {
	console.log("colorStatus Admin");
	var statusColorHtmlCollection = $('.status .ui-cell-editor-output');
	var statusColorArray = Array.from(statusColorHtmlCollection);
	statusColorArray.forEach(function (element) {
		switch (element.innerHTML) {
		case "Em Analise":
			element.style.cssText = "color:blue;  font-weight: bold;"
				break;
		case "Reprovado":
			element.style.cssText = "color:red;  font-weight: bold;"
				break;
		case "Aguardando Aprovação":
			element.style.cssText = "color:green;  font-weight: bold;"
				break;
		default:
			break;
		}
	});
}
function colorStatusForRec() {
	console.log("colorStatusForRec rec");
	var statusColorHtmlCollection = $('.status');
	var statusColorArray = Array.from(statusColorHtmlCollection);
	statusColorArray.forEach(function (element) {
		switch (element.innerHTML) {
		case "Em Analise":
			element.style.cssText = "color:blue;  font-weight: bold;"
				break;
		case "Reprovado":
			element.style.cssText = "color:red;  font-weight: bold;"
				break;
		case "Aguardando Aprovação":
			element.style.cssText = "color:green;  font-weight: bold;"
				break;
		default:
			break;
		}
	});
}


function colorDeadLineUltimate() {
	if(timer){
		clearInterval(timer);
	}
	console.log("Ultimate deadLine");
	const ONEDAY = 1000 * 60 * 60 * 24;
	var nowDate = new Date();

	var deadLineHtmlCollection = $('.deadLine .ui-cell-editor-output');
	var deadLineHtmlArray = Array.from(deadLineHtmlCollection);

	deadLineHtmlArray.forEach(element => {

		var dayDeadLineDate = element.innerHTML.slice(0, 2);
		var mesDeadLineDate = element.innerHTML.slice(3, 5);
		var anoDeadLineDate = element.innerHTML.slice(6, 11);

		var convertDeadDate = new Date(mesDeadLineDate + "/" + dayDeadLineDate + "/" + anoDeadLineDate);
		var difDate = (Math.abs(convertDeadDate - nowDate) / ONEDAY).toFixed(0);
		console.log(difDate);
		
		
		switch (true) {
		case difDate >= 12:
			element.style.cssText = "color:green;font-weight: bold;";
		break;
		case difDate >= 6 && difDate < 12: 
			element.style.cssText = "color:orange;font-weight: bold;";
		break;
		case difDate >= 2 && difDate <= 6:
			element.style.cssText = "color:red;font-weight: bold;";
		break;
		case difDate <= 1.9:
			element.style.cssText = "color:red;font-weight: bold;";
			$(element).addClass('danger');
		break;

		default:
			break;
		}

	});
		timer = setInterval(function () {
			$('tr:not(.ui-row-editing) .danger').toggle();

		}, 800);

}
function colorDeadLineForRec() {
	console.log("Ultimate deadLine Rec");
	const ONEDAY = 1000 * 60 * 60 * 24;
	var nowDate = new Date();

	var deadLineHtmlCollection = $('.deadLine .deadlineRec');
	var deadLineHtmlArray = Array.from(deadLineHtmlCollection);

	deadLineHtmlArray.forEach(element => {
		console.log(element);
		var dayDeadLineDate = element.innerText.slice(0, 2);
		var mesDeadLineDate = element.innerText.slice(3, 5);
		var anoDeadLineDate = element.innerText.slice(6, 11);

		var convertDeadDate = new Date(mesDeadLineDate + "/" + dayDeadLineDate + "/" + anoDeadLineDate);
		var difDate = (Math.abs(convertDeadDate - nowDate) / ONEDAY).toFixed(0);
		console.log(difDate);

		$(element).css('font-weight','bold');

		switch (true) {
		case difDate >= 12:
			$(element).css('color','green');
		break;
		case difDate >= 6 && difDate < 12: 
			$(element).css('color','orange');
		break;
		case difDate >= 2 && difDate <= 6:
			$(element).css('color','red');
		break;
		case difDate <= 1.9:
			$(element).css('color','red');
		 setInterval(function () {

			$(element).toggle();

		}, 800);
		break;

		default:
			break;
		}

	});

}
